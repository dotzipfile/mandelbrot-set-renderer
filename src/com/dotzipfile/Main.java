package com.dotzipfile;

import com.dotzipfile.model.Complex;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.buildSet();
    }

    public void buildSet() {
        double imag = 0;
        for(double i = 0; i < 2; i += 0.001) {
            run(i, imag);
            imag += 0.0001;
            sleep(250);
        }
    }

    public void run(double cReal, double cImag) {
        Complex complex = new Complex(0, 0);
        int iterations = 0;
        Complex c = new Complex(cReal, cImag);
        double mag = complex.getMagnitude();

        while(mag <= 2.0 && iterations < 200) {
            complex = calculate(complex, c);
            iterations ++;
            mag = complex.getMagnitude();
            if(mag > 2.0) {
                System.out.println("Not in set");
            }
        }

        if(iterations == 200 && mag <= 2.0) {
            System.out.println("In set");
        }
    }

    public Complex calculate(Complex complex, Complex c) {
        return complex.multiply(complex).add(c);
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
