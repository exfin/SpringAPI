package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dao.ICliqueDao;
import com.entrega1.entrega1.dto.BullyDTO;
import com.entrega1.entrega1.dto.CliqueDTO;
import com.entrega1.entrega1.models.Bully;
import com.entrega1.entrega1.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClique implements IServiceClique{

    @Autowired
    private ICliqueDao cliqueDao;

    @Override
    public List<CliqueDTO> getCliques() {
        return cliqueDao.findAll().stream().map(
                clique -> {
                    return new CliqueDTO(
                            clique.getId(),
                            clique.getName(),
                            clique.getDescription()

                    );
                }
        ).toList();
    }

    @Override
    public void addClique(CliqueDTO clique) {
        Clique clique1 = new Clique();
        clique1.setName(clique.name());
        clique1.setDescription(clique.description());
        cliqueDao.save(clique1);
    }

    @Override
    public void deleteClique(int id) {
        cliqueDao.deleteById(id);

    }
}
