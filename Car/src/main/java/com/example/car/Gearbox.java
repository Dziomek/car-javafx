package com.example.car;

public class Gearbox extends Component {

    private Clutch clutch;

    private int numberOfGears;
    private int currentGear;
    private double currentGearRatio;

    public Gearbox(int numberOfGears) {
        clutch = new Clutch();
        this.numberOfGears = numberOfGears;
        currentGear = 0;
    }

    public void increaseGear(Engine engine) {
        engine.decreaseEngineSpeed(500);

        if (engine.isStarted()) {
            if (currentGear <= numberOfGears) {
                clutch.putIn(); // wcisniecie sprzegla
                currentGear += 1;
                clutch.release(); // zwolnienie sprzegla
            }
            else {
                System.out.println("Najwyższy bieg już wbity");
            }
        }
        else {
            System.out.println("Najpierw wlacz silnik");
        }
    }

    public void decreaseGear() {
        currentGear -= 1;
    }

    public Clutch getClutch() {
        return clutch;
    }

    public void setClutch(Clutch clutch) {
        this.clutch = clutch;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public double getCurrentGearRatio() {
        return currentGearRatio;
    }

    public void setCurrentGearRatio(double currentGearRatio) {
        this.currentGearRatio = currentGearRatio;
    }
}
