package com.example.prave.incometaxcalculator;

/**
 * Created by Praveen John on 27-01-2019.
 */
public class DataObject {

    float totaltax;
    float medical;
    float totalpayable;

    public boolean isRebate() {
        return rebate;
    }

    public void setRebate(boolean rebate) {
        this.rebate = rebate;
    }

    boolean rebate;

    public float getTotaltax() {
        return totaltax;
    }

    public void setTotaltax(float totaltax) {
        this.totaltax = totaltax;
    }

    public float getMedical() {
        return medical;
    }

    public void setMedical(float medical) {
        this.medical = medical;
    }

    public float getTotalpayable() {
        return totalpayable;
    }

    public void setTotalpayable(float totalpayable) {
        this.totalpayable = totalpayable;
    }

    public DataObject() {

    }
}
