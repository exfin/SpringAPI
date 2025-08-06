package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dao.IBullyDao;
import com.entrega1.entrega1.dao.ICliqueDao;
import com.entrega1.entrega1.dto.BullyDTO;
import com.entrega1.entrega1.models.Bully;
import com.entrega1.entrega1.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceBully implements IServiceBully{
    @Autowired
    private IBullyDao bullyDao;

    @Autowired
    private ICliqueDao cliqueDao;

    @Override
    public List<BullyDTO> getBullyList() {
        return bullyDao.findAll().stream().map(
                bully -> {
                    return new BullyDTO(
                            bully.getName(),
                            bully.getNickname(),
                            bully.getHighSchoolRole(),
                            bully.getBulliyngReason(),
                            bully.getLevelOfAnnoyance(),
                            bully.getClique().getId()
                    );
                }
        ).toList();
    }

    @Override
    public void addBully(BullyDTO bullyDto) {
        Bully bully = new Bully();
        bully.setName(bullyDto.name());
        bully.setNickname(bullyDto.nickname());
        bully.setHighSchoolRole(bullyDto.highSchoolRole());
        bully.setLevelOfAnnoyance(bullyDto.levelOfAnnoyance());

        Clique clique = cliqueDao.findById(bullyDto.cliqueId())
                .orElseThrow(() -> new RuntimeException("Clique not found"));

        clique.addBully(bully);

        bullyDao.save(bully);
    }

    @Override
    public Bully updateBully(BullyDTO bully) {
        return null;
    }

    @Override
    public void deleteBully(BullyDTO bully) {

    }
}
