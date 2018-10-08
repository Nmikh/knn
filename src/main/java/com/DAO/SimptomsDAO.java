package com.DAO;

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

    public List findAllObjects() throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM SET;");
        ResultSet result = preparedStatement.executeQuery();
        List objects = new ArrayList();
        while (result.next()) {
            objects.add(new DataObject(
                    result.getInt("SET.CLUMP_THICKNESS"),
                    result.getInt("SET.UNIFORMITY_OF_CELL_SIZE"),
                    result.getInt("SET.UNIFORMITY_OF_CELL_SHAPE"),
                    result.getInt("SET.MARGINAL_ADHESION"),
                    result.getInt("SET.SINGLE_EPITHELIAL_CELL_SIZE"),
                    result.getInt("SET.BARE_NUCLEI"),
                    result.getInt("SET.BLAND_CHROMATIN"),
                    result.getInt("SET.NORMAL_NUCLEOLI"),
                    result.getInt("SET.MITOSES"),
                    result.getInt("SET.CLASS")
            ));
        }
        return objects;
    }
}
