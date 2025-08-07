package com.entrega1.entrega1.controllers;


import com.entrega1.entrega1.dto.CliqueDTO;
import com.entrega1.entrega1.models.Clique;
import com.entrega1.entrega1.services.IServiceClique;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliques")
public class CliqueController {

    @Autowired
    private IServiceClique cliqueService;

    @GetMapping("/")
    public List<CliqueDTO> getCliques(){
        return cliqueService.getCliques();
    }
    @PostMapping("/")
    public ResponseEntity<?> addClique(@Valid @RequestBody CliqueDTO cliqueDTO){
        System.out.println("Clique: " + cliqueDTO.toString());
        cliqueService.addClique(cliqueDTO);
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBully(@PathVariable Integer id) {
        cliqueService.deleteClique(id);
        return ResponseEntity.ok().build();
    }
}
