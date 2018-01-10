package cn.demo.gbk;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.demo.gbk.service.CustomerService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HelloService implements HellowService {
	@Resource(name="customerAction")
	private CustomerService ss;
	
	@Override
	public String sayHello(String name) {
		System.out.println("sayHello");
		return "hello "+name;
	}
	@Test
	public void function() {
		System.out.println("aa");
//		List<Customer> list = ss.findAll();
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
		
			
	}

}
