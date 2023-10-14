package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter @RequiredArgsConstructor
public class Users {

	public Users(String username, String password, Set<Roles> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "users_id")
	private Integer userId;
	
	@Column(name = "usersname")
	private String username;
	
	@Column(name = "pass_word")
	private String password;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
			joinColumns =  {@JoinColumn(name = "users_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Roles> roles;
	

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", cart=" + cart
				+ ", roles=" + roles + "]";
	}

	
	
}
