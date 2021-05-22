package application.controller;

import application.model.ProductionCycle;
import application.service.ProductionCycleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductionCycleController {

    private ProductionCycleService productionCycleService;

    public ProductionCycleController(ProductionCycleService productionCycleService) {
        this.productionCycleService = productionCycleService;
    }

    @PostMapping("/production")
    public void add(@RequestBody ProductionCycle productionCycle) {
        productionCycleService.add(productionCycle);
    }

    @GetMapping("/production/{id}")
    public ProductionCycle getProductionCycleById(@PathVariable("id") Integer id) {
        return productionCycleService.findById(id);
    }

    @GetMapping("/production")
    public List<ProductionCycle> getProductionCycles() {
        return productionCycleService.findAll();
    }

    @PutMapping("/production")
    public void update(@RequestBody ProductionCycle productionCycle) {
        productionCycleService.update(productionCycle);
    }

    @DeleteMapping("/production/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        productionCycleService.deleteById(id);
    }
}
