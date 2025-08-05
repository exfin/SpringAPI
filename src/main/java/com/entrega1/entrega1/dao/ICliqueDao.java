package com.entrega1.entrega1.dao;

import com.entrega1.entrega1.models.Clique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliqueDao extends JpaRepository<Clique, Integer> {
}
