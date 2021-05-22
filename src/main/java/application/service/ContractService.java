package application.service;

import application.model.Contract;

import java.util.List;

public interface ContractService {

    void add(Contract contract);

    Contract findById(Integer id);

    List<Contract> findAll();

    void update(Contract contract);

    void deleteById(Integer id);
}
