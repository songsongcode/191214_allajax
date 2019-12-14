package com.dream.dto;

import java.util.List;

import com.dream.vo.User;

public class UsersDTO {
	private int allPage;
	private List<User> users;
	public UsersDTO() {
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public UsersDTO(int allPage, List<User> users) {
		this.allPage = allPage;
		this.users = users;
	}
	@Override
	public String toString() {
		return "UsersDTO [allPage=" + allPage + ", users=" + users + "]";
	}
	
}
