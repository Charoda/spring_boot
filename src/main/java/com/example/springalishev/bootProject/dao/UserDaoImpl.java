package com.example.springalishev.bootProject.dao;


import com.example.springalishev.bootProject.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> index() {
        Query query = em.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User show(int id) {
        return em.find(User.class,id) ;
    }

    @Override
    public void save(User employee) {
        em.persist(employee);
    }

    @Override
    public void update(int id, User user) {
        User userforUpdate = em.find(User.class,id);
        userforUpdate.setName(user.getName());
        userforUpdate.setSurname(user.getSurname());
        userforUpdate.setAge(user.getAge());
        em.merge(userforUpdate);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(User.class,id));
    }
}
