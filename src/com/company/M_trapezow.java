package com.company;

public class M_trapezow extends Thread {
    double a;
    double b;
    double wynik;

    public M_trapezow(double a, double b)
    {
        this.a = a;
        this.b = b;
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
