package com.capgemini.completion_stage;

public class Bean {

    private long id;

    public Bean(Long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bean id = " + id;
    }
}
