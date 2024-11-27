package com.lab_7_8_9;

abstract class Figure {
    double r, a, v, pi = 3.1428;

    public abstract void calcArea();
    public abstract void calcVolume();
    public abstract void dispArea();
    public abstract void dispVolume();
}

class Cone extends Figure {
    double s, h;

    public Cone(double r, double s, double h) {
        this.r = r;
        this.s = s;
        this.h = h;
    }

    public void calcArea() {
        a = (pi * r * s) + (pi * r * r);
    }

    public void calcVolume() {
        v = (pi * r * r * h) / 3;
    }

    public void dispArea() {
        System.out.printf("Cone Area: %.2f%n", a);
    }

    public void dispVolume() {
        System.out.printf("Cone Volume: %.2f%n", v);
    }
}

class Sphere extends Figure {
    public Sphere(double r) {
        this.r = r;
    }

    public void calcArea() {
        a = 4 * pi * r * r;
    }

    public void calcVolume() {
        v = (4 * pi * r * r * r) / 3;
    }

    public void dispArea() {
        System.out.printf("Sphere Area: %.2f%n", a);
    }

    public void dispVolume() {
        System.out.printf("Sphere Volume: %.2f%n", v);
    }
}

class Cylinder extends Figure {
    double h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public void calcArea() {
        a = (2 * pi * r * r) + (2 * pi * r * h);
    }

    public void calcVolume() {
        v = pi * r * r * h;
    }

    public void dispArea() {
        System.out.printf("Cylinder Area: %.2f%n", a);
    }

    public void dispVolume() {
        System.out.printf("Cylinder Volume: %.2f%n", v);
    }
}

public class FigPackageDemo {
    public static void main(String[] args) {
        Cone cone = new Cone(3, 4, 5);
        cone.calcArea();
        cone.calcVolume();
        cone.dispArea();
        cone.dispVolume();

        Sphere sphere = new Sphere(5);
        sphere.calcArea();
        sphere.calcVolume();
        sphere.dispArea();
        sphere.dispVolume();

        Cylinder cylinder = new Cylinder(3, 7);
        cylinder.calcArea();
        cylinder.calcVolume();
        cylinder.dispArea();
        cylinder.dispVolume();
    }
}
