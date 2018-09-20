package com.ssh.dao;

import com.ssh.vo.Soulmate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SoulmateDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Soulmate load(int id) {
        return sessionFactory.getCurrentSession().get(Soulmate.class, id);
    }

    public List<Soulmate> loadAll() {
        return sessionFactory.getCurrentSession().createCriteria(Soulmate.class).list();
    }

    public void save(Soulmate soulmate){
        sessionFactory.getCurrentSession().save(soulmate);
    }

    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(Soulmate.class,id));
    }
}
