package com.example.tasklist.service;

import com.example.tasklist.model.GoalModel;
import com.example.tasklist.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }

    public List<GoalModel> getGoalList(){
        return goalRepository.findAll();
    }

    public Optional<GoalModel> getGoal(long id){
        Optional<GoalModel> goal = goalRepository.findById(id);
        if(!goal.isPresent()){
            throw new RuntimeException("Meta não encontradas");
        }
        return goalRepository.findById(id);
    }

    public void createGoal(GoalModel goalModel){
        goalRepository.save(goalModel);
    }

    public void editGoal(long id , GoalModel goalModel){
        Optional<GoalModel> goalOp = goalRepository.findById(id);
        GoalModel goal = goalOp.get();
        goal.setGoalTitle(goalModel.getGoalTitle());
        goal.setGoalDescription(goalModel.getGoalDescription());
        goal.setGoalEnum(goalModel.getGoalEnum());
        goalRepository.save(goal);
    }

    public void deleteGoal(long id){
        goalRepository.deleteById(id);
    }
}
