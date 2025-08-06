package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dao.IMediaDao;
import com.entrega1.entrega1.dao.IRevengePlanDao;
import com.entrega1.entrega1.dto.MediaDTO;
import com.entrega1.entrega1.models.Media;
import com.entrega1.entrega1.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMedia implements IServiceMedia{
    @Autowired
    private IMediaDao mediaDao;

    @Autowired
    private IRevengePlanDao revengePlanDao;

    @Override
    public List<MediaDTO> getMedia() {
        return mediaDao.findAll().stream().map(
                media -> {
                    return new MediaDTO(
                            media.getMediaType(),
                            media.getRevengePlan().getId()

                    );
                }
        ).toList();
    }

    @Override
    public void addMedia(MediaDTO media) {

        Media media1 = new Media();
        media1.setMediaType(media.mediaType());

        RevengePlan revengePlan1 = revengePlanDao.findById(media.revengePlanId())
                .orElseThrow(() -> new RuntimeException("No se encontró el plan de venganza"));
        revengePlan1.addMedia(media1);
        mediaDao.save(media1);

    }

    @Override
    public void deleteMedia(MediaDTO media) {

    }
}
