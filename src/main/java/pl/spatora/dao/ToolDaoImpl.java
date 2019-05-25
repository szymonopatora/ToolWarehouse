package pl.spatora.dao;

import pl.spatora.model.Tool;
import pl.spatora.model.ToolType;
import pl.spatora.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToolDaoImpl implements ToolDao {

    public List<Tool> getAllTools() {

        List<Tool> tools = new ArrayList<>();

        String selectSQL = "SELECT * FROM tools";

        try (Connection dbConnection = DBConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long toolId = rs.getLong("id");
                String toolName = rs.getString("name");
                ToolType toolType = ToolType.valueOf(rs.getString("type"));
                boolean toolAvailability = rs.getBoolean("available");

                tools.add(new Tool(toolId, toolName, toolType, toolAvailability));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tools;
    }

    public void setAvailability(Long id, boolean availability) {

        String selectSQL = "UPDATE tools SET available = ? WHERE id = ?";

        try (Connection dbConnection = DBConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setBoolean(1, availability);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
