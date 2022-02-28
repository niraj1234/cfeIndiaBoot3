package org.niraj.cfeIndiaBoot;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.niraj.dao.ProductDAO;
import org.niraj.entity.Product;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

	/**
	 * Not working.
	 * Will do some RnD to configure this in SpringBoot.
	 */
	
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.niraj");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}

	@Test
	public void test_productSize(){
			assertEquals("Something went wrong while getting Product Size!",
					3,productDAO.getProductsByRange(2, 3));				
	}
	
}
