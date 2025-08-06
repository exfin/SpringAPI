package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dto.CliqueDTO;
import com.entrega1.entrega1.dto.MediaDTO;

import java.util.List;

public interface IServiceMedia {
   public List<MediaDTO> getMedia();
   public void addMedia(MediaDTO media);
   public void deleteMedia(MediaDTO media);
}
