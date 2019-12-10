package qiquestoes;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import qiquestoes.persistence.enums.RoleNameEnum;
import qiquestoes.persistence.model.Role;
import qiquestoes.persistence.model.User;
import qiquestoes.persistence.repository.IRoleRepository;
import qiquestoes.persistence.repository.IUserRepository;

@SpringBootApplication
public class QIQuestoesApplication {
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
    PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(QIQuestoesApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			
//			/*
//			 * 
//			 * *******************
//			 * Role Save H2
//			 * 
//			 * *******************
//			 * 
//			 * */
//			// Set Role
//			Role role = new Role();
//			role.setName(RoleNameEnum.ROLE_ADMIN);
//			
//			Role role1 = new Role();
//			role1.setName(RoleNameEnum.ROLE_USER);
//			
//			// Persiste Role
//			this.roleRepository.save(role);
//			this.roleRepository.save(role1);			
//			
//			/*
//			 * 
//			 * *******************
//     		 * User Save H2
//			 * 
//			 * *******************
//			 * 
//			 * */
//			User user = new User();
//			user.setName("Admin2 System");
//			user.setUsername("admin2");
//			user.setEmail("admin2@email.com");
//			user.setPassword(encoder.encode("123456"));	
//			Set<Role> roles = new HashSet<>();
//			roles.add(role);
//			user.setRoles(roles);
//			
//			User user1 = new User();
//			user1.setName("Common User2");
//			user1.setUsername("user2");
//			user1.setEmail("user2@email.com");
//			user1.setPassword(encoder.encode("123456"));	
//			Set<Role> roles1 = new HashSet<>();
//			roles1.add(role1);
//			user1.setRoles(roles1);
//			
//			this.userRepository.save(user);
//			this.userRepository.save(user1);
//			
//			
//		};
//
//	}
	
}
