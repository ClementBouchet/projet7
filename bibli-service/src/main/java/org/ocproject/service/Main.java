package org.ocproject.service;


import org.ocproject.dao.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext vApplicationContext
        = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		DaoFactory daoFactory = vApplicationContext.getBean("daoFactory", DaoFactory.class);
		daoFactory.getDriver();
	}

}
