package com.example.codeexample.repository;

import com.example.codeexample.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
