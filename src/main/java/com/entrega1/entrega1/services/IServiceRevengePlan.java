package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dto.RevengePlanDTO;
import com.entrega1.entrega1.models.RevengePlan;
import com.entrega1.entrega1.models.SuccessLevel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IServiceRevengePlan {
    public List<RevengePlanDTO> getRevengePlans();
    public void addRevengePlan(RevengePlanDTO revengePlan);
    public void deleteRevengePlan(int id);
    public void executeRevengePlan(int id, SuccessLevel successLevel);
    public List<RevengePlanDTO> getRevengePlansByBullyId(int bullyId);


}
