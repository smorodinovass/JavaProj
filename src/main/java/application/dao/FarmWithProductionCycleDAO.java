package application.dao;


import application.model.FarmWithProductionCycle;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FarmWithProductionCycleDAO extends DAO<FarmWithProductionCycle> {

    public FarmWithProductionCycleDAO() {
        tableName = "farm_with_production_cycle";
        columns = new String[]{
                "farm_id",
                "production_cycle_id"
        };
    }

    @Override
    protected List<FarmWithProductionCycle> convertFrom(ResultSet resultSet) throws SQLException {
        List<FarmWithProductionCycle> farmWithProductionCycles = new ArrayList<>();
        while (resultSet.next()) {
            FarmWithProductionCycle farmWithProductionCycle = new FarmWithProductionCycle();

            farmWithProductionCycle.setFarmId(resultSet.getInt("farm_id"));
            farmWithProductionCycle.setProductionCycleId(resultSet.getInt("production_cycle_id"));

            farmWithProductionCycles.add(farmWithProductionCycle);
        }
        return farmWithProductionCycles;
    }

    @Override
    protected String createInsertQuery(FarmWithProductionCycle farmWithProductionCycle) {
        String fields = String.join(", ", columns);

        String values =
               farmWithProductionCycle.getFarmId() + ", "
                + farmWithProductionCycle.getProductionCycleId();
        return String.format("INSERT INTO %s (%s)"
                + "VALUES (%s)", tableName, fields, values);
    }

    @Override
    protected String createUpdateQuery(FarmWithProductionCycle farmWithProductionCycle) {
        throw new UnsupportedOperationException();
    }

    public boolean delete(Integer farmId, Integer productionCycleId) {
        final String query = String.format("DELETE FROM %s WHERE farm_id = %d and production_cycle_id = %d", tableName,
                farmId, productionCycleId);
        return executeModifyQuery(query);
    }
}
