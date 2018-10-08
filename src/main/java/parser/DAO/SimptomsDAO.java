package parser.DAO;

import com.models.DataObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SimptomsDAO {
    Connection connection;

    public SimptomsDAO() throws IOException, ClassNotFoundException, SQLException {
        InputStream resourceAsStream = Properties.class.getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);

        SimptomsDAO.class.getClass().forName("org.h2.Driver");
        connection = DriverManager.getConnection(
                (String) properties.get("url"),
                (String) properties.get("login"),
                (String) properties.get("password"));

    }

    public void addObject(DataObject o) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO SET (" +
                        "  CLUMP_THICKNESS," +
                        "  UNIFORMITY_OF_CELL_SIZE," +
                        "  UNIFORMITY_OF_CELL_SHAPE," +
                        "  MARGINAL_ADHESION," +
                        "  SINGLE_EPITHELIAL_CELL_SIZE," +
                        "  BARE_NUCLEI," +
                        "  BLAND_CHROMATIN," +
                        "  NORMAL_NUCLEOLI," +
                        "  MITOSES," +
                        "  CLASS) VALUES (?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setInt(1, o.getClumpThickness());
        preparedStatement.setInt(2, o.getUniformityOfCellSize());
        preparedStatement.setInt(3, o.getUniformityOfCellShape());
        preparedStatement.setInt(4, o.getMarginalAdhesion());
        preparedStatement.setInt(5, o.getSingleEpithelialCellSize());
        preparedStatement.setInt(6, o.getBareNuclei());
        preparedStatement.setInt(7, o.getBlandChromatin());
        preparedStatement.setInt(8, o.getNormalNucleoli());
        preparedStatement.setInt(9, o.getMitoses());
        preparedStatement.setInt(10, o.getCategory());

        preparedStatement.execute();
    }
}
