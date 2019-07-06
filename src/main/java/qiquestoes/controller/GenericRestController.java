package qiquestoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class GenericRestController<T> {

	@Autowired
	private Repository<T> r;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() { return r.findAll(); }

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity) { return r.save(entity); }

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) { return r.save(entity); }

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) { r.delete(id); }

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") long id) { return r.getOne(id); }

}
