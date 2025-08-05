package com.entrega1.entrega1.dao;

import com.entrega1.entrega1.models.RevengePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRevengePlanDao extends JpaRepository<RevengePlan, Integer> {
}
