package org.example;

public class Note {
    String name = null;
    float number = 0.0f;
    public Note(String name, float number) {
        this.name = name;
        this.number = number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Float getNote() {
        return number ;
    }

    public void setName(String name) {
        this.name = name;
    }
}
