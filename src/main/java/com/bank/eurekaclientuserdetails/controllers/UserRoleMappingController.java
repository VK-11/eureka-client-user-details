
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

import com.bank.eurekaclientuserdetails.entity.UserRoleMapping;
import com.bank.eurekaclientuserdetails.helper.IBaseController;
import com.bank.eurekaclientuserdetails.helper.constants.IRestConstants;
import com.bank.eurekaclientuserdetails.services.UserRoleMappingService;


/**
 * @author
 *
 */
@RestController
@RequestMapping(IRestConstants.SEPARATOR + IRestConstants.API_BASE + IRestConstants.SEPARATOR
		+ IRestConstants.USER_ROLE)
public class UserRoleMappingController implements IBaseController<UserRoleMapping, Long>, IRestConstants {

	@Autowired
	UserRoleMappingService userRoleMappingService;

	@GetMapping()
	@Override
	public List<UserRoleMapping> findAll() {
		return userRoleMappingService.findAll();
	}

	@PutMapping()
	@Override
	public UserRoleMapping save(@RequestBody UserRoleMapping entity) {
		return userRoleMappingService.save(entity);
	}

	@PostMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public UserRoleMapping update(@PathVariable(ID) Long id, @RequestBody UserRoleMapping entity)
			 {
		return userRoleMappingService.update(id, entity);
	}

	@DeleteMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public void delete(@PathVariable(ID) Long id) {
		userRoleMappingService.delete(id);
	}

	@GetMapping(SEPARATOR + OPEN_BRACKET + ID + CLOSE_BRACKET)
	@Override
	public UserRoleMapping findOne(@PathVariable(ID) Long id) {
		return userRoleMappingService.findOne(id);
	}
}
