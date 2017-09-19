package com.app.inv;

public class InvestmentHistory_setterGetter {
    private String ack;
    private String amount;
    private String tenure;
    private String interest;
    private String status;

    public InvestmentHistory_setterGetter(String ack, String amount, String tenure, String interest, String status) {
        this.ack = ack;
        this.amount = amount;
        this.tenure = tenure;
        this.interest = interest;
        this.status = status;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTenure() {
        return tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
