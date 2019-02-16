package in.co.shoppingbackend.dao;

import java.util.List;

import in.co.shoppingbackend.dto.Product;


public interface ProductDAO {

	public List<Product> list();
	
	public Product get(int id);
	
	public boolean add(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
	
	//Bussiness method
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
