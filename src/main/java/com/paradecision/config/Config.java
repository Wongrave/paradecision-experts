package com.paradecision.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

public class Config {

    @Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        return emf.unwrap(SessionFactory.class);
    }


}
