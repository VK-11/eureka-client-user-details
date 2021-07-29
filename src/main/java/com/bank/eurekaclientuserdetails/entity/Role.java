package com.bank.eurekaclientuserdetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bank.eurekaclientuserdetails.helper.constants.IRestConstants;

/**
 * @author
 *
 */
@Entity
@Table(name = IRestConstants.ROLE)
public class Role extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "role_value")
	private Integer roleValue;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleValue
	 */
	public Integer getRoleValue() {
		return roleValue;
	}

	/**
	 * @param roleValue the roleValue to set
	 */
	public void setRoleValue(Integer roleValue) {
		this.roleValue = roleValue;
	}

}
