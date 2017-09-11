package com.example.andrelewkowiczkatz.testrest;

/**
 * Created by andrelewkowiczkatz on 27/08/17.
 */

public class City {

    private int id;
    private String name;
    private int idState;

    public City() {
    }

    public City(int id, String name, int idState) {
        this.id = id;
        this.name = name;
        this.idState = idState;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }


}
