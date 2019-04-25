package com.dotzipfile.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexTest {

    @Test
    public void testAdd() {
        Complex z = new Complex(3, 2);
        Complex c = new Complex(5, -1);

        z = z.add(c);

        assertTrue(8.0 == z.getReal());
        assertTrue(1.0 == z.getImag());
    }

    @Test
    public void testMultiply() {
        Complex z = new Complex(3, 1);
        Complex c = new Complex(2, 4);

        z = z.multiply(c);

        assertTrue(2.0 == z.getReal());
        assertTrue(14.0 == z.getImag());
    }

    @Test
    public void testMultiplyWithNegative() {
        Complex z = new Complex(2, 3);
        Complex c = new Complex(2, -3);

        z = z.multiply(c);

        assertTrue(13.0 == z.getReal());
        assertTrue(0.0 == z.getImag());
    }

    @Test
    public void testGetMagnitude() {
        Complex z = new Complex(-3, 4);

        double result = z.getMagnitude();

        assertTrue(result == 5);
    }
}