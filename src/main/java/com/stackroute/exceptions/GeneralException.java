package com.stackroute.exceptions;

public class GeneralException  extends Exception{
    String mesaage;

    public GeneralException(String mesaage) {
        super(mesaage);
        this.mesaage = mesaage;
    }
}
