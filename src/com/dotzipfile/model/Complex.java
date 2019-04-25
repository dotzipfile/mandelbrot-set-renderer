package com.dotzipfile.model;

public class Complex {

    private double real;
    private double imag;

    public Complex(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    public Complex add(Complex other) {
        setReal(getReal() + other.getReal());
        setImag(getImag() + other.getImag());
        return this;
    }

    public Complex multiply(Complex other) {
        /*
         * e.g (4 + 5i)(2 + 7i)
         * = 4(2 + 7i) + 5i(2 + 7i)
         * = (4 * 2) + (4 * 7i) + (5i * 2) + (5i * 7i)
         * = 8 + 28i + 10i + 35i^2
         * i^2 is -1
         * = 8 + 38i + (35 * -1)
         * = -27 + 38i
         *
         * TODO: ^^ ... I need to double check that
         */

        // Really had to spell that out for myself
        double realOne = getReal() * other.getReal();
        double imagOne = getReal() * other.getImag();
        double imagTwo = getImag() * other.getReal();
        double imagThreeSquared = getImag() * other.getImag();

        double finalReal = realOne + (imagThreeSquared * (-1));
        double finalImag = imagOne + imagTwo;

        setReal(finalReal);
        setImag(finalImag);
        return this;
    }

    public double getMagnitude() {
        multiply(this);
        return Math.sqrt(getReal() + getImag());
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getImag() {
        return imag;
    }
}
