package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dto.CliqueDTO;
import com.entrega1.entrega1.dto.MoodTrackerDTO;

import java.util.List;

public interface IServiceMoodTracker {
    public List<MoodTrackerDTO> getMoods();
    public void addMood(MoodTrackerDTO mood);
    public void deleteMood(MoodTrackerDTO mood);
}
