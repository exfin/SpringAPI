package com.entrega1.entrega1.controllers;


import com.entrega1.entrega1.dto.MediaDTO;
import com.entrega1.entrega1.dto.RevengePlanDTO;
import com.entrega1.entrega1.services.IServiceMedia;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private IServiceMedia mediaService;

    @GetMapping("/")
    public List<MediaDTO> getMedia(){
        return mediaService.getMedia();
    }

    @PostMapping("/")
    public ResponseEntity<?> addMedia(@Valid @RequestBody MediaDTO mediaDTO){
        mediaService.addMedia(mediaDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedia(@PathVariable String id){
        mediaService.deleteMedia(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/plan/{id}")
    public ResponseEntity<List<MediaDTO>> getMediaByRevengePlanId(@PathVariable int id){
        List<MediaDTO> media = mediaService.getMediaByRevengePlanId(id);
        return ResponseEntity.ok(media);

    }
}
