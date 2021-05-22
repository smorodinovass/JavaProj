package application.dao;


import application.model.Contract;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractDAO extends DAO<Contract> {

    public ContractDAO() {
        tableName = "contracts";
        columns = new String[]{
                "contract_duration_in_years",
                "number_of_young_animals_sold",
                "number_of_adult_animals_sold",
                "number_of_old_animals_sold",
                "young_animal_selling_cost",
                "adult_animal_selling_cost",
                "old_animal_selling_cost",
                "cost_of_feed_needs_to_purchased",
                "unsold_animal_forfeit",
        };
    }

    @Override
    protected List<Contract> convertFrom(ResultSet resultSet) throws SQLException {
        List<Contract> contracts = new ArrayList<>();
        while (resultSet.next()) {
            Contract contract = new Contract();

            contract.setId(resultSet.getInt("id"));
            contract.setContractDurationInYears(resultSet.getInt("contract_duration_in_years"));
            contract.setNumberOfYoungAnimalsSold(resultSet.getInt("number_of_young_animals_sold"));
            contract.setNumberOfAdultAnimalsSold(resultSet.getInt("number_of_adult_animals_sold"));
            contract.setNumberOfOldAnimalsSold(resultSet.getInt("number_of_old_animals_sold"));
            contract.setYoungAnimalSellingCost(resultSet.getInt("young_animal_selling_cost"));
            contract.setAdultAnimalSellingCost(resultSet.getInt("adult_animal_selling_cost"));
            contract.setOldAnimalSellingCost(resultSet.getInt("old_animal_selling_cost"));
            contract.setCostOfFeedNeedsToPurchased(resultSet.getInt("cost_of_feed_needs_to_purchased"));
            contract.setUnsoldAnimalForfeit(resultSet.getInt("unsold_animal_forfeit"));

            contracts.add(contract);
        }
        return contracts;
    }

    @Override
    protected String createInsertQuery(Contract contract) {
        String fields = String.join(", ", columns);

        String values = contract.getContractDurationInYears() + ", "
                + contract.getNumberOfYoungAnimalsSold() + ", "
                + contract.getNumberOfAdultAnimalsSold() + ", "
                + contract.getNumberOfOldAnimalsSold() + ", "
                + contract.getYoungAnimalSellingCost() + ", "
                + contract.getAdultAnimalSellingCost() + ", "
                + contract.getOldAnimalSellingCost() + ", "
                + contract.getCostOfFeedNeedsToPurchased() + ", "
                + contract.getUnsoldAnimalForfeit();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(Contract contract) {
        throw new UnsupportedOperationException();
    }
}
