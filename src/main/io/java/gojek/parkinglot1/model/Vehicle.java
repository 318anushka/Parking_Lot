package main.io.java.gojek.parkinglot1.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class Vehicle implements Externalizable{

    private String registrationNo = null;
    private String color = null;

    public Vehicle(String registrationNo, String color)
    {
        this.registrationNo = registrationNo;
        this.color = color;
    }

    // getter for registration no
    public String getRegistrationNo()
    {
        return registrationNo;
    }

    // getter for color of vehicle
    public String getColor()
    {
        return color;
    }

    // setter for registration no
    public void setRegistrationNo(String registrationNo)
    {
        this.registrationNo = registrationNo;
    }

    //setter for color of vehicle
    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "[registrationNo=" + registrationNo + ", color=" + color + "]";
    }

    @Override
    public void writeExternal(ObjectOutput o) throws IOException
    {
        o.writeObject(getRegistrationNo());
        o.writeObject(getColor());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        setRegistrationNo((String) in.readObject());
        setColor((String) in.readObject());
    }



}
