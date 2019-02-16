package in.co.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.co.shoppingbackend.dao.ProductDAO;
import in.co.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("in.co.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	
	
	@Test
	public void testAddProduct() {
		product=new Product();
		product.setCode("PRDABC123DEZX");
		product.setName("SkyBag Blue");
		product.setBrand("Skybag");
		product.setDescription("This is one of the best bag available in the market right now!");
		product.setPrice(1000f);
		product.setQuantity(53);
		product.setActive(true);
		product.setCategory_id(2);
		product.setSupplier_id(1);
		product.setPurchases(0);
		product.setViews(0);
		assertEquals("Successfully Adding the product inside the table",true, productDAO.add(product));
	}
	
	/*@Test
	public void testsingleProduct() {
		product=productDAO.get(3);
		assertEquals("Successfully fetched the product from the table","google", product.getBrand());
	}*/
	
	/*@Test
	public void testUpdateProduct() {
		product=productDAO.get(3);
		product.setBrand("Google Pixel A");
		assertEquals("Successfully updated the product in the table",true, productDAO.update(product));
	}*/
	
	/*@Test
	public void testDeleteProduct() {
		product=productDAO.get(3);
		assertEquals("Successfully updated the product in the table",true, productDAO.delete(product));
	}*/
	
	/*@Test
	public void testFetchALlProducts() {
		assertEquals("Successfully fetched all products from the table",5, productDAO.list().size());
	}*/
	
	
}
