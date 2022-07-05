package oop;

import java.io.Serializable;

public class Parent implements Serializable {

    private Long id;

    private String name;

    protected Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
