package application.service;

public interface FarmWithProductionCycleService {

    void add(Integer farmId, Integer productionCycleId);

    void delete(Integer farmId, Integer productionCycleId);

}
