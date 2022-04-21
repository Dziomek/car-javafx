package com.example.car;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Car extends Thread {

    private Engine engine;
    private Gearbox gearbox;
    private Position startPosition;
    private Position endPosition;

    private String model;
    private String registrationNumber;
    private int weight;
    private double currentSpeed;
    private Image image;

    int j = 0; // how much times we displayed on screen the end position

    public Car(double capacity, int numberOfGears, String model, String registrationNumber, String engineType) {
        engine = new Engine(capacity, engineType);
        gearbox = new Gearbox(numberOfGears);
        gearbox.setCurrentGear(0);
        startPosition = new Position(14, 14);
        endPosition = new Position(14, 14);

        setCurrentSpeed(0);

        this.model = model;
        this.registrationNumber = registrationNumber;
        weight = 2000;
        start();
    }

    public void carStart () {
        gearbox.setCurrentGear(0);
        engine.start();
    }

    public void carStop () {
        setCurrentSpeed(0);
        engine.stop();
    }

    public void increaseSpeed(double value){
        currentSpeed += value;
    }

    public void decreaseSpeed(double value){
        if (currentSpeed - value >= 0)
            currentSpeed -= value;
        else
            currentSpeed = 0;
    }

    @Override
    public String toString() {
        return
                "Model: '" + model + '\'' +
                ", Registration number: '" + registrationNumber + '\'';
    }

    public void takeStep() {
        double distance = Math.sqrt(Math.pow(
                endPosition.getX() - startPosition.getX(), 2) +
                Math.pow(endPosition.getY() - startPosition.getY(), 2));
        double iterations = distance * 25 / currentSpeed;
        double stepX = Math.abs(endPosition.getX() - startPosition.getX()) / iterations;
        double stepY = Math.abs(endPosition.getY() - startPosition.getY()) / iterations;
        if (Math.abs(endPosition.getX() - startPosition.getX()) > 2
                && Math.abs(endPosition.getY() - startPosition.getY()) > 2) {
            if (startPosition.getX() < endPosition.getX()
                    && startPosition.getY() < endPosition.getY()) {
                startPosition.setX(startPosition.getX() + stepX);
                startPosition.setY(startPosition.getY() + stepY);
            } else if (startPosition.getX() < endPosition.getX()
                    && startPosition.getY() > endPosition.getY()) {
                startPosition.setX(startPosition.getX() + stepX);
                startPosition.setY(startPosition.getY() - stepY);
            } else if (startPosition.getX() > endPosition.getX()
                    && startPosition.getY() < endPosition.getY()) {
                startPosition.setX(startPosition.getX() - stepX);
                startPosition.setY(startPosition.getY() + stepY);
            } else if (startPosition.getX() > endPosition.getX()
                    && startPosition.getY() > endPosition.getY()) {
                startPosition.setX(startPosition.getX() - stepX);
                startPosition.setY(startPosition.getY() - stepY);
            }
        }
        else {
            currentSpeed = 0;
            this.getEngine().setEngineSpeed(1000);
        }
    }

    public void run() {
        while(true) {
            try {
                takeStep();
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /////////////////////////////////////////////////////////////////////////

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Position endPosition) {
        this.endPosition = endPosition;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

