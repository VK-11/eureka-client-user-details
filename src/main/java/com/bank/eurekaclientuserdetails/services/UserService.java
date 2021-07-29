package com.bank.eurekaclientuserdetails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.entity.UserRoleMapping;
import com.bank.eurekaclientuserdetails.helper.IBaseService;
import com.bank.eurekaclientuserdetails.repositories.UserRepository;

/**
 * @author
 *
 */
@Service
public class UserService implements IBaseService<User, Long> {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleMappingService userRoleMappingService;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User update(Long id, User entity) {
		User user = findOne(id);
		if (user != null) {
			user.setEmail(entity.getEmail());
			user.setFirstName(entity.getFirstName());
			user.setLastName(entity.getLastName());
			user.setPassword(entity.getPassword());
			user.setMobile(entity.getMobile());
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		User user = findOne(id);
		if (user != null) {
			user.setDeleted(true);
			userRepository.save(user);
		} 
	}

	@Override
	public User findOne(Long id) {
		return userRepository.getOne(id);
	}

	/**
	 * Get All Roles for Specified User
	 * 
	 * @param userId User Id
	 * @return List for All Roles for user
	 */
	public List<UserRoleMapping> getRoleForUser(Long userId) {
		return userRoleMappingService.getRoleForUser(userId);
	}
}
