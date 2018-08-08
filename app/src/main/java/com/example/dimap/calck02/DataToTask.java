package com.example.dimap.calck02;


public class DataToTask {

    private int a, b, c, result;

    public int getResult() {
        return (result = this.a + (this.b * this.c));
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String setText() {
        return this.a + " + " + this.b + " * " + this.c + " = ? ";
    }

}
