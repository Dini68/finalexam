package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Workday {

    private String employeeName;
    private int workHours;
    private String date;

    public Workday(String employeeName, int workHours, String date) {
        this.employeeName = employeeName;
        this.workHours = workHours;
        this.date = date;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public void setDay(String date) {
        this.date = date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getWorkHours() {
        return workHours;
    }

    public String getDay() {
        return date;
    }

    @Override
    public String toString() {
        return employeeName + ": " + date;
    }
}
