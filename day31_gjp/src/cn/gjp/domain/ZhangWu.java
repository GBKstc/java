package cn.gjp.domain;

public class ZhangWu {
	
	private int zwid;
	private String flname;
	private Double money;
	private String zhanghu;
	private String createtime;
	private String description;
	public ZhangWu(int zwid, String flname, Double money, String zhanghu, String createtime, String description) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.zhanghu = zhanghu;
		this.createtime = createtime;
		this.description = description;
	}
	public ZhangWu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return zwid+"\t\t"+flname+"\t\t"+zhanghu+"\t\t"+
			     money+"\t\t"+createtime+"\t"+description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((flname == null) ? 0 : flname.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
		result = prime * result + ((zhanghu == null) ? 0 : zhanghu.hashCode());
		result = prime * result + zwid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZhangWu other = (ZhangWu) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flname == null) {
			if (other.flname != null)
				return false;
		} else if (!flname.equals(other.flname))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (zhanghu == null) {
			if (other.zhanghu != null)
				return false;
		} else if (!zhanghu.equals(other.zhanghu))
			return false;
		if (zwid != other.zwid)
			return false;
		return true;
	}
	
	
	
}
