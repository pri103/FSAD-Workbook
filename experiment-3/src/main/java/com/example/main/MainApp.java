package com.example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert products
        session.save(new Product("Laptop", "Electronics", 55000, 10));
        session.save(new Product("Mouse", "Electronics", 500, 25));
        session.save(new Product("Chair", "Furniture", 3000, 5));
        session.save(new Product("Table", "Furniture", 7000, 2));
        session.save(new Product("Notebook", "Stationery", 60, 100));
        session.save(new Product("Pen", "Stationery", 20, 200));

        tx.commit();

        // SORT BY PRICE ASC
        Query<Product> q1 = session.createQuery(
            "FROM Product p ORDER BY p.price ASC", Product.class);
        q1.list().forEach(p -> System.out.println(p.getName()));

        // PAGINATION
        Query<Product> q2 = session.createQuery("FROM Product", Product.class);
        q2.setFirstResult(0);
        q2.setMaxResults(3);
        q2.list().forEach(p -> System.out.println(p.getName()));

        // AGGREGATE
        Long count = session.createQuery(
            "SELECT COUNT(p) FROM Product p", Long.class).uniqueResult();
        System.out.println("Total Products: " + count);

        session.close();
    }
}
