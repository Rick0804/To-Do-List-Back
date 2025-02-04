package com.example.tasklist.controller;

import com.example.tasklist.model.GoalModel;
import com.example.tasklist.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping
    public void addGoal(@RequestBody GoalModel goalModel){
        goalService.createGoal(goalModel);
    }

    @GetMapping
    public List<GoalModel> getAllGoal(){
        return goalService.getGoalList();
    }

    @GetMapping("/{id}")
    public Optional<GoalModel> getGoal(@PathVariable long id){
        return goalService.getGoal(id);
    }

    @PutMapping("/{id}")
    public void editGoal(@PathVariable long id, @RequestBody GoalModel goalModel){
        goalService.editGoal(id, goalModel);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable long id){
        goalService.deleteGoal(id);
    }

}
