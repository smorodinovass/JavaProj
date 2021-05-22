package application.dao;


import application.model.ProductionCycle;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductionCycleDAO extends DAO<ProductionCycle> {

    public ProductionCycleDAO() {
        tableName = "production_cycles";
        columns = new String[]{
                "year_number",
                "adult_animal_fertility_rate",
                "old_animal_fertility_rate",
                "young_animal_survival_rate",
                "old_animal_mortality_rate",
                "number_of_young_animals_at_the_start_of_year",
                "number_of_adult_animals_at_the_start_of_year",
                "number_of_old_animals_at_the_start_of_year",
                "number_of_young_animals_at_the_end_of_year",
                "number_of_adult_animals_at_the_end_of_year",
                "number_of_old_animals_at_the_end_of_year",
                "feed_cost_for_one_animal",
                "total_feed_cost",
                "number_of_born_animals",
                "number_of_sold_animals",
                "total_year_income",
                "total_year_expenses",
                "farm_capital"
        };
    }

    @Override
    protected List<ProductionCycle> convertFrom(ResultSet resultSet) throws SQLException {
        List<ProductionCycle> productionCycles = new ArrayList<>();
        while (resultSet.next()) {
            ProductionCycle productionCycle = new ProductionCycle();

            productionCycle.setId(resultSet.getInt("id"));
            productionCycle.setYearNumber(resultSet.getInt("year_number"));
            productionCycle.setAdultAnimalFertilityRate(resultSet.getInt("adult_animal_fertility_rate"));
            productionCycle.setOldAnimalFertilityRate(resultSet.getInt("old_animal_fertility_rate"));
            productionCycle.setYoungAnimalSurvivalRate(resultSet.getInt("young_animal_survival_rate"));
            productionCycle.setOldAnimalFertilityRate(resultSet.getInt("old_animal_mortality_rate"));
            productionCycle.setNumberOfYoungAnimalsAtTheStartOfYear(resultSet.getInt("number_of_young_animals_at_the_start_of_year"));
            productionCycle.setNumberOfAdultAnimalsAtTheStartOfYear(resultSet.getInt("number_of_adult_animals_at_the_start_of_year"));
            productionCycle.setNumberOfOldAnimalsAtTheStartOfYear(resultSet.getInt("number_of_old_animals_at_the_start_of_year"));
            productionCycle.setNumberOfYoungAnimalsAtTheEndOfYear(resultSet.getInt("number_of_young_animals_at_the_end_of_year"));
            productionCycle.setNumberOfOldAnimalsAtTheEndOfYear(resultSet.getInt("number_of_adult_animals_at_the_end_of_year"));
            productionCycle.setFeedCostForOneAnimal(resultSet.getInt("number_of_old_animals_at_the_end_of_year"));
            productionCycle.setTotalFeedCost(resultSet.getInt("feed_cost_for_one_animal"));
            productionCycle.setNumberOfBornAnimals(resultSet.getInt("number_of_born_animals"));
            productionCycle.setNumberOfSoldAnimals(resultSet.getInt("number_of_sold_animals"));
            productionCycle.setTotalYearIncome(resultSet.getInt("total_year_income"));
            productionCycle.setTotalYearExpenses(resultSet.getInt("total_year_expenses"));
            productionCycle.setFarmCapital(resultSet.getInt("farm_capital"));

            productionCycles.add(productionCycle);
        }
        return productionCycles;
    }

    @Override
    protected String createInsertQuery(ProductionCycle productionCycle) {
        String fields = String.join(", ", columns);

        String values = productionCycle.getYearNumber() + ", "
                + productionCycle.getAdultAnimalFertilityRate() + ", "
                + productionCycle.getOldAnimalFertilityRate() + ", "
                + productionCycle.getYoungAnimalSurvivalRate() + ", "
                + productionCycle.getOldAnimalFertilityRate() + ", "
                + productionCycle.getNumberOfYoungAnimalsAtTheStartOfYear() + ", "
                + productionCycle.getNumberOfAdultAnimalsAtTheStartOfYear() + ", "
                + productionCycle.getNumberOfOldAnimalsAtTheStartOfYear() + ", "
                + productionCycle.getNumberOfYoungAnimalsAtTheEndOfYear() + ", "
                + productionCycle.getNumberOfOldAnimalsAtTheEndOfYear() + ", "
                + productionCycle.getFeedCostForOneAnimal() + ", "
                + productionCycle.getTotalFeedCost() + ", "
                + productionCycle.getNumberOfBornAnimals() + ", "
                + productionCycle.getNumberOfSoldAnimals() + ", "
                + productionCycle.getTotalYearIncome() + ", "
                + productionCycle.getTotalYearExpenses() + ", "
                + productionCycle.getFarmCapital();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(ProductionCycle productionCycle) {
        throw new UnsupportedOperationException();
    }
}
