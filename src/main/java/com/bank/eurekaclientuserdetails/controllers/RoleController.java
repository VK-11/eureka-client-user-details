
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

import com.bank.eurekaclientuserdetails.entity.Role;
import com.bank.eurekaclientuserdetails.entity.User;
import com.bank.eurekaclientuserdetails.helper.IBaseController;
import com.bank.eurekaclientuserdetails.helper.constants.IRestConstants;
import com.bank.eurekaclientuserdetails.services.RoleService;


/**
 * @author 
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR + IRestConstants.ROLE)
public class RoleController implements IBaseController<Role, Long>, IRestConstants {

	@Autowired
	RoleService roleService;

	@GetMapping()
	@Override
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@PutMapping()
	@Override
	public Role save(@RequestBody Role entity) {
		return roleService.save(entity);
	}

	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Role update(@PathVariable(ID) Long id, @RequestBody Role entity){
		return roleService.update(id, entity);
	}

	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		roleService.delete(id);
	}

	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public Role findOne(@PathVariable(ID) Long id) {
		return roleService.findOne(id);
	}

	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET + SEPARATOR + USER)
	public List<User> getUserByRole(@PathVariable(ID) Long roleId) {
		return roleService.getUserByRole(roleId);
	}

}
