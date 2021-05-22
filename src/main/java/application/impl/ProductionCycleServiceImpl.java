package application.impl;

import application.dao.ProductionCycleDAO;
import application.model.ProductionCycle;
import application.service.ProductionCycleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCycleServiceImpl implements ProductionCycleService {

    private ProductionCycleDAO productionCycleDAO;

    public ProductionCycleServiceImpl(ProductionCycleDAO productionCycleDAO) {
        this.productionCycleDAO = productionCycleDAO;
    }

    public void add(ProductionCycle productionCycle) {
        productionCycleDAO.add(productionCycle);
    }

    public ProductionCycle findById(Integer id) {
        return productionCycleDAO.findById(id);
    }

    public List<ProductionCycle> findAll() {
        return productionCycleDAO.findAll();
    }

    public void update(ProductionCycle productionCycle) {
        productionCycleDAO.update(productionCycle);
    }

    public void deleteById(Integer id) {
        productionCycleDAO.deleteById(id);
    }
}
