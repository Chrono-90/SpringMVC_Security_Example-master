package jm.security.example.dao;

import jm.security.example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String name) {

        return entityManager.createQuery("from User user where user.name =:nameUser", User.class).setParameter("nameUser", name).getSingleResult();

    }

    @Override
    public void createOrUpdateUser(User user) {

        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.remove(findUserById(id));
    }

    @Override
    public User findUserById(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}

