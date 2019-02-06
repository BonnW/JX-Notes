package com.lambdaschool;

import java.util.ArrayList;

public class Main
{
    public static void printVehicles(ArrayList<AbstractVehicle> vehicles, CheckVehicle tester)
    {
        for (AbstractVehicle v : vehicles)
        {
            if(tester.test(v))
            {
                System.out.println(v.getName());
            }
        }
    }

    public static void main(String[] args)
    {
        Horse seabiscuit = new Horse("Seabiscuit", 10);
        Horse joe = new Horse("Joe");
        Horse affirmed = new Horse("Affirmed");

        HorseFromVehicle seattleSlew = new HorseFromVehicle("Seattle Slew", 10);

        ArrayList<AbstractVehicle> myList = new ArrayList<AbstractVehicle>();
        myList.add(new HorseFromVehicle("Secretariat"));
        myList.add(new HorseFromVehicle("Trigger"));
        myList.add(new HorseFromVehicle("Seattle Slew"));
        myList.add(new HorseFromVehicle("American Pharoah"));
        myList.add(new HorseFromVehicle("Eclipse"));
        myList.add(new Auto("VW", 10));
        myList.add(new Auto("Toyota", 10));
        myList.add(new Auto("Honda", 25));

//        List all vehicles with fuel greater than 5
//        Lambda Expression

        printVehicles(myList, v -> v.getFuelLevel() > 5);
        System.out.println("\nGrass");
        printVehicles(myList, v -> v.getPath().equals("Grass"));
//        myList.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        System.out.println("\nsorted");
        myList.forEach(((v) -> System.out.println(v.getName())));

        myList.sort((v1, v2) -> v1.getFuelLevel() - v2.getFuelLevel());
        myList.forEach((v) -> System.out.println(v.getFuelLevel()));
    }
}
