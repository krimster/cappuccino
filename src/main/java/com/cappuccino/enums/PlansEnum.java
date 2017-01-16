package com.cappuccino.enums;

/**
 * Created by krime on 1/16/17.
 */
public enum PlansEnum {

    BASIC(1, "Basic"),
    PRO(2, "PRO");

    private int id;

    private String planName;

    PlansEnum(int id, String planName) {
        this.id = id;
        this.planName = planName;
    }

    public int getId() { return id; }

    public String getPlanName() { return planName; }

}
