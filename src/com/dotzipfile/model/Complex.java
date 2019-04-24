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
        setReal(getReal() * other.getReal());
        setImag(getImag() * other.getImag());
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
