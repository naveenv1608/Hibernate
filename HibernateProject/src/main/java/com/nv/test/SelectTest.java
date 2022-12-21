package com.nv.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nv.entity.Product;

public class SelectTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/nv/config/hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session ses = factory.openSession();

		Transaction txn = null;

		try {
			txn = ses.beginTransaction();

			Product prod = new Product();
			prod.setPid(4);
			prod.setPname("Naveen");
			prod.setPrice(50f);
			prod.setQty(10f);

			Integer idVal=(Integer) ses.save(prod);
            System.out.println("ID value"+idVal);
			txn.commit();
			System.out.println("Record Inserted Successfully");

		} catch (HibernateException he) {
			he.printStackTrace();
		}
		ses.close();
		factory.close();
	}

}
