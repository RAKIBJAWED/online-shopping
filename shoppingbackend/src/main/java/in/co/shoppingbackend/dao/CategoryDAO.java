package in.co.shoppingbackend.dao;

import java.util.List;

import in.co.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> list();
	
	public Category get(int id);
}