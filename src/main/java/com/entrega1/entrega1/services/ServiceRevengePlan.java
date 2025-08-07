package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dao.IBullyDao;
import com.entrega1.entrega1.dao.IRevengePlanDao;
import com.entrega1.entrega1.dto.RevengePlanDTO;
import com.entrega1.entrega1.models.Bully;
import com.entrega1.entrega1.models.RevengePlan;
import com.entrega1.entrega1.models.SuccessLevel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRevengePlan implements IServiceRevengePlan{

    @Autowired
    private IRevengePlanDao revengePlanDao;
    @Autowired
    private IBullyDao bullyDao;
    @Override
    public List<RevengePlanDTO> getRevengePlans() {
        return revengePlanDao.findAll().stream().map(
                revengePlan -> {
                    return new RevengePlanDTO(
                            revengePlan.getId(),
                            revengePlan.getName(),
                            revengePlan.getDescription(),
                            revengePlan.getIsExecuted(),
                            revengePlan.getDatePlanned(),
                            revengePlan.getSuccessLevel(),
                            revengePlan.getBully().getId()
                    );

                }
        ).toList();
    }

    @Override
    public void addRevengePlan(RevengePlanDTO revengePlan) {
        RevengePlan revengePlan1 = new RevengePlan();
        revengePlan1.setName(revengePlan.name());
        revengePlan1.setDescription(revengePlan.description());
        revengePlan1.setIsExecuted(false);
        revengePlan1.setDatePlanned(revengePlan.datePlanned());
        revengePlan1.setSuccessLevel(null);

        Bully bully = bullyDao.findById(revengePlan.bullyId())
                .orElseThrow(() -> new RuntimeException("No se encontró el bully"));
        bully.addRevengePlan(revengePlan1);
        revengePlanDao.save(revengePlan1);


    }

    @Override
    public void deleteRevengePlan(int id) {
        revengePlanDao.deleteById(id);


    }

    @Transactional
    public void executeRevengePlan(int id, SuccessLevel successLevel) {
        RevengePlan revengePlan = revengePlanDao.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el plan"));
        revengePlan.setIsExecuted(true);
        revengePlan.setSuccessLevel(successLevel);

    }

    @Override
    public List<RevengePlanDTO> getRevengePlansByBullyId(int bullyId) {
        Bully bully = bullyDao.findById(bullyId)
                .orElseThrow(() -> new RuntimeException("No se encontró el bully con id " + bullyId));

        return bully.getRevengePlans()
                .stream()
                .map(revengePlan -> new RevengePlanDTO(
                        revengePlan.getId(),
                        revengePlan.getName(),
                        revengePlan.getDescription(),
                        revengePlan.getIsExecuted(),
                        revengePlan.getDatePlanned(),
                        revengePlan.getSuccessLevel(),
                        bully.getId()
                ))
                .toList();
    }

}
