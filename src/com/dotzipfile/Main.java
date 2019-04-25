package com.dotzipfile;

import com.dotzipfile.model.Complex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class Main {

    private static double startX = -2;
    private static double width = 4;
    private static double startY = 2;
    private static double height = 4;
    private static int rowsCols = 101;
    private static double maxMagnitude = 2.0;
    private static int maxIterations = 100;

    public static void main(String[] args) {
        double dx = width / (rowsCols - 1);
        double dy = height / (rowsCols - 1);

        byte[][] mandelbrotValues = new byte[rowsCols][rowsCols];

        for(int i = 0; i < rowsCols; i ++) {
            for(int j = 0; j < rowsCols; j ++) {
                Complex z = new Complex(0, 0);

                double cx = startX + (j * dx);
                double cy = startY + (i * dy);

                Complex c = new Complex(cx, cy);

                int iterations = 0;
                while(true) {

                    z = z.multiply(z).add(c);

                    iterations ++;
                    if(iterations >= maxIterations || z.getMagnitude() > maxMagnitude) {
                        break;
                    }
                }

                if(iterations >= maxIterations && z.getMagnitude() <= maxMagnitude) {
                    mandelbrotValues[i][j] = (byte)0;
                } else {
                    mandelbrotValues[i][j] = (byte)iterations;
                }

                System.out.println(z.getMagnitude());
            }
        }

//        for(int i = 0; i < rowsCols; i ++) {
//            for(int j = 0; j < rowsCols; j ++) {
//                /*
//                 * TODO: This is a dirty hack because I'm getting some NAN's from Math.sqrt()
//                 * I think it's from trying to get the sqrt of - numbers
//                 * So there's probably some error in my code
//                 * but I want to try and render it anyway to see if it's any way close
//                 */
//                if(mandelbrotValues[i][j] == 100) {
//                    mandelbrotValues[i][j] = 0;
//                } else {
//                    mandelbrotValues[i][j] = 1;
//                }
//            }
//        }
//
//        BufferedImage finalImg = toBufferedImage(mandelbrotValues);
//
//        try {
//            File outputfile = new File("mandelbrot.png");
//            ImageIO.write(finalImg, "png", outputfile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static BufferedImage toBufferedImage(byte[][] rawGray) {
        BufferedImage image = new BufferedImage(rowsCols, rowsCols, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < rowsCols; i ++) {
            for(int j = 0; j < rowsCols; j ++) {
                image.setRGB(i, j, toRGB((float)rawGray[i][j]));
            }
        }

        return image;
    }

    public static int toRGB(float value) {
        int part = Math.round(value * 255);
        return part * 0x10101;
    }
}
