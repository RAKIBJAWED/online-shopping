package in.co.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.co.shoppingbackend.dao.CategoryDAO;
import in.co.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is the description of the Television");
		category.setImageURL("CAT_01.png");
		categories.add(category);
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is the description of the Mobile");
		category.setImageURL("CAT_02.png");
		categories.add(category);
		category = new Category();
		category.setId(3);
		category.setName("Radio");
		category.setDescription("This is the description of the Radio");
		category.setImageURL("CAT_03.png");
		categories.add(category);

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category:categories) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
	}

}
