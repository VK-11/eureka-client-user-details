package com.bank.eurekaclientuserdetails.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.entity.UserRoleMapping;
import com.bank.eurekaclientuserdetails.helper.IBaseService;
import com.bank.eurekaclientuserdetails.repositories.UserRoleMappingRepository;


/**
 * @author
 *
 */
@Service
public class UserRoleMappingService implements IBaseService<UserRoleMapping, Long> {

	@Autowired
	UserRoleMappingRepository userRoleMappingRepository;

	@Override
	public List<UserRoleMapping> findAll() {
		return userRoleMappingRepository.findAll();
	}

	@Override
	public UserRoleMapping save(UserRoleMapping entity) {
		return userRoleMappingRepository.save(entity);
	}

	@Override
	public UserRoleMapping update(Long id, UserRoleMapping entity)  {
		UserRoleMapping userRole = findOne(id);
		if (userRole != null) {
			userRole.setUser(entity.getUser());
			userRole.setRole(entity.getRole());
			return userRoleMappingRepository.save(userRole);
		}
		return null;
		
	}

	@Override
	public void delete(Long id) {
		UserRoleMapping userRole = findOne(id);
		if (userRole != null) {
			userRole.setDeleted(true);
			userRoleMappingRepository.save(userRole);
		} else {
			
		}
	}

	@Override
	public UserRoleMapping findOne(Long id) {
		return userRoleMappingRepository.getOne(id);
	}

	/**
	 * Get All Users for Specified Role
	 * 
	 * @param roleId Role Id
	 * @return List of All user for Role Id
	 */
	public List<User> getUserByRole(Long roleId) {
		return userRoleMappingRepository.getUserByRole(roleId);
	}

	/**
	 * Get All Roles for Specified User
	 * 
	 * @param userId User Id
	 * @return List for All Roles for user
	 */
	public List<UserRoleMapping> getRoleForUser(Long userId) {
		return userRoleMappingRepository.getRoleForUser(userId);
	}
}
