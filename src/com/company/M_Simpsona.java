package com.company;

public class M_Simpsona extends Thread{
    double a;
    double b;
    double dx;
    double wynik;
    double s;

    public M_Simpsona(double a, double b, double dx)
    {
        this.a = a;
        this.b = b;
        this.dx = dx;
    }

    public static double f(double x)
    {
        return x*x+3;
    }

    public void run()
    {
        s = f(b - dx / 2);
        wynik = f(b);
    }


}
