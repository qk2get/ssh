package com.ssh.dao;

import com.ssh.vo.Mate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MateDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Mate> loadAll() {
        return sessionFactory.getCurrentSession().createCriteria(Mate.class).list();
    }

    public void save(Mate mate){
        sessionFactory.getCurrentSession().save(mate);
    }

    public Mate load(int id){
        return sessionFactory.getCurrentSession().get(Mate.class,id);
    }
}
