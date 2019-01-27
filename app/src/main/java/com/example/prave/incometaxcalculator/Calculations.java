package com.example.prave.incometaxcalculator;

/**
 * Created by Praveen John on 27-01-2019.
 */
public class Calculations {
    int percent;
    private int output;
    int totalamount;
    int soutput;
    private int taxrate;
    private int indlSlab1 = 250000;
    private int indiadditional = 350000;
    private int REBATE = 2500;
    private int indlSlab2 = 500000;
    private int indlSlab3 = 1000000;
    private int sSlab1 = 300000;
    private int sSlab2 = 500000;
    private int sSlab3 = 1000000;
    private int supersSlab1 = 300000;
    private int supersSlab2 = 500000;
    private int ssuperSlab3 = 1000000;
    private int deduction = 0;


    public DataObject inidivdualcalculation(int data) {
        int largeamt = 0;
        int largeamt2 = 0;
        int largeamt3 = 0;
        float tax1 = 0;
        float tax2 = 0;
        float tax3 = 0;
        float beforerebate = 0;
        this.totalamount = data;
        DataObject dataObject = new DataObject();
        if (data <= indlSlab1) {
            dataObject.setMedical(0);
            dataObject.setTotalpayable(0);
            return dataObject;

        } else if (data > indlSlab3) {
            largeamt = data - indlSlab3;
            taxrate = 30;
            tax1 = calculateoutput(largeamt, "i", taxrate);


        }
        if (data > indlSlab2) {
            largeamt2 = data - (indlSlab2 + largeamt);
            taxrate = 20;
            tax2 = calculateoutput(largeamt2, "i", taxrate);
        }
        if (data > indlSlab1) {
            largeamt3 = data - (indlSlab1 + largeamt + largeamt2);
            taxrate = 5;
            tax3 = calculateoutput(largeamt3, "i", taxrate);

        }
        float totaltax = tax1 + tax2 + tax3;

        if ((indlSlab1 < data) && (data < indiadditional)) {
            totaltax = totaltax - REBATE;
            dataObject.setRebate(true);
        }

        float includingmedicalcare = (totaltax * (4 / 100.0f));
        float totalpayable = totaltax + includingmedicalcare;
        if (totaltax < 0) {
            totaltax = 0;
        }
        if (includingmedicalcare < 0) {
            includingmedicalcare = 0;
        }
        if (totalpayable < 0) {
            totalpayable = 0;
        }
        dataObject.setTotaltax(totaltax);
        dataObject.setMedical(includingmedicalcare);
        dataObject.setTotalpayable(totalpayable);
        return dataObject;

    }


    private float calculateoutput(int data, String who, int taxrate1) {

        DataObject dataObject = new DataObject();
        float k = (data * (taxrate1 / 100.0f));
        return k;
    }

}
