package com.bank.eurekaclientuserdetails.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.eurekaclientuserdetails.entity.Role;
import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.helper.IBaseService;
import com.bank.eurekaclientuserdetails.repositories.RoleRepository;

/**
 * @author
 *
 */
@Service
public class RoleService implements IBaseService<Role, Long> {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRoleMappingService userRoleMappingService;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role save(Role entity) {
		return roleRepository.save(entity);
	}

	@Override
	public Role update(Long id, Role entity) {
		Role role = findOne(id);
		if (role != null) {
			role.setRoleName(entity.getRoleName());
			role.setRoleValue(entity.getRoleValue());
			return roleRepository.save(role);
		}
		return null;
	}

	@Override
	public void delete(Long id){
		Role role = findOne(id);
		if (role != null) {
			role.setDeleted(true);
			roleRepository.save(role);
		} 
	}

	@Override
	public Role findOne(Long id) {
		return roleRepository.getOne(id);
	}

	/**
	 * Get All Users for Specified Role
	 * 
	 * @param roleId Role Id
	 * @return List of All user for Role Id
	 */
	public List<User> getUserByRole(Long roleId) {
		return userRoleMappingService.getUserByRole(roleId);
	}
}
