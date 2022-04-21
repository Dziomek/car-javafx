package com.example.car;

import java.util.ArrayList;

public class Competition {

    private ArrayList<Car> carArrayList = new ArrayList<>();

    public void add(Car car) {
        carArrayList.add(car);
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public void setCarArrayList(ArrayList<Car> carArrayList) {
        this.carArrayList = carArrayList;
    }
}
