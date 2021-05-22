package application.controller;

import application.service.FarmWithProductionCycleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmWithProductionCycleController {

    private FarmWithProductionCycleService farmWithProductionCycle;

    public FarmWithProductionCycleController(FarmWithProductionCycleService farmWithProductionCycle) {
        this.farmWithProductionCycle = farmWithProductionCycle;
    }

    @PostMapping("/add/{farm_id}/{production_cycle_id}")
    public void add(@PathVariable("farm_id") Integer farmId, @PathVariable("production_cycle_id") Integer productionCycleId) {
        farmWithProductionCycle.add(farmId, productionCycleId);
    }

    @DeleteMapping("/delete/{farm_id}/{production_cycle_id}")
    public void delete(@PathVariable("farm_id") Integer farmId, @PathVariable("production_cycle_id") Integer productionCycleId) {
        farmWithProductionCycle.delete(farmId, productionCycleId);
    }
}
