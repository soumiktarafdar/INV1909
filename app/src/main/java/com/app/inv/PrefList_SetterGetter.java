package com.app.inv;

public class PrefList_SetterGetter {
    private String amount;
    private String rate;
    private String tenure;
    private String date;

    public PrefList_SetterGetter(String amount, String rate, String tenure, String date) {
        this.amount = amount;
        this.rate = rate;
        this.tenure = tenure;
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
