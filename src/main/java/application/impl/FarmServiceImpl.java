package application.impl;

import application.dao.FarmDAO;
import application.model.Farm;
import application.service.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private FarmDAO farmDAO;

    public FarmServiceImpl(FarmDAO farmDAO) {
        this.farmDAO = farmDAO;
    }

    public void add(Farm farm) {
        farmDAO.add(farm);
    }

    public Farm findById(Integer id) {
        return farmDAO.findById(id);
    }

    public List<Farm> findAll() {
        return farmDAO.findAll();
    }

    public void update(Farm farm) {
        farmDAO.update(farm);
    }

    public void deleteById(Integer id) {
        farmDAO.deleteById(id);
    }
}
