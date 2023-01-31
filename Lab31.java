//CP1340 Lab 3 - Classes and Objects II
//Student: Cade Molloy - 20175269
//Due Date: November 1st, 2022
//Prof: Branko Cirovic

import java.util.*;

class IntegerSet {
    int[] arr;

    IntegerSet() {
        arr = new int[100];
    }

    public void insert(int x) {
        this.arr[x] = 1;
    }

    public void delete (int x) {
        this.arr[x] = 0;
    }

    public String toString() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == 1) {
                stringArrayList.add(String.valueOf(i));

            }
        }
        return Arrays.toString(stringArrayList.toArray());
    }

    public IntegerSet union(IntegerSet B) {
        IntegerSet C = new IntegerSet();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == 1) {
                hs.add(i);
            }
        }
        for (int i = 0; i < B.arr.length; i++) {
            if(B.arr[i] == 1) {
                hs.add(i);
            }
        }
        Object[] union = {};
        union = hs.toArray();

        int post = 0;
        for (Object i : union) {
            C.insert((int)i);
        }
        return C;
    }

    public IntegerSet intersection(IntegerSet B) {
        IntegerSet C = new IntegerSet();
        for (int i = 0; i < 100; i++) {
            if(this.arr[i] == 1 && B.arr[i] == 1) {
                C.insert(i);
            }
        }
        return C;
    }

    public IntegerSet difference(IntegerSet B) {
        IntegerSet C = new IntegerSet();
        for(int i = 0; i < 100; i++) {
            if(this.arr[i] == 1 && B.arr[i] == 0) {
                C.insert(i);
            }
        }
        return C;
    }

    public boolean equals(IntegerSet B) {
        return Arrays.equals(this.arr, B.arr);
    }
}

class Lab31 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        IntegerSet A = new IntegerSet();
        IntegerSet B = new IntegerSet();
        A.insert(10);
        A.insert(11);
        A.insert(12);
        B.insert(12);
        B.insert(13);
        B.insert(14);

        IntegerSet C = A.union(B);
        System.out.println("The Union of A and B is " + C.toString());

        IntegerSet D = A.intersection(B);
        System.out.println("The Intersection of A and B is " + D.toString());

        IntegerSet E = A.difference(B);
        System.out.println("The Difference of A and B is " + E.toString());

        System.out.println("Are A and B Equal? " + A.equals(B));
    }
}