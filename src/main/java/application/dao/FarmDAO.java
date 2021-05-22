package application.dao;


import application.model.*;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FarmDAO extends DAO<Farm> {

    private ContractDAO contractDAO;
    private FarmWithProductionCycleDAO farmWithProductionCycleDAO;
    private ProductionCycleDAO productionCycleDAO;

    public FarmDAO(ContractDAO contractDAO, FarmWithProductionCycleDAO farmWithProductionCycleDAO, ProductionCycleDAO productionCycleDAO) {
        this.contractDAO = contractDAO;
        this.farmWithProductionCycleDAO = farmWithProductionCycleDAO;
        this.productionCycleDAO = productionCycleDAO;
        tableName = "farms";
        columns = new String[]{
                "animal_type",
                "farm_owner",
                "capital",
                "is_bankrupt",
                "number_of_young_animals",
                "number_of_adult_animals",
                "number_of_old_animals",
                "contract_id"
        };
    }

    @Override
    protected List<Farm> convertFrom(ResultSet resultSet) throws SQLException {
        List<Farm> farms = new ArrayList<>();
        while (resultSet.next()) {
            Farm farm = new Farm();

            farm.setId(resultSet.getInt("id"));

            String animalTypeRow = resultSet.getString("animal_type");
            AnimalType animalType = AnimalType.valueOf(animalTypeRow);
            farm.setAnimalType(animalType);

            farm.setFarmOwner(resultSet.getString("farm_owner"));
            farm.setCapital(resultSet.getInt("capital"));
            farm.setBankrupt(resultSet.getBoolean("is_bankrupt"));
            farm.setNumberOfYoungAnimals(resultSet.getInt("number_of_young_animals"));
            farm.setNumberOfAdultAnimals(resultSet.getInt("number_of_adult_animals"));
            farm.setNumberOfOldAnimals(resultSet.getInt("number_of_old_animals"));

            int id = resultSet.getInt("contract_id");
            Contract contract = contractDAO.findById(id);
            farm.setContract(contract);


            List<FarmWithProductionCycle> pairs = farmWithProductionCycleDAO.findAll();
            List<Integer> productionCyclesId = new ArrayList<>();

            for (FarmWithProductionCycle pair:
                 pairs) {
                if (pair.getFarmId() == id) {
                    productionCyclesId.add(pair.getProductionCycleId());
                }
            }

            List<ProductionCycle> productionCycles = new ArrayList<>();
            for (ProductionCycle productionCycle:
                 productionCycleDAO.findAll()) {
                if (productionCyclesId.contains(productionCycle.getId())) {
                    productionCycles.add(productionCycle);
                }
            }

            farm.setProductionCycleList(productionCycles);

            farms.add(farm);
        }
        return farms;
    }

    @Override
    protected String createInsertQuery(Farm farm) {
        String fields = String.join(", ", columns);

        String values = "'" + farm.getAnimalType() + "', '"
                + farm.getFarmOwner() + "', "
                + farm.getCapital() + ", "
                + farm.isBankrupt() + ", "
                + farm.getNumberOfYoungAnimals() + ", "
                + farm.getNumberOfAdultAnimals() + ", "
                + farm.getNumberOfOldAnimals() + ", "
                + farm.getContract().getId();

        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(Farm farm) {
        throw new UnsupportedOperationException();
    }
}
