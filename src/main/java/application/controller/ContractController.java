package application.controller;

import application.model.Contract;
import application.service.ContractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {

    private ContractService contractService;

    public ContractController(@Qualifier("contractServiceImpl") ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping("/contracts")
    public void add(@RequestBody Contract contract) {
        contractService.add(contract);
    }

    @GetMapping("/contracts/{id}")
    public Contract getContractById(@PathVariable("id") Integer id) {
        return contractService.findById(id);
    }

    @GetMapping("/contracts")
    public List<Contract> getContracts() {
        return contractService.findAll();
    }

    @PutMapping("/contracts")
    public void update(@RequestBody Contract contract) {
        contractService.update(contract);
    }

    @DeleteMapping("/contracts/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        contractService.deleteById(id);
    }
}
