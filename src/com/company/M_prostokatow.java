package com.company;

public class M_prostokatow extends Thread {
    double a;
    double b;
    double wynik;

    public M_prostokatow(double a, double b)
    {
        this.a = a;
        this.b = b;
        wynik = 0;
    }

    public static double f(double x)
    {
        return x*x+3;
    }

    public void run()
    {
        wynik = f(b);
    }

}

