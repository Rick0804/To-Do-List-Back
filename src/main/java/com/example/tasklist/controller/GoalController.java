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

    @GetMapping
    private List<GoalModel> getAllGoal(){
        return goalService.getAllGoal();
    }

    @GetMapping("/{id}")
    private Optional<GoalModel> getGoal(@PathVariable long id){
        return goalService.getGoal(id);
    }

    @PostMapping
    public void addGoal(@RequestBody GoalModel goalModel){
        goalService.save(goalModel);
    }

    @PutMapping("/{id}")
    public void editGoal(@PathVariable long id, @RequestBody GoalModel goalModel){
        goalService.edit(id, goalModel);
    }

    public void deleteGoal(@PathVariable long id){
        goalService.delete(id);
    }

}
