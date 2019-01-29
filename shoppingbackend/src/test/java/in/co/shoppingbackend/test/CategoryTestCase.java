package in.co.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.co.shoppingbackend.dao.CategoryDAO;
import in.co.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("in.co.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
/*	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Radio");
		category.setDescription("This is the description of the Radio");
		category.setImageURL("CAT_012.png");
		assertEquals("Successfully added the category inside the table",true, categoryDAO.add(category));
	}
*/
	
/*	@Test
	public void testGetSingleCategory() {
		category=categoryDAO.get(3);
		assertEquals("Successfully fetched the single category from the table","Mobile", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated the category inside the table",true, categoryDAO.update(category));
	}*/
/*	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(2);		
		assertEquals("Successfully deleted the category inside the table",true, categoryDAO.delete(category));
	}
*/	
/*	@Test
	public void testFetchAllCategory() {
	
		assertEquals("Successfully deleted the category inside the table",3, categoryDAO.list().size());
	}*/
	
	
}
