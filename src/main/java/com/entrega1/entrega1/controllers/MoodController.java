package com.entrega1.entrega1.controllers;


import com.entrega1.entrega1.dto.MoodTrackerDTO;
import com.entrega1.entrega1.services.IServiceMoodTracker;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mood")
public class MoodController {

    @Autowired
    private IServiceMoodTracker moodService;

    @GetMapping("/")
    public List<MoodTrackerDTO> getMoods() {
        return moodService.getMoods();
    }

    @PostMapping("/")
    public ResponseEntity<?> addMood(@Valid @RequestBody MoodTrackerDTO moodTrackerDTO){
        moodService.addMood(moodTrackerDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMood(@PathVariable int id){
        moodService.deleteMood(id);
        return ResponseEntity.ok().build();
    }
}
