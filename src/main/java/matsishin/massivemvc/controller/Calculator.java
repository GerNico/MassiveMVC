package matsishin.massivemvc.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class Calculator {
    static class Point {
        long a;
        long b;
        String nameA;
        String nameB;

        public Point(long a, long b, String nameA, String nameB) {
            this.a = a;
            this.b = b;
            this.nameA = nameA;
            this.nameB = nameB;
        }

        public Point(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public long getA() {
            return a;
        }

        public long getB() {
            return b;
        }
    }



    public static int[] summOfMass(int[] m1, int[] m2) {
        int[] newMas = new int[m1.length];
        for (int i = 0; i < newMas.length; i++) {
            newMas[i] = m1[i] + m2[i];
        }
        return newMas;
    }

    public static int[] concatMass(int[] m1, int[] m2) {
        int[] newMas = new int[m1.length + m2.length];
        for (int i = 0; i < m1.length; i++) {
            if (i < m1.length) newMas[i] = m1[i];
            else {
                newMas[i - m1.length] = m1[i - m1.length];
            }
        }
        return newMas;
    }

    public static void replaseMaxMin(int[] mas) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[minIndex]) minIndex = i;
            if (mas[i] > mas[maxIndex]) maxIndex = i;
        }
        mas[minIndex] = mas[minIndex] ^ mas[maxIndex];
        mas[maxIndex] = mas[maxIndex] ^ mas[minIndex];
        mas[minIndex] = mas[minIndex] ^ mas[maxIndex];
    }

    public static int[] killMaxMin(int[] mas) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[minIndex]) minIndex = i;
            if (mas[i] > mas[maxIndex]) maxIndex = i;
        }
        if (mas.length > 2) {
            int[] newMas = new int[mas.length - 2];

            for (int i = 0; i <mas.length ; i++) {
                if (i<minIndex&&i<maxIndex)newMas[i]=mas[i];
                else {
                    if (i<minIndex && i>maxIndex)newMas[i]=mas[i-1];
                    if (i>minIndex && i<maxIndex)newMas[i]=mas[i-1];
                    if (i>minIndex && i>maxIndex)newMas[i]=mas[i-2];
                }
            }
            return newMas;
        } else
            return null;
    }

    public static Object[][] split (int[] mas){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]<0)list1.add(mas[i]);
            else list2.add(mas[i]);
            Object[][] result={list1.toArray(),list2.toArray()};
            return result;
        }
        return new Object[0][];
    }


}

