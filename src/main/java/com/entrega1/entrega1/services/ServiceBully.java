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
                            bully.getId(),
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
        bully.setBulliyngReason(bullyDto.bulliyngReason());

        Clique clique = cliqueDao.findById(bullyDto.cliqueId())
                .orElseThrow(() -> new RuntimeException("No se encontró el clique"));

        clique.addBully(bully);

        bullyDao.save(bully);
    }

    @Override
    public Bully updateBully(BullyDTO bullyDTO) {
        Bully bully = bullyDao.findById(bullyDTO.id())
                .orElseThrow(() -> new RuntimeException("No se encontró el  Bully con id: " + bullyDTO.id()));

        if (bullyDTO.name() != null) bully.setName(bullyDTO.name());
        if (bullyDTO.nickname() != null) bully.setNickname(bullyDTO.nickname());
        if (bullyDTO.highSchoolRole() != null) bully.setHighSchoolRole(bullyDTO.highSchoolRole());
        if (bullyDTO.bulliyngReason() != null) bully.setBulliyngReason(bullyDTO.bulliyngReason());
        if (bullyDTO.levelOfAnnoyance() != null) bully.setLevelOfAnnoyance(bullyDTO.levelOfAnnoyance());

        if (bullyDTO.cliqueId() != null && bully.getClique().getId() != bullyDTO.cliqueId()) {
            Clique newClique = cliqueDao.findById(bullyDTO.cliqueId())
                    .orElseThrow(() -> new RuntimeException("No se encontró el clique con id: " + bullyDTO.cliqueId()));

            newClique.addBully(bully);
        }

        // Save updated bully
        bullyDao.save(bully);
        return bully;
    }



    @Override
    public void deleteBully(int id) {
        bullyDao.deleteById(id);

    }

    @Override
    public List<BullyDTO> getBullyListByCliqueId(int id) {
        Clique clique = cliqueDao.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el clique"));
        return clique.getBullies().stream().map(
                bully -> {
                    return new BullyDTO(
                            bully.getId(),
                            bully.getName(),
                            bully.getNickname(),
                            bully.getHighSchoolRole(),
                            bully.getBulliyngReason(),
                            bully.getLevelOfAnnoyance(),
                            clique.getId()
                    );
                }
        ).toList();
    }
}
