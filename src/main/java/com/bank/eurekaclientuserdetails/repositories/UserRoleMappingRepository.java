package com.bank.eurekaclientuserdetails.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.entity.UserRoleMapping;
import com.bank.eurekaclientuserdetails.helper.IBaseRepository;

/**
 * @author
 *
 */
@Repository
public interface UserRoleMappingRepository extends IBaseRepository<UserRoleMapping, Long> {

	@Query("select a from UserRoleMapping a where a.deleted = false")
	public List<UserRoleMapping> findAll();

	@Query("select a from UserRoleMapping a where a.id =:id and a.deleted = false")
	public UserRoleMapping getOne(Long id);

	@Query("select a.user from UserRoleMapping a where a.deleted = false and a.role.id = :roleId and a.role.deleted = false and a.user.deleted = false")
	public List<User> getUserByRole(Long roleId);

	@Query("select a from UserRoleMapping a where a.deleted = false and a.user.id = :userId and a.role.deleted = false and a.user.deleted = false")
	public List<UserRoleMapping> getRoleForUser(Long userId);
}
