package com.services;

import com.DAO.SimptomsDAO;
import com.models.DataObject;
import com.models.MatrixModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ObjectService {
    public static int k = 5;
    SimptomsDAO simptomsDAO = new SimptomsDAO();

    public ObjectService() throws SQLException, IOException, ClassNotFoundException {
    }

    public int getClassByObject(DataObject o) throws SQLException {
        ArrayList objs = (ArrayList) simptomsDAO.findAllObjects();
        return kNN(o, objs);
    }

    public MatrixModel getMatrix(String file) throws IOException, SQLException {
        FileReader input = new FileReader(file);
        BufferedReader bufRead = new BufferedReader(input);
        String line = null;

        MatrixModel matrixModel = new MatrixModel(0, 0, 0, 0, 0);

        int positive = 0;
        int negative = 0;
        while ((line = bufRead.readLine()) != null) {
            String[] array = line.split(",");
            DataObject o = new DataObject(
                    Integer.parseInt(array[2]),
                    Integer.parseInt(array[3]),
                    Integer.parseInt(array[4]),
                    Integer.parseInt(array[5]),
                    Integer.parseInt(array[6]),
                    Integer.parseInt(array[7]),
                    Integer.parseInt(array[8]),
                    Integer.parseInt(array[9]),
                    Integer.parseInt(array[10]),
                    Integer.parseInt(array[1])
            );
            int classByObject = this.getClassByObject(o);
            if (o.getCategory() == 2) {
                positive++;
                if (classByObject == 2)
                    matrixModel.setTruePositive(matrixModel.getTruePositive() + 1);
                else
                    matrixModel.setFalseNegative(matrixModel.getFalseNegative() + 1);
            } else {
                negative++;
                if (classByObject == 4)
                    matrixModel.setTrueNegative(matrixModel.getTrueNegative() + 1);
                else
                    matrixModel.setFalsePositive(matrixModel.getFalsePositive() + 1);
            }
        }
        matrixModel.setAccuracy(
                ((float) matrixModel.getTruePositive() + (float) matrixModel.getTrueNegative())
                        /
                        ((float) positive + (float) negative));
        return matrixModel;
    }

    public static int kNN(DataObject o, ArrayList<DataObject> objs) {
        int[] indices = new int[k];
        double[] mins = new double[k];
        for (int i = 0; i < k; i++) {
            mins[i] = Double.MAX_VALUE;
        }

        for (int i = 0; i < objs.size(); i++) {
            double dist = distance(o, objs.get(i));
            double max = Double.MIN_VALUE;
            int maxIdx = 0;
            for (int j = 0; j < k; j++) {
                if (max < mins[j]) {
                    max = mins[j];
                    maxIdx = j;
                }
            }
            if (mins[maxIdx] > dist) {
                mins[maxIdx] = dist;
                indices[maxIdx] = i;
            }
        }

        int a = 2;
        int b = 2;
        for (int i = 0; i < k; i++) {
            if (objs.get(indices[i]).getCategory() == 2) {
                a++;
            } else {
                b++;
            }
        }
        if (a > b) {
            return 2;
        } else {
            return 4;
        }
    }

    public static double distance(DataObject o, DataObject ref) {
        return Math.pow(o.getClumpThickness() - ref.getClumpThickness(), 2) +
                Math.pow(o.getUniformityOfCellSize() - ref.getUniformityOfCellSize(), 2) +
                Math.pow(o.getUniformityOfCellShape() - ref.getUniformityOfCellShape(), 2) +
                Math.pow(o.getMarginalAdhesion() - ref.getMarginalAdhesion(), 2) +
                Math.pow(o.getSingleEpithelialCellSize() - ref.getSingleEpithelialCellSize(), 2) +
                Math.pow(o.getBareNuclei() - ref.getBareNuclei(), 2) +
                Math.pow(o.getBlandChromatin() - ref.getBlandChromatin(), 2) +
                Math.pow(o.getNormalNucleoli() - ref.getNormalNucleoli(), 2) +
                Math.pow(o.getMitoses() - ref.getMitoses(), 2);
    }

}
