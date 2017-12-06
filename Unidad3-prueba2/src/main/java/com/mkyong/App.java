package com.mkyong;

import java.util.Date;

import com.mkyong.stock.Category;
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDetail;
import org.hibernate.Session;
import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;
import java.util.HashSet;
import java.util.Set;

public class App {
	public static void main(String[] args) {
	/*	System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		DBUser user = new DBUser();

		user.setUserId(103);
		user.setUsername("supermana2");
		user.setCreatedBy("systemaº");
		user.setCreatedDate(new Date());
		session.saveOrUpdate(user);
		
		
		//session.saveOrUpdate(user);
		
		session.getTransaction().commit();*/
		
		/* otro
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("7052");
		stock.setStockName("PADINI");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		session.saveOrUpdate(stock);
		session.getTransaction().commit();

		System.out.println("Done");	*/
		
		System.out.println("Hibernate many to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
	        stock.setStockCode("7052");
	        stock.setStockName("PADINI");

	        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
	        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");

	        Set<Category> categories = new HashSet<Category>();
	        categories.add(category1);
	        categories.add(category2);

	        stock.setCategories(categories);

	        session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
		
		
	}
}