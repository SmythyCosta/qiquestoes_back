package qiquestoes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qiquestoes.persistence.dao.BaseDao;

public class GenericRestController<T> {

	@Autowired
	private BaseDao<T> dao;

	/*
	 * Documentacao para a paginação
	 * https://docs.spring.io/spring-data/rest/docs/2.0.0.M1/reference/html/paging-chapter.html
	 * */
	@RequestMapping(method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> list(Pageable pageable) { 
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);  
	}

	@RequestMapping(method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> create(@Valid @RequestBody T entity) { 
		return new ResponseEntity<>(dao.save(entity),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> update(@PathVariable(value = "id") long id,@Valid @RequestBody T entity) { 
		Optional<T> t = dao.findById(id);
		if (!t.isPresent()) {
			return new ResponseEntity<>("Not found for ID: "+id+"", HttpStatus.BAD_REQUEST);
		}
		dao.save(entity); 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) { 
		
		Optional<T> t = dao.findById(id);
		if (!t.isPresent()) {
			return new ResponseEntity<>("Not found for ID: "+id+"", HttpStatus.BAD_REQUEST);
		}
		
		dao.deleteById(id); 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<?> get(@PathVariable(value = "id") long id) { 
	
		Optional<T> t = dao.findById(id);
		if (!t.isPresent()) {
			return new ResponseEntity<>("Not found for ID: "+id+"", HttpStatus.BAD_REQUEST);
		}
	
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	
}
