package in.co.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"in.co.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private static final String DATABASE_DRIVER="org.h2.Driver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME="sa";
	private static final String DATABASE_PASSWORD="";
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);		
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("in.co.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", DATABASE_DIALECT);
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManger=new HibernateTransactionManager(sessionFactory);
		return transactionManger;
	}
	
}
