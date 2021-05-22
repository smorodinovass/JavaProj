package application.impl;

import application.dao.ContractDAO;
import application.model.Contract;
import application.service.ContractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO;

    public ContractServiceImpl(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    public void add(Contract contract) {
        contractDAO.add(contract);
    }

    public Contract findById(Integer id) {
        return contractDAO.findById(id);
    }

    public List<Contract> findAll() {
        return contractDAO.findAll();
    }

    public void update(Contract contract) {
        contractDAO.update(contract);
    }

    public void deleteById(Integer id) {
        contractDAO.deleteById(id);
    }
}
