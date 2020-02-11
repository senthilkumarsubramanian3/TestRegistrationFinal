package com.cts.vo;

/**
 * @author 765584 getters and setters for login page
 */
public class LoginVO {
	private static String name;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		LoginVO.name = name;
	}

}
