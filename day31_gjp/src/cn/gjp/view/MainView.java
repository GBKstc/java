package cn.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.gjp.controller.ZhangWuController;
import cn.gjp.domain.ZhangWu;

/**
 * 操作界面
 * @author Administrator
 *
 */
public class MainView {
	private ZhangWuController zwCon = new ZhangWuController();
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			switch (sc.nextInt()) {
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();			
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("请输入正确的命令");
				System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
				System.out.println("请输入要操作的功能序号[1-5]:");
				break;
			}
		}
		
	}

	private void deleteZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		System.out.println("选择的是删除功能，请输入要删除的ID");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入ID");
		int zwid = sc.nextInt();
		int i = zwCon.deleteZhangWu(zwid);
		if(i!=0) {
			System.out.println("删除成功");
			selectAll();
		}
	}

	private void editZhangWu() {
		// TODO Auto-generated method stub
		selectAll();
		System.out.println("选择的是编辑功能，请输入数据");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入ID");
		int zwid = sc.nextInt();
		System.out.print("输入分类名称");
		String flname = sc.next();
		System.out.print("输入金额");
		double money = sc.nextDouble();
		System.out.print("输入账户");
		String zhanghu = sc.next();
		System.out.print("输入日期：格式XXXX-XX-xx");
		String createtime = sc.next();
		System.out.print("输入具体描述");
		String description = sc.next();
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		int i = zwCon.editZhangWu(zw);
		if(i!=0) {
			System.out.println("修改成功");
			selectAll();
		}
	}

	private void addZhangWu() {
		// TODO Auto-generated method stub
		System.out.println("选择的添加账务功能，请输入以下内容");
		Scanner sc = new Scanner(System.in);
		System.out.print("输入分类名称");
		String flname = sc.next();
		System.out.print("输入金额");
		double money = sc.nextDouble();
		System.out.print("输入账户");
		String zhanghu = sc.next();
		System.out.print("输入日期：格式XXXX-XX-xx");
		String createtime = sc.next();
		System.out.print("输入具体描述");
		String description = sc.next();
		ZhangWu zw = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		int i = zwCon.addZhangWu(zw);
		if(i!=0) {
			System.out.println("添加成功");
			selectAll();
		}
		
	}

	private void selectZhangWu() {
		// TODO Auto-generated method stub
		System.out.println("1.查询所有　2.按条件查询");
		Scanner in = new Scanner(System.in);
		int op = in.nextInt();
		switch (op) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			break;
		}
	}

	private void select() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("选择条件查询,输入日期格式XXXX-XX-XX。输入0返回目录");
			System.out.print("请输入开始日期:");
			String dataStart = sc.nextLine();
			if(dataStart.length()==1) {
				break;
			}
			System.out.print("请输入结果日期:");
			String dataEnd = sc.nextLine();
			if(dataStart.length()==1) {
				break;
			}
			List<ZhangWu> list = zwCon.select(dataStart,dataEnd);
			if(list.size()!=0) {
				System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
				for(ZhangWu zw:list) {
					System.out.println(zw);
				}
				break ;
			}else {
				System.out.println("没有查询结果");
			}
		}
	}

	private void selectAll() {
		// TODO Auto-generated method stub
		
		List<ZhangWu> list = zwCon.selectAll();
		if(list.size()!=0) {
			System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
			for(ZhangWu zw:list) {
				System.out.println(zw);
			}
		}else {
			System.out.println("没有查询结果");
		}
		
	}

}
