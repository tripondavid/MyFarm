package com.myfarm.myfarmv1.controller;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.myfarm.myfarmv1.model.Activity;
import com.myfarm.myfarmv1.repository.ActivityDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
@RequestMapping("/activities")
public class ActivityDBController {
    private final ActivityDBRepository activityDBRepository;

    public ActivityDBController(ActivityDBRepository activityDBRepository) {
        this.activityDBRepository = activityDBRepository;
    }

    @GetMapping("")
    public String getActivityPage(Model model) {
        if(this.activityDBRepository.count() != 0) {
            Iterable<Activity> activities = this.activityDBRepository.findAll();
            model.addAttribute("activities", activities);
        }
        return "activities";
    }

    @PostMapping("/add")
    public RedirectView addActivity(@ModelAttribute Activity activity) {
        if(activity.getLocation() != null && activity.getDateCreated() != null && activity.getDescription() != null && !activity.getLocation().isEmpty()
                && !activity.getDescription().isEmpty() && !activity.getDateCreated().isEmpty()) {
            activity.setDateUpdated(LocalDate.now().toString());
            this.activityDBRepository.save(activity);
        }
        return new RedirectView("/activities");
    }

    //no delete method in HTML
    @PostMapping("/deletebyid")
    public RedirectView deleteActivityById(@RequestParam Long id) {
        this.activityDBRepository.deleteById(id);
        return new RedirectView("/activities");
    }
}
