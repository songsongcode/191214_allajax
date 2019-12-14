package com.dream.vo;

public class User {
	private int uid;
	private String uname;
	private char usex;
	private int uage;
	private String uphone;
	public User() {
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public char getUsex() {
		return usex;
	}
	public void setUsex(char usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public User(String uname, char usex, int uage, String uphone) {
		this.uname = uname;
		this.usex = usex;
		this.uage = uage;
		this.uphone = uphone;
	}
	public User(int uid, String uname, char usex, int uage, String uphone) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.usex = usex;
		this.uage = uage;
		this.uphone = uphone;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", uage=" + uage + ", uphone=" + uphone
				+ "]";
	}
	
}
