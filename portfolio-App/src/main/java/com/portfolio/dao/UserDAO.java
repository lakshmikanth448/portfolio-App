package com.portfolio.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.portfolio.model.User;
import com.portfolio.util.HibernateUtil;

public class UserDAO {

    public void saveUser(User user) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(user);
        tx.commit();
        s.close();
    }

    public User login(String email, String password) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query<User> q = s.createQuery(
            "from User where email=:e and password=:p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        User user = q.uniqueResult();
        s.close();
        return user;
    }
}

