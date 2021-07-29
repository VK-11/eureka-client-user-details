package com.bank.eurekaclientuserdetails.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.entity.UserRoleMapping;
import com.bank.eurekaclientuserdetails.helper.IBaseController;
import com.bank.eurekaclientuserdetails.helper.constants.IRestConstants;
import com.bank.eurekaclientuserdetails.services.UserService;


/**
 * @author
 *
 *         /api/user
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.USER)
public class UserController implements IBaseController<User, Long>, IRestConstants {

	@Autowired
	UserService userService;

	@GetMapping()
	@Override
	public List<User> findAll() {
		return userService.findAll();
	}

	@PutMapping()
	@Override
	public User save(@RequestBody User entity) {
		return userService.save(entity);
	}

	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public User update(@PathVariable(ID) Long id, @RequestBody User entity) {
		return userService.update(id, entity);
	}

	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		userService.delete(id);
	}

	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public User findOne(@PathVariable(ID) Long id) {
		return userService.findOne(id);
	}

	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET + SEPARATOR + ROLE)
	public List<UserRoleMapping> getRoleForUser(@PathVariable(ID) Long userId) {
		return userService.getRoleForUser(userId);
	}
}
