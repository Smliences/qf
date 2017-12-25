package com.sml.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Author: sml
 * date: 2017��12��8��
 * time: ����4:14:05
**/

public class Test {
	public static void main(String[] args) {
		sql();
	}
	public static void sql() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		// session用于操作数据
		Session session = sessionFactory.openSession();
		System.out.println(session.get(User.class, 1));
	}
}
