package com.skillshiring.demo.Repository;

import com.skillshiring.demo.models.LearningPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LearningPlanRepository extends JpaRepository<LearningPlan, Long> {
    List<LearningPlan> findByUserId(Long userId);
}
