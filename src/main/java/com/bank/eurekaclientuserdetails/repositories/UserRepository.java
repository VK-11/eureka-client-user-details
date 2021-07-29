package com.bank.eurekaclientuserdetails.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.helper.IBaseRepository;

/**
 * @author
 *
 */
@Repository
public interface UserRepository extends IBaseRepository<User, Long> {

	@Query("select a from User a where a.deleted = false")
	public List<User> findAll();

	@Query("select a from User a where a.id =:id and a.deleted = false")
	public User getOne(Long id);

}
