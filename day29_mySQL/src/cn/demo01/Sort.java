package cn.demo01;

public class Sort {
	private String score;
	private double sex;
	private String name;
	private int id;
	public Sort(int id, String name, double sex, String score) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
	public Sort(){}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public double getSex() {
		return sex;
	}
	public void setSex(double sex) {
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
