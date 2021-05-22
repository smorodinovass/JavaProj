package application.impl;

import application.dao.FarmWithProductionCycleDAO;
import application.model.FarmWithProductionCycle;
import application.service.FarmWithProductionCycleService;
import org.springframework.stereotype.Service;

@Service
public class FarmWithProductionCycleServiceImpl implements FarmWithProductionCycleService {

    private FarmWithProductionCycleDAO farmWithProductionCycleDAO;

    public FarmWithProductionCycleServiceImpl(FarmWithProductionCycleDAO farmWithProductionCycleDAO) {
        this.farmWithProductionCycleDAO = farmWithProductionCycleDAO;
    }

    @Override
    public void add(Integer farmId, Integer productionCycleId) {
        FarmWithProductionCycle farmWithProductionCycle = new FarmWithProductionCycle();
        farmWithProductionCycle.setFarmId(farmId);
        farmWithProductionCycle.setProductionCycleId(productionCycleId);
        farmWithProductionCycleDAO.add(farmWithProductionCycle);
    }

    @Override
    public void delete(Integer farmId, Integer productionCycleId) {
        farmWithProductionCycleDAO.delete(farmId, productionCycleId);
    }
}
