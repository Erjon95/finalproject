package com.perscholas.nov2019.philly.capstone.finalproject.exceptions;

public class UserThereException extends Exception {

    private boolean isThere;

    public UserThereException(boolean isThere)
    {
        this.isThere = isThere;
    }

    public boolean isThere() {
        return isThere;
    }
}
