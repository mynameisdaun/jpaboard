package com.example.jpaboard.domain.repository;

import com.example.jpaboard.domain.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public Long save (Users user) {
        em.persist(user);
        return user.getId();
    }

    public Users find (Long id) {
        return em.find(Users.class,id);
    }
}
