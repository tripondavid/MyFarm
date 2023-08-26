package com.myfarm.myfarmv1.controller;

import com.myfarm.myfarmv1.model.Equipment;
import com.myfarm.myfarmv1.repository.EquipmentDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/equipment")
public class EquipmentDBController {
    private final EquipmentDBRepository equipmentDBRepository;

    public EquipmentDBController(EquipmentDBRepository equipmentDBRepository) {
        this.equipmentDBRepository = equipmentDBRepository;
    }
    @GetMapping("")
    public String getEquipmentPage(Model model) {
        if(this.equipmentDBRepository.count() != 0) {
            Iterable<Equipment> equipments = this.equipmentDBRepository.findAll();
            model.addAttribute("equipments", equipments);
        }
        return "equipment";
    }

    @PostMapping("/add")
    public RedirectView addEquipment(@ModelAttribute Equipment equipment) {
        if(equipment.getName() != null && equipment.getName() != ""
                && equipment.getUtility() != null && equipment.getUtility() != "")
            this.equipmentDBRepository.save(equipment);
        return new RedirectView("/equipment");
    }
}
