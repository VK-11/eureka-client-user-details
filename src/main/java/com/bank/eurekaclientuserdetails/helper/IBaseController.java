package com.bank.eurekaclientuserdetails.helper;

import java.util.List;

/**
 * @author
 *
 */
public interface IBaseController<T, ID> {

	/**
	 * GET - api/{T}
	 * 
	 * Get All Entity List where deleted is false
	 * 
	 * @return List of Entity
	 */
	public List<T> findAll();

	/**
	 * PUT - api/{T}
	 * 
	 * Save the Entity Instance
	 * 
	 * @param entity Instance of Entity
	 * @return New Created Instance
	 */
	public T save(T entity);

	/**
	 * POST - api/{T}/{id}
	 * 
	 * Update the Entity Instance
	 * 
	 * @param id     Id of the Entity Instance
	 * @param entity Data to Update Entity Instance
	 * @return Update Entity Instance
	 * 
	 */
	public T update(ID id, T entity);

	/**
	 * DELETE - api/{T}/{id}
	 * 
	 * Delete the Entity Instance
	 * 
	 * @param id Id of the Entity Instance
	 * @throws Exception
	 */
	public void delete(ID id);

	/**
	 * GET - api/{T}/{id}
	 * 
	 * Get One Entity Instance
	 * 
	 * @param id Id of the Entity Instance
	 * @return Entity Instance
	 */
	public T findOne(ID id);
}
