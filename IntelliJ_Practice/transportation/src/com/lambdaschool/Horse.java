package com.lambdaschool;

public class Horse implements Vehicle, Animal
{
    public Horse(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Horse(String name, int fuel)
    {
        this.name = name;
        this.fuel = fuel;
    }

    private int fuel = 0;
    private String name;

    @Override
    public void eat(int i)
    {
        fuel++;
    }

    @Override
    public String speak()
    {
        return "Neigh";
    }

    @Override
    public String getPath()
    {
        return "Grass";
    }

    @Override
    public void move()
    {
        fuel--;
    }

    @Override
    public int getFuelLevel()
    {
        return 0;
    }

    @Override
    public void addFuel(int i)
    {
        fuel = fuel + i;
    }
}
