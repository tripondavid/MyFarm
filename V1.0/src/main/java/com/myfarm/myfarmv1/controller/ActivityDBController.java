package com.myfarm.myfarmv1.controller;

import com.myfarm.myfarmv1.model.Activity;
import com.myfarm.myfarmv1.repository.ActivityDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        if(this.activityDBRepository.count() != 0)
            model.addAttribute("activitylist", this.activityDBRepository.findAll());
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
}
