package com.models;

public class DataObject {

    private int clumpThickness;
    private int uniformityOfCellSize;
    private int uniformityOfCellShape;
    private int marginalAdhesion;
    private int singleEpithelialCellSize;
    private int bareNuclei;
    private int blandChromatin;
    private int normalNucleoli;
    private int mitoses;
    private int category;

    public DataObject(int clumpThickness,
                      int uniformityOfCellSize,
                      int uniformityOfCellShape,
                      int marginalAdhesion,
                      int singleEpithelialCellSize,
                      int bareNuclei,
                      int blandChromatin,
                      int normalNucleoli,
                      int mitoses,
                      int category) {
        this.clumpThickness = clumpThickness;
        this.uniformityOfCellSize = uniformityOfCellSize;
        this.uniformityOfCellShape = uniformityOfCellShape;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
        this.category = category;
    }

    public DataObject(int clumpThickness,
                      int uniformityOfCellSize,
                      int uniformityOfCellShape,
                      int marginalAdhesion,
                      int singleEpithelialCellSize,
                      int bareNuclei,
                      int blandChromatin,
                      int normalNucleoli,
                      int mitoses) {
        this.clumpThickness = clumpThickness;
        this.uniformityOfCellSize = uniformityOfCellSize;
        this.uniformityOfCellShape = uniformityOfCellShape;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
    }

    public int getClumpThickness() {
        return clumpThickness;
    }

    public void setClumpThickness(int clumpThickness) {
        this.clumpThickness = clumpThickness;
    }

    public int getUniformityOfCellSize() {
        return uniformityOfCellSize;
    }

    public void setUniformityOfCellSize(int uniformityOfCellSize) {
        this.uniformityOfCellSize = uniformityOfCellSize;
    }

    public int getUniformityOfCellShape() {
        return uniformityOfCellShape;
    }

    public void setUniformityOfCellShape(int uniformityOfCellShape) {
        this.uniformityOfCellShape = uniformityOfCellShape;
    }

    public int getMarginalAdhesion() {
        return marginalAdhesion;
    }

    public void setMarginalAdhesion(int marginalAdhesion) {
        this.marginalAdhesion = marginalAdhesion;
    }

    public int getSingleEpithelialCellSize() {
        return singleEpithelialCellSize;
    }

    public void setSingleEpithelialCellSize(int singleEpithelialCellSize) {
        this.singleEpithelialCellSize = singleEpithelialCellSize;
    }

    public int getBareNuclei() {
        return bareNuclei;
    }

    public void setBareNuclei(int bareNuclei) {
        this.bareNuclei = bareNuclei;
    }

    public int getBlandChromatin() {
        return blandChromatin;
    }

    public void setBlandChromatin(int blandChromatin) {
        this.blandChromatin = blandChromatin;
    }

    public int getNormalNucleoli() {
        return normalNucleoli;
    }

    public void setNormalNucleoli(int normalNucleoli) {
        this.normalNucleoli = normalNucleoli;
    }

    public int getMitoses() {
        return mitoses;
    }

    public void setMitoses(int mitoses) {
        this.mitoses = mitoses;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataObject that = (DataObject) o;

        if (clumpThickness != that.clumpThickness) return false;
        if (uniformityOfCellSize != that.uniformityOfCellSize) return false;
        if (uniformityOfCellShape != that.uniformityOfCellShape) return false;
        if (marginalAdhesion != that.marginalAdhesion) return false;
        if (singleEpithelialCellSize != that.singleEpithelialCellSize) return false;
        if (bareNuclei != that.bareNuclei) return false;
        if (blandChromatin != that.blandChromatin) return false;
        if (normalNucleoli != that.normalNucleoli) return false;
        if (mitoses != that.mitoses) return false;
        return category == that.category;
    }

    @Override
    public int hashCode() {
        int result = clumpThickness;
        result = 31 * result + uniformityOfCellSize;
        result = 31 * result + uniformityOfCellShape;
        result = 31 * result + marginalAdhesion;
        result = 31 * result + singleEpithelialCellSize;
        result = 31 * result + bareNuclei;
        result = 31 * result + blandChromatin;
        result = 31 * result + normalNucleoli;
        result = 31 * result + mitoses;
        result = 31 * result + category;
        return result;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "clumpThickness=" + clumpThickness +
                ", uniformityOfCellSize=" + uniformityOfCellSize +
                ", uniformityOfCellShape=" + uniformityOfCellShape +
                ", marginalAdhesion=" + marginalAdhesion +
                ", singleEpithelialCellSize=" + singleEpithelialCellSize +
                ", bareNuclei=" + bareNuclei +
                ", blandChromatin=" + blandChromatin +
                ", normalNucleoli=" + normalNucleoli +
                ", mitoses=" + mitoses +
                ", category=" + category +
                '}';
    }
}
