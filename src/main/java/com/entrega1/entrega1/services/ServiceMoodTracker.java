package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dao.IMoodTrackerDao;
import com.entrega1.entrega1.dto.MoodTrackerDTO;
import com.entrega1.entrega1.models.MoodTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceMoodTracker implements IServiceMoodTracker {
    @Autowired
    private IMoodTrackerDao moodTrackerDao;

    @Override
    public List<MoodTrackerDTO> getMoods() {
        return moodTrackerDao.findAll().stream().map(
                moodTracker -> {
                    return new MoodTrackerDTO(
                            moodTracker.getNote(),
                            moodTracker.getMoodLevel(),
                            moodTracker.getCreated()
                    );
                }
        ).toList();
    }

    @Override
    public void addMood(MoodTrackerDTO mood) {
        MoodTracker moodTracker = new MoodTracker();
        moodTracker.setNote(mood.note());
        moodTracker.setMoodLevel(mood.moodLevel());
        moodTracker.setCreated(LocalDate.now());
        moodTrackerDao.save(moodTracker);

    }

    @Override
    public void deleteMood(MoodTrackerDTO mood) {

    }
}
