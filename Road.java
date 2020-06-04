package com.company;

import java.util.ArrayList;
import java.util.List;

public class Road
{
    public List<Vehicle> carsInRoad = new ArrayList<Vehicle>();
    public int getCountOfHumans()
    {
        int count =0;
        for(int i=0;i<carsInRoad.size();i++)
        {
            count+=carsInRoad.get(i).passanger;
        }
        return count;
    }
    public void addCarToRoad(Object Ob)
    {
        if(Ob  instanceof Bus)
        {
            Vehicle V = new Vehicle();
            V.Tupe =0;
            V.namber=((Bus) Ob).namber;
            V.passanger=((Bus) Ob).passenger;
            carsInRoad.add(V);

        }

        if(Ob  instanceof Car)
        {
            Vehicle V = new Vehicle();
            V.Tupe =((Car) Ob).Tupe;
            V.namber=((Car) Ob).namber;
            V.passanger=((Car) Ob).passenger;
            carsInRoad.add(V);
           // System.out.println("JR");

        }

    }
//qwd
}
class Vehicle
{
    int Tupe;
    int namber;
    int passanger;
}

