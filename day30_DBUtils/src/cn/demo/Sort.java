package cn.demo;

public class Sort {
	private int score;
	private String sex;
	private String name;
	private int id;
	public Sort(int id, String name, String sex, int score) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
	public Sort(){}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sort [score=" + score + ", sex=" + sex + ", name=" + name + ", id=" + id + "]";
	}
	
	
	
	
}
