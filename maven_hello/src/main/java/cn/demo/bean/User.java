package cn.demo.bean;

public class User {
	
	private int id;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", code=" + code + ", password=" + password + "]";
	}
	private String name;
	private String code;
	private String password;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
