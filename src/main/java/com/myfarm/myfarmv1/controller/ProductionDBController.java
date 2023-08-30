package com.myfarm.myfarmv1.controller;

import com.myfarm.myfarmv1.model.Production;
import com.myfarm.myfarmv1.repository.ProductionDBRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/production")
public class ProductionDBController {
    private final ProductionDBRepository productionDBRepository;
    private List<String> measurementUnitList;

    public ProductionDBController(ProductionDBRepository productionDBRepository, List<String> measurementUnitList) {
        this.productionDBRepository = productionDBRepository;
        this.measurementUnitList = measurementUnitList;
        this.addMeasurementUnitList();
    }
    private void addMeasurementUnitList() {
        this.measurementUnitList.add("kilograms");
        this.measurementUnitList.add("tons");
        this.measurementUnitList.add("liters");
    }
    @GetMapping("")
    public String getProductionPage(Model model) {
        model.addAttribute("measurementUnitList", this.measurementUnitList);
        if(this.productionDBRepository.count() != 0) {
            Iterable<Production> productions = this.productionDBRepository.findAll();
            model.addAttribute("productions", productions);
        }
        return "production";
    }
    @PostMapping("/add")
    public RedirectView addProduction(@ModelAttribute Production production) {
        if(production.getCrop() != null && production.getCrop() != "" && production.getQuantity() > 0 &&
                production.getDateCollected() != null && production.getDateCollected() != "" && production.getMeasurementUnit() != null)
            this.productionDBRepository.save(production);
        return new RedirectView("/production");
    }
    @PostMapping("/deletebyid")
    public RedirectView deleteProductionById(@RequestParam Long id) {
        this.productionDBRepository.deleteById(id);
        return new RedirectView("/production");
    }
}
