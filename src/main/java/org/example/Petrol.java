package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Petrol {
    @JsonProperty("Location")
    private String location;

    @JsonProperty("Code")
    private String code;

    @JsonProperty("Month")
    private int month;

    @JsonProperty("Year")
    private int year;

    @JsonProperty("Value")
    private double value;

    @JsonProperty("Unit")
    private String unit;

    public Petrol() {}

    public Petrol(String location, String code, int month, int year, double value, String unit) {
        this.location = location;
        this.code = code;
        this.month = month;
        this.year = year;
        this.value = value;
        this.unit = unit;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
}
