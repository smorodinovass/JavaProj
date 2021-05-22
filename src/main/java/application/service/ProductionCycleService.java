package application.service;

import application.model.ProductionCycle;

import java.util.List;

public interface ProductionCycleService {

    void add(ProductionCycle productionCycle);

    ProductionCycle findById(Integer id);

    List<ProductionCycle> findAll();

    void update(ProductionCycle productionCycle);

    void deleteById(Integer id);
}
