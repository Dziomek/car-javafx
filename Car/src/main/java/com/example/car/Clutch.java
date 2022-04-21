package com.example.car;

public class Clutch extends Component {

    private boolean clutchCondition; //indicates if clutch condition is good (true) or not (false)
    private boolean put; //indicates if clutch is put in (true) or not (false)

    public Clutch() {
        setClutchCondition(true);
        setPut(false);
        setPrice(1000);
        setWeight(50);
    }

    public void putIn() {
        setPut(true);
    }

    public void release() {
        setPut(false);
    }

    public boolean isPut() {
        return put;
    }

    public void setPut(boolean put) {
        this.put = put;
    }

    public boolean isClutchCondition() {
        return clutchCondition;
    }

    public void setClutchCondition(boolean clutchCondition) {
        this.clutchCondition = clutchCondition;
    }
}
