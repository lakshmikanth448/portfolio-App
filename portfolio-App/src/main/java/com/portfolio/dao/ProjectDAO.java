package com.portfolio.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.portfolio.model.Project;
import com.portfolio.util.HibernateUtil;

public class ProjectDAO {

    public void saveProject(Project p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public List<Project> getProjectsByUser(int userId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Query<Project> q = s.createQuery(
            "from Project where user.id=:uid", Project.class);
        q.setParameter("uid", userId);
        List<Project> list = q.list();
        s.close();
        return list;
    }
}

