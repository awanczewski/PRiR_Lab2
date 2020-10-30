package com.company;

public class Main {
    public static int n = 1000;
    public static double a = 1;
    public static double b = 10;
    public static double dx = (b - a) / n;
    public static void main(String[] args) {
        M_prostokatow[] watki_prostokatow = new M_prostokatow[n];
        M_trapezow[] watki_trapezow = new M_trapezow[n - 1];
        M_Simpsona[] watki_simpsona = new M_Simpsona[n - 1];
        double wynik_prostokatow = 0;
        double wynik_trapezow = 0;
        double wynik_simpsona = 0;
        double S = 0;
        for(int i = 1; i <= n; i++)
        {
           watki_prostokatow[i - 1] = new M_prostokatow(a + ((i - 1) * dx), a + (i * dx));
           watki_prostokatow[i - 1].start();
           if(i != n)
           {
               watki_trapezow[i - 1] = new M_trapezow(a + ((i - 1) * dx), a + (i * dx));
               watki_simpsona[i - 1] = new M_Simpsona(a + ((i - 1) * dx), a + (i * dx), dx);
               watki_trapezow[i - 1].start();
               watki_simpsona[i - 1].start();
           }
        }
        for( int i = 1; i <= n; i++)
        {
            try
            {
                watki_prostokatow[i - 1].join();
                wynik_prostokatow += watki_prostokatow[i - 1].wynik;
                if(i != n)
                {
                    watki_trapezow[i - 1].join();
                    watki_simpsona[i - 1].join();
                    wynik_trapezow += watki_trapezow[i - 1].wynik;
                    wynik_simpsona += watki_simpsona[i - 1].wynik;
                    S += watki_simpsona[i - 1].s;
                }
            }
            catch (Exception e){}
        }
        System.out.println("Wynik metody prostokątów to: " + wynik_prostokatow * dx);
        wynik_trapezow += ((M_trapezow.f(a) + M_trapezow.f(b)) / 2);
        System.out.println("Wynik metody trapezów to: " + wynik_trapezow * dx);
        S += M_Simpsona.f(b - dx / 2);
        System.out.println("Wynik metody simpsona to: " + ((dx/6) * (M_Simpsona.f(a) + M_Simpsona.f(b) + 2 * wynik_simpsona + 4 * S)));


    }
}
