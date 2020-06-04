package com.company;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main
{
    static ArrayList<Person> person = new ArrayList<Person>();
    static ArrayList<Fire> fire = new ArrayList<Fire>();
    static ArrayList<Police> police = new ArrayList<Police>();
    static int Key_Gl=0;


    static ArrayList<Bus> bus = new ArrayList<Bus>();
    static ArrayList<Car> cars = new ArrayList<Car>();
    static int namber_Gl = 0;

    static ArrayList<Pasangers> Pas = new ArrayList<Pasangers>();

    static int Count =0;
    public static void main(String[] args)
    {
        Test();
    }




    public static void Test()
    {


        int k=0;
        Add_Taxi();
        Add_Police();
        Add_Police();
        for(int i=0;i<6;i++)
        {
            Add_Person();
        }

        for(int i=0;i<6;i++)
        {
            boolean result = Board(i,0);
            if((result)&&(i<4)){k+=1;}
            if((!result)&&(i>=4)){k+=1;}
           // System.out.println(result);
        }
        for(int i=0;i<2;i++)
        {
            boolean result = UN_Board(i,0);
            if(result){k+=1;}
           // System.out.println(result);
        }
        for(int i=0;i<2;i++)
        {
            boolean result = UN_Board(i,0);
            if(!result){k+=1;}
           // System.out.println(result);
        }

        System.out.println(k+" /10");
        for(int i =6;i<10;i++)
        {

            Add_Polise_person();
            Board(i,1);
        }

        Road road = new Road();
        road.addCarToRoad(cars.get(1));
        if(road.getCountOfHumans()==4){System.out.println("Ok");};


    }
    public static int Add_Person()
    {

        Random ran = new Random();
        int key = Key_Gl;
        Key_Gl+=1;
        Person per = new Person();
        per.key=key;
        per.age=20+ran.nextInt(60);
        per.M_F=true;
        per.name="Name"+key;

        person.add(per);

        return  key;
    }

    public static int Add_Polise_person()
    {

        Random ran = new Random();
        int key = Key_Gl;
        Key_Gl+=1;
        Police per = new Police();
        per.key=key;
        per.age=20+ran.nextInt(60);
        per.M_F=true;
        per.name="Name"+key;
        per.rank="Officer";
        per.work_place = "Police station";

        police.add(per);
        return  key;
    }
    public static int Add_Fire_person()
    {

        Random ran = new Random();
        int key = Key_Gl;
        Key_Gl+=1;
        Fire per = new Fire();
        per.key=key;
        per.age=20+ran.nextInt(60);
        per.M_F=true;
        per.name="Name"+key;
        per.work_place = "Fire station";
        fire.add(per);
        return  key;
    }
    public static int Add_Bus()
    {

        int place=24;
        int nambe = namber_Gl;
        namber_Gl+=1;
        Bus b = new Bus();
        b.places=place;
        b.empty=place;
        b.passenger=0;
        b.namber=nambe;
        bus.add(b);
        return  nambe;
    }
    public static int Add_Taxi()
    {
        int place=4;
        int namber = namber_Gl;
        namber_Gl+=1;
        Car b = new Car();
        b.places=place;
        b.empty=place;
        b.passenger=0;
        b.namber=namber;
       // System.out.println("add "+b.namber);

        b.Tupe=1;
        cars.add(b);
        return  namber;
    }
    public static int Add_Fire()
    {
        int place=4;
        int namber = namber_Gl;
        namber_Gl+=1;
        Car b = new Car();
        b.places=place;
        b.empty=place;
        b.passenger=0;
        b.namber=namber;
        b.Tupe=3;
        cars.add(b);
        return  namber;
    }
    public static int Add_Police()
    {
        int place=4;
        int namber = namber_Gl;
        namber_Gl+=1;
        Car b = new Car();
        b.places=place;
        b.empty=place;
        b.passenger=0;
        b.namber = namber;
        b.Tupe=2;
        cars.add(b);
        return  namber;
    }
    public static boolean Board(int key, int namber)
    {
        int tupe = Search(key);
      //  System.out.println("Tupe: "+tupe);
      //  System.out.println("namb: "+namber);
        for(int i=0;i<bus.size();i++)
        {
            if(namber==bus.get(i).namber)
            {
                if(tupe==1)
                {
                    Bus b = new Bus();
                    b=bus.get(i);
                    if(b.empty>=1)
                    {
                        b.empty-=1;b.passenger+=1;bus.set(i,b);
                        Pasangers p = new Pasangers();
                        p.key=key; p.namber = namber;
                        Pas.add(p);
                        return true;
                    }
                    else{return false;}
                }
                else{return false;}
            }
        }
        for(int i=0;i<cars.size();i++)
        {
           // System.out.println(" i: " +cars.get(i).namber);
            if(namber==cars.get(i).namber)
            {


                if(tupe==cars.get(i).Tupe)
                {
                   // System.out.println(" GF");
                    Car b = new Car();
                    b=cars.get(i);
                    if(b.empty>=1)
                    {
                        b.empty-=1;b.passenger+=1;cars.set(i,b);
                        Pasangers p = new Pasangers();
                        p.key=key; p.namber = namber;
                        Pas.add(p);
                        return true;
                    }
                    else{return false;}
                }
                else
                {return false;}
            }
        }


        return false;
    }

    public static boolean UN_Board(int key, int namber)
    {
        int tupe = Search(key);
        if(tupe==1)
        {
            for (int i = 0; i < bus.size(); i++)
            {
                if (namber == bus.get(i).namber)
                {

                        Bus b = new Bus();
                        b = bus.get(i);
                        if (b.passenger >= 1)
                        {
                            for(int j=0;j<Pas.size();j++)
                            {
                                if((key==Pas.get(j).key)&&(namber==Pas.get(j).namber))
                                {
                                    b.empty += 1;
                                    b.passenger -= 1;
                                    bus.set(i, b);
                                    Pas.remove(i);
                                    return true;

                                }
                            }

                        }
                        else
                            {
                                return false;
                            }


                }
            }
        }
        for(int i=0;i<cars.size();i++)
        {
            if(namber==cars.get(i).namber)
            {
                if(tupe==cars.get(i).Tupe)
                {
                    Car b = new Car();
                    b=cars.get(i);
                    if (b.passenger >= 1)
                    {
                        for(int j=0;j<Pas.size();j++)
                        {
                            if((key==Pas.get(j).key)&&(namber==Pas.get(j).namber))
                            {
                                b.empty += 1;
                                b.passenger -= 1;
                                cars.set(i, b);
                                Pas.remove(i);
                                return true;

                            }
                        }

                    }
                    else
                    {
                        return false;
                    }

                }
                else
                {return false;}
            }
        }


        return false;
    }

    public static int Search(int key)
    {

        for(int i=0;i<person.size();i++)
        {
            if(key==person.get(i).key){return 1;}
        }
        for(int i=0;i<police.size();i++)
        {
            if(key==police.get(i).key){return 2;}
        }
        for(int i=0;i<fire.size();i++)
        {
            if(key==fire.get(i).key){return 3;}
        }
        return -1;
    }
}

class Person
{
    int key;
    String name;
    int age;
    boolean M_F;
}

class Fire extends Person
{
    String work_place;
}
class Police extends Person
{
    String rank;
    String work_place;
}

class Transport
{
    int places;
    int passenger;
    int empty;
    int namber;

    int Get_places(){return places; }
    int Get_pass(){return passenger;}
    int Get_empty(){return  passenger;}

}

class Car extends Transport
{

   int Tupe;

}
class Taxi extends Car
{
    Taxi()
    {places=4;empty =4;passenger=0;Tupe=1;}
}
class Police_car extends  Car
{
    Police_car()
    {places=4;empty =4;passenger=0;Tupe=2;}
}
class Fire_car extends Car
{
    Fire_car()
    {places=4;empty =4;passenger=0;Tupe=3;}
}
class Bus extends  Transport
{
    Bus()
    {places=32;empty =32;passenger=0;}
}
class Pasangers
{
    int key;
    int namber;
}



