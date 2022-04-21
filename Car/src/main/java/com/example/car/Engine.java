package com.example.car;

public class Engine extends Component {

    private double engineSpeed;
    private double maxEngineSpeed;
    private double capacity;
    private boolean isStarted; /// indicates if engine is started or not
    private String type;


    public Engine(double capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        maxEngineSpeed = 9000;
        if (capacity < 1.6)
            setMaxEngineSpeed(6000);
        else if(capacity < 3)
            setMaxEngineSpeed(7000);
        else
            setMaxEngineSpeed(9000);

        setStarted(false);
        setEngineSpeed(0.0);
    }

    public void start() {
        setStarted(true);
        setEngineSpeed(1000);
    }

    public void stop() {
        setStarted(false);
        setEngineSpeed(0);
    }

    public void increaseEngineSpeed(double value) {
        if(isStarted) {
            if(engineSpeed + value <= maxEngineSpeed) {
                engineSpeed += value;
            }
            else{
                System.out.println("Nie można już dodać obrotów");
            }
        }
    }

    public void decreaseEngineSpeed(double value) {
        if(isStarted) {
            if(engineSpeed - value >= 0) {
                engineSpeed -= value;
            }
            else {
                setStarted(false);
                stop();
            }
        }
    }


    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(double engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public double getMaxEngineSpeed() {
        return maxEngineSpeed;
    }

    public void setMaxEngineSpeed(double maxEngineSpeed) {
        this.maxEngineSpeed = maxEngineSpeed;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
