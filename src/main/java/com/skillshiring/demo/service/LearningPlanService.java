
package com.skillshiring.demo.service;

import com.skillshiring.demo.models.LearningPlan;
import com.skillshiring.demo.Repository.LearningPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningPlanService {

    @Autowired
    private LearningPlanRepository repo;

    public LearningPlan create(LearningPlan plan) {
        return repo.save(plan);
    }

    public List<LearningPlan> getAllByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public LearningPlan update(Long id, LearningPlan updatedPlan) {
        LearningPlan existing = repo.findById(id).orElseThrow();

        existing.setTitle(updatedPlan.getTitle());
        existing.setDescription(updatedPlan.getDescription());
        existing.setResourceLink(updatedPlan.getResourceLink());
        existing.setTimeline(updatedPlan.getTimeline());

        existing.setTopicsJson(updatedPlan.getTopicsJson());

        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
