package model;

import java.util.Observable;

public class Model extends Observable {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        super.notifyObservers();
    }

    private String data = "Hej";

}
