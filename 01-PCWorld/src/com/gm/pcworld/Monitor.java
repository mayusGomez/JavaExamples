package com.gm.pcworld;

public class Monitor {

    private int monitorId;
    private String brand;
    private double inchs;
    private static int monitorCount;

    private Monitor(){
        this.monitorId = ++Monitor.monitorCount;
    }
    public Monitor(String brand, double inchs){
        this();
        this.brand = brand;
        this.inchs = inchs;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getInchs() {
        return inchs;
    }

    public void setInchs(double inchs) {
        this.inchs = inchs;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "monitorId=" + monitorId +
                ", brand='" + brand + '\'' +
                ", inchs=" + inchs +
                '}';
    }
}
