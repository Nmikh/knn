package com;

import com.models.DataObject;
import com.models.MatrixModel;
import com.services.ObjectService;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        ObjectService objectService = new ObjectService();
//        DataObject o = new DataObject(5,1,1,1,2,1,1,1,1);
//        int classByObject = objectService.getClassByObject(o);
//        System.out.println(classByObject);
        MatrixModel matrix = objectService.getMatrix("all.txt");
        System.out.println(matrix);
    }
}
