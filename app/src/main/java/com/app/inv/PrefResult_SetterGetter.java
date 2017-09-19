package com.app.inv;

public class PrefResult_SetterGetter {
    private int image;
    private String planOne;
    private String planTwo;

    public PrefResult_SetterGetter(int image, String planOne, String planTwo) {
        this.image = image;
        this.planOne = planOne;
        this.planTwo = planTwo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPlanOne() {
        return planOne;
    }

    public void setPlanOne(String planOne) {
        this.planOne = planOne;
    }

    public String getPlanTwo() {
        return planTwo;
    }

    public void setPlanTwo(String planTwo) {
        this.planTwo = planTwo;
    }
}
