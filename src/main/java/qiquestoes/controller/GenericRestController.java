package qiquestoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qiquestoes.persistence.dao.BaseDao;
import qiquestoes.util.ResourceNotFoundException;

public class GenericRestController<T> {

	@Autowired
	private BaseDao<T> dao;
	
	/*
	 * Documentacao para a paginação
	 * https://docs.spring.io/spring-data/rest/docs/2.0.0.M1/reference/html/paging-chapter.html
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list(Pageable pageable) { 
		return new ResponseEntity<>(dao.findAll(pageable), HttpStatus.OK);  
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody T entity) { 
		return new ResponseEntity<>(dao.save(entity),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable(value = "id") long id,@Valid @RequestBody T entity) { 
		verifyIfExistsT(id);
		dao.save(entity); 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id) { 
		verifyIfExistsT(id);
		dao.deleteById(id); 
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable(value = "id") long id) { 
		verifyIfExistsT(id);
		T obj = (T) dao.findById(id); 
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	private void verifyIfExistsT(Long id){
        if (dao.findById(id) == null)
            throw new ResourceNotFoundException("not found for ID: "+id);
    }
}
