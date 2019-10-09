package qiquestoes.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import qiquestoes.controller.dto.request.LoginForm;
import qiquestoes.controller.dto.request.SignUpRequest;
import qiquestoes.controller.dto.response.ApiResponse;
import qiquestoes.controller.dto.response.JwtResponse;
import qiquestoes.exceptions.AppException;
import qiquestoes.persistence.enums.RoleNameEnum;
import qiquestoes.persistence.model.Role;
import qiquestoes.persistence.model.User;
import qiquestoes.persistence.repository.RoleRepository;
import qiquestoes.persistence.repository.UserRepository;
import qiquestoes.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @ApiOperation(value="Efetua login na aplicação")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginForm.getUsername(),
                		loginForm.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    
    @ApiOperation(value="Faz o cadastro de novos usuarios")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    	if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Nome de usuário já cadastrado!"),
                    HttpStatus.BAD_REQUEST);
        }
    	
    	if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email já cadastrado!"),
                    HttpStatus.BAD_REQUEST);
        }
    	
    	User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());
    	
    	user.setPassword(encoder.encode(user.getPassword()));
    	
    	Role userRole = roleRepository.findByName(RoleNameEnum.ROLE_USER)
                .orElseThrow(() -> new AppException("Função do usuário não definida."));
    	
    	User result = userRepository.save(user);
    	
    	URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
    	
    	return ResponseEntity.created(location).body(new ApiResponse(true, "Usuário registrado com sucesso"));
    	
    }
}