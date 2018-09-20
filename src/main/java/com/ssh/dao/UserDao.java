package com.ssh.dao;

import com.ssh.vo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public User load(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> loadAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public void save(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.load(User.class,id));
    }
}
