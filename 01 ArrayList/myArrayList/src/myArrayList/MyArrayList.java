package myArrayList;

import java.util.Arrays;

public class MyArrayList {

    private int[] arrayList = new int[10];

    /* Default Constructor */
    public MyArrayList() {
        
    }

    public void insertSorted(MyArrayList myArrayList, int newValueIn) {
        int index = 0;
        while (myArrayList.arrayList[index] != 0) {
            index++;
            if (index == myArrayList.arrayList.length - 1) {
                index = myArrayList.createNewList(myArrayList, newValueIn);
            }
        }
        myArrayList.arrayList[index] = newValueIn;
        Arrays.sort(myArrayList.arrayList);
    }

    private int createNewList(MyArrayList myArrayList, int newValueIn) {
        int newSize = myArrayList.arrayList.length + myArrayList.arrayList.length / 2;
        int[] newArrayList = new int[newSize];
        int index = 0;
        for (; index < myArrayList.arrayList.length; index++) {
            newArrayList[index] = myArrayList.arrayList[index];
        }
        myArrayList.arrayList = newArrayList;
        return index;
    }

    public void printData(MyArrayList myArrayList) {
        
    }

    public void removeValue(MyArrayList myArrayList, int value) {
        for (int i = 0; i < myArrayList.arrayList.length; i++) {
            if(myArrayList.arrayList[i] == value) {
                myArrayList.arrayList[i] = 0;
            } 
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if(arrayList[i] != 0)
                count += 1;
        }
        return count;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < arrayList.length; i++) {
            sum += arrayList[i];
        }
        return sum;
    }

    public void toString(MyArrayList myArrayList) {
        System.out.println("Data in MyArrayList data structure");
        for (int i = 0; i < myArrayList.arrayList.length; i++) {
            if (myArrayList.arrayList[i] != 0) {
                System.out.println(myArrayList.arrayList[i]);
            }
        }
    }
    
    public int[] getArrayList() {
        return arrayList;
    }
}

