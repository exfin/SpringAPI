package com.entrega1.entrega1.controllers;


import com.entrega1.entrega1.dto.ExecuteRevengeDTO;
import com.entrega1.entrega1.dto.RevengePlanDTO;
import com.entrega1.entrega1.models.SuccessLevel;
import com.entrega1.entrega1.services.IServiceRevengePlan;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revengeplans")
public class RevengePlanController {

    @Autowired
    private IServiceRevengePlan revengeService;

    @GetMapping("/")
    public List<RevengePlanDTO> getRevengePlans(){
        return revengeService.getRevengePlans();
    }

    @PostMapping("/")
    public ResponseEntity<?> addRevengePlan(@RequestBody RevengePlanDTO revengePlan){
        revengeService.addRevengePlan(revengePlan);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/execution")
    public ResponseEntity<?> executeRevengePlan(@RequestBody @Valid ExecuteRevengeDTO dto) {
        revengeService.executeRevengePlan(dto.id(), dto.successLevel());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bully/{id}")
    public ResponseEntity<List<RevengePlanDTO>> getPlansByBully(@PathVariable int id) {
        List<RevengePlanDTO> plans = revengeService.getRevengePlansByBullyId(id);
        return ResponseEntity.ok(plans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRevengePlan(@PathVariable int id){
        revengeService.deleteRevengePlan(id);
        return ResponseEntity.ok().build();
    }


}
