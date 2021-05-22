package application.controller;

import application.model.Farm;
import application.service.FarmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FarmController {

    private FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/farms")
    public void add(@RequestBody Farm farm) {
        farmService.add(farm);
    }

    @GetMapping("/farms/{id}")
    public Farm getFarmById(@PathVariable("id") Integer id) {
        return farmService.findById(id);
    }

    @GetMapping("/farms")
    public List<Farm> getFarms() {
        return farmService.findAll();
    }

    @PutMapping("/farms")
    public void update(@RequestBody Farm farm) {
        farmService.update(farm);
    }

    @DeleteMapping("/farms/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        farmService.deleteById(id);
    }
}
