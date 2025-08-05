package com.entrega1.entrega1.dao;

import com.entrega1.entrega1.models.Bully;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBullyDao extends JpaRepository<Bully, Integer> {
}
