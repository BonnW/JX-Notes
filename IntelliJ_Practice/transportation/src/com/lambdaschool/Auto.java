package com.lambdaschool;

public class Auto extends AbstractVehicle
{
    private String model;

    public Auto(String model, int fuel)
    {
        super(fuel);
    }

    @Override
    public String getPath()
    {
        return "Road";
    }

    @Override
    public String getName()
    {
        return model;
    }
}
