package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dto.BullyDTO;
import com.entrega1.entrega1.dto.CliqueDTO;
import com.entrega1.entrega1.models.Bully;

import java.util.List;

public interface IServiceClique {
    public List<CliqueDTO> getCliques();
    public void addClique(CliqueDTO clique);
    public void deleteClique(int id);
}
