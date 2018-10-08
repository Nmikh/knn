package com.models;

public class MatrixModel {
    private int truePositive; //2-2
    private int falseNegative; //2-4
    private int trueNegative; //4-4
    private int falsePositive; //4-2
    private float accuracy;

    public MatrixModel() {
    }

    public MatrixModel(int truePositive, int falseNegative, int trueNegative, int falsePositive) {
        this.truePositive = truePositive;
        this.falseNegative = falseNegative;
        this.trueNegative = trueNegative;
        this.falsePositive = falsePositive;
    }

    public MatrixModel(int truePositive, int falseNegative, int trueNegative, int falsePositive, float accuracy) {
        this.truePositive = truePositive;
        this.falseNegative = falseNegative;
        this.trueNegative = trueNegative;
        this.falsePositive = falsePositive;
        this.accuracy = accuracy;
    }

    public int getTruePositive() {
        return truePositive;
    }

    public void setTruePositive(int truePositive) {
        this.truePositive = truePositive;
    }

    public int getFalseNegative() {
        return falseNegative;
    }

    public void setFalseNegative(int falseNegative) {
        this.falseNegative = falseNegative;
    }

    public int getTrueNegative() {
        return trueNegative;
    }

    public void setTrueNegative(int trueNegative) {
        this.trueNegative = trueNegative;
    }

    public int getFalsePositive() {
        return falsePositive;
    }

    public void setFalsePositive(int falsePositive) {
        this.falsePositive = falsePositive;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatrixModel that = (MatrixModel) o;

        if (truePositive != that.truePositive) return false;
        if (falseNegative != that.falseNegative) return false;
        if (trueNegative != that.trueNegative) return false;
        if (falsePositive != that.falsePositive) return false;
        return Float.compare(that.accuracy, accuracy) == 0;
    }

    @Override
    public int hashCode() {
        int result = truePositive;
        result = 31 * result + falseNegative;
        result = 31 * result + trueNegative;
        result = 31 * result + falsePositive;
        result = 31 * result + (accuracy != +0.0f ? Float.floatToIntBits(accuracy) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MatrixModel{" +
                "truePositive=" + truePositive +
                ", falseNegative=" + falseNegative +
                ", trueNegative=" + trueNegative +
                ", falsePositive=" + falsePositive +
                ", accuracy=" + accuracy +
                '}';
    }
}
