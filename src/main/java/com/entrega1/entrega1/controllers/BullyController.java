package com.entrega1.entrega1.controllers;


import com.entrega1.entrega1.dto.BullyDTO;
import com.entrega1.entrega1.dto.RevengePlanDTO;
import com.entrega1.entrega1.services.IServiceBully;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bullies")
public class BullyController {
    @Autowired
    private IServiceBully bullyService;

    @GetMapping("/")
    public List<BullyDTO> getBullies(){
        return bullyService.getBullyList();
    }

    @PostMapping("/")
    public ResponseEntity<?> addBully(@Valid @RequestBody BullyDTO bullyDTO){
        bullyService.addBully(bullyDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/clique/{id}")
    public ResponseEntity<List<BullyDTO>> getPlansByBully(@PathVariable int id) {
        List<BullyDTO> bullies = bullyService.getBullyListByCliqueId(id);
        return ResponseEntity.ok(bullies);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBully(@Valid @RequestBody BullyDTO bullyDTO) {
        bullyService.updateBully(bullyDTO);
        return ResponseEntity.ok("El bully ha sido actualizado correctamente");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBully(@PathVariable Integer id) {
        bullyService.deleteBully(id);
        return ResponseEntity.ok().build();
    }
}
