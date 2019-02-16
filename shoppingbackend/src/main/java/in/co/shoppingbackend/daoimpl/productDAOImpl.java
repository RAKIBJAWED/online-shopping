package in.co.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.co.shoppingbackend.dao.ProductDAO;
import in.co.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class productDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> list() {
		String queryActiveProducts="FROM Product WHERE active=:active";
		@SuppressWarnings("unchecked")
		Query<Product> query=sessionFactory.getCurrentSession().createQuery(queryActiveProducts);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="FROM Product WHERE active=:active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts)
						.setParameter("active", true)
							.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM Product WHERE active=:active AND category_id=:category_id";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory)
						.setParameter("active", true)
						.setParameter("category_id", categoryId)
							.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active=:active ORDER BY id")
						.setParameter("active", true)
						.setFirstResult(0)
						.setMaxResults(count)
							.getResultList();
	}

}
