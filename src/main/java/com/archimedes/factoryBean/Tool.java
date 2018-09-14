package com.archimedes.factoryBean;

public class Tool {
 
    private int id;
 
    // standard constructors, getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tool(int id) {
        this.id = id;
    }
}