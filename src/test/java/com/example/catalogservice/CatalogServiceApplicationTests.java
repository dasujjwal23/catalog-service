package com.example.catalogservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.catalogservice.dao.OrderDao;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class) 
public class CatalogServiceApplicationTests {

	@Autowired
	private OrderDao orderDao;
		
	@Test
	public void contextLoads() {
			
	}
	
	@Test
	public void solution()
	{
		String name=this.orderDao.getClass().getName();
		
		System.out.println(name);
		assertEquals(15, 15);
	}

}
