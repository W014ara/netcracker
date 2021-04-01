package ru.skillbench.tasks.basics.math;

import java.util.Arrays;
import java.util.Comparator;

public class ComplexNumberImpl implements ComplexNumber{
    private double real;
    private double imaginary;

    public ComplexNumberImpl(){
        real = 0;
        imaginary = 0;
    }

    public ComplexNumberImpl( double re, double im){
        this.real = re;
        this.imaginary = im;
    }


    @Override
    public double getRe() {
        return this.real;
    }

    @Override
    public double getIm() {
        return this.imaginary;
    }

    @Override
    public boolean isReal() {
        return this.imaginary == 0;
    }

    @Override
    public void set(double re, double im) {
        this.real = re;
        this.imaginary = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        int imagpartend = value.indexOf("i");
        if( imagpartend == -1){
            real = Double.parseDouble(value);
            imaginary = 0;
            return;
        }
        if( imagpartend != value.length()-1){
            throw new NumberFormatException();
        }
        int j;
        j=1;
        while (imagpartend-j >= 0 && (Character.isDigit( value.charAt(imagpartend-j)) ||
                value.charAt(imagpartend-j) == '.')) {
            j++;
        }
        int imagpartbegin = imagpartend-j+1;
        if(imagpartbegin == 0){
            real = 0;
            if( imagpartbegin == imagpartend){
                imaginary = Double.parseDouble( value.substring(0,imagpartend) + "1");
            }else{
                imaginary = Double.parseDouble( value.substring(0,imagpartend) );
            }
        }else{
            if( imagpartbegin == imagpartend){
                imaginary = Double.parseDouble(value.substring(imagpartbegin-1,imagpartend) + "1" );
            }
            else{
                imaginary = Double.parseDouble(value.substring(imagpartbegin-1,imagpartend));
            }

            if(imagpartbegin-1 != 0){
                real = Double.parseDouble(value.substring(0,imagpartbegin-1));
            }else{
                real = 0;
            }
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(real, imaginary);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public int compareTo(ComplexNumber other) {
        if(Math.hypot(real, imaginary) - Math.hypot(other.getRe(), other.getIm()) > 0)
            return 1;
        else if(Math.hypot(real, imaginary) - Math.hypot(other.getRe(), other.getIm()) < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, new Comparator<ComplexNumber>(){
            @Override
            public int compare(ComplexNumber arg0, ComplexNumber arg1) {
                return arg0.compareTo(arg1);
            }
        });
    }

    @Override
    public boolean equals(Object other){
        if ( other == null ){
            return false;
        }else if (!(other instanceof ComplexNumber)){
            return false;
        }else {
            ComplexNumber othercomplexnumber = (ComplexNumber) other;
            return (Double.compare(real, othercomplexnumber.getRe()) == 0) && (Double.compare(imaginary,
                    othercomplexnumber.getIm()) == 0);
        }
    }

    @Override
    public ComplexNumber negate() {
        imaginary *= (-1);
        real *= (-1);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        real += arg2.getRe();
        imaginary += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double oldreal = real;
        real = real * arg2.getRe() - imaginary * arg2.getIm();
        imaginary = oldreal * arg2.getIm() + imaginary * arg2.getRe();
        return this;
    }

    @Override
    public String toString()
    {
        if (Double.compare(imaginary, 0) == 0){
            return Double.toString(real);
        }
        if (Double.compare(real, 0) == 0){
            return Double.toString(imaginary) + "i";
        }
        if (imaginary > 0){
            return Double.toString(real) + "+" + Double.toString(imaginary) + "i";
        }
        return Double.toString(real) + Double.toString(imaginary) + "i";
    }
}
