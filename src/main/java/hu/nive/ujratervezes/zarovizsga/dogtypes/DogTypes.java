package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> dogTypes = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT name, country " +
                        "FROM dog_types WHERE country = ? order BY name");
        ) {
            ps.setString(1, country);
            getDogTypes(dogTypes, ps);
            return dogTypes;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select country", se);
        }
    }

    private void getDogTypes(List<String> dogTypes, PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                dogTypes.add(rs.getString("name").toLowerCase());
            }
        }
    }
}
