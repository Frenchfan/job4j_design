package ru.job4j.generics;

public class Coords<T extends TwoD> {
    T[] coords;

    Coords(T[] o) {
        coords = o;
    }

    /**
     * Works with TwoD, ThreeD, FourD - as any of the class has at least X and Y coordinates
     * @param c contains wild card
     */
    static void showXY(Coords<?> c) {
        System.out.println("Координаты X и Y: ");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
            System.out.println();
        }
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X, Y, Z coordinates: ");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + c.coords[i].y + c.coords[i].z);
            System.out.println();
        }
    }
}

class BoundedWildCard {
    static void showXY(Coords<?> c) {
        System.out.println("Координаты X и Y: ");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
            System.out.println();
        }
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X, Y, Z coordinates: ");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
            System.out.println();
        }
    }

    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X, Y, Z, T coordinates: ");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoD[] td = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23)
        };

        Coords<TwoD> tdlocks = new Coords<>(td);

        System.out.println("Содержимое объекта tdlocks.");
        showXY(tdlocks);


        FourD[] fd = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        Coords<FourD> fdlocs = new Coords<>(fd);
        System.out.println("Содержимое объекта fdlocs. ");

        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);
    }
}
