package com.bank.eurekaclientuserdetails.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.eurekaclientuserdetails.entity.Role;
import com.bank.eurekaclientuserdetails.helper.IBaseRepository;

/**
 * @author
 *
 */
@Repository
public interface RoleRepository extends IBaseRepository<Role, Long> {

	@Query("select a from Role a where a.deleted = false")
	public List<Role> findAll();

	@Query("select a from Role a where a.id =:id and a.deleted = false")
	public Role getOne(Long id);

}
