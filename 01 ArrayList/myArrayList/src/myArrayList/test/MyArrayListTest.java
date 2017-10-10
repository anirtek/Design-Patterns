package myArrayList.test;

import jdk.nashorn.internal.runtime.JSType;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {

    public void testMe(MyArrayList myArrayList, Results results) {
        containsAllIntegers(myArrayList, results);
        containsFloats(myArrayList, results);
        containsStrings(myArrayList, results);
        testInputDataRange(myArrayList, results);
        testInsertSorted(myArrayList, results);
        testIndexOf(myArrayList, results);
        testSize(myArrayList, results);
        testSum(myArrayList, results);
        performsInternalSorting(myArrayList, results);
        testRemoveValue(myArrayList, results);
        removesDuplicates(myArrayList, results);
        testToStrings(myArrayList, results);
    }

    public void containsAllIntegers(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        int[] arrayList = myArrayList.getArrayList();
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == Math.ceil(arrayList[i])) {
                continue;
            } else {
                status = "Failed";
                break;
            }
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
    }

    public void containsFloats(MyArrayList myArrayList, Results results) {
        String status = "Failed";
        int[] arrayList = myArrayList.getArrayList();
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != Math.ceil(arrayList[i])) {
                status = "Passed";
            }
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        //append the result into the output file
    }

    public void containsStrings(MyArrayList myArrayList, Results results) {
        String status = "Failed";
        int[] arrayList = myArrayList.getArrayList();
        for (int i = 0; i < arrayList.length; i++) {
            if (JSType.isString(arrayList[i])) {
                status = "Passed";
            }
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        //append the result into the output file
    }
    
    public void testToStrings(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        myArrayList.toString(myArrayList);
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        
    }

    public void testInputDataRange(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        int[] arrayList = myArrayList.getArrayList();
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] >= 0 && arrayList[i] <= 10000) {

            } else {
                status = "Failed";
            }
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);        //append the result into the output file
    }

    public void testInsertSorted(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        int sum = myArrayList.sum();
        myArrayList.insertSorted(myArrayList, 1024);
        int newSum = myArrayList.sum();
        if (sum != newSum) {
            status = "Passed";
        } else {
            status = "Failed";
        }

        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        //append the result into the output file
    }

    public void performsInternalSorting(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        int[] arrayList = myArrayList.getArrayList();
        int last = arrayList[0];
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i] != 0) {
                if (last > arrayList[i]) {
                    status = "Failed";
                }
            }
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        //appedn the result into the output file
    }

    public void testIndexOf(MyArrayList myArrayList, Results results) {
        String status = "Failed";
        myArrayList.insertSorted(myArrayList, 1225);
        int i = myArrayList.indexOf(1225);
        myArrayList.removeValue(myArrayList, 1225);
        int j = myArrayList.indexOf(1225);
        if(i != -1 && j == -1) {
            status = "Passed";
        }
        
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
    }

    public void testSum(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        int sum = myArrayList.sum();
        if (sum != 0) {
            status = "Passed";
        } else {
            status = "Failed";
        }

        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
        //append the result into the output file
    }

    public void testSize(MyArrayList myArrayList, Results results) {
        String status = "Passed";
        
        int[] arrayList = myArrayList.getArrayList();
        int length = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if(arrayList[i] != 0) {
                length += 1;
            }
        }
        if(length != myArrayList.size()) {
            status = "Failed";
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
    }

    public void testRemoveValue(MyArrayList myArrayList, Results results) {
        String status= "Failed";
        int [] arrayList = myArrayList.getArrayList();
        int selection = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if(arrayList[i] != 0) {
                selection = arrayList[i];
                break;
            }
        }
        myArrayList.removeValue(myArrayList, selection);
        if(myArrayList.indexOf(selection) == -1) {
            status = "Passed";
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);
    }

    public void removesDuplicates(MyArrayList myArrayList, Results results) {
        String status = "Failed";
        myArrayList.insertSorted(myArrayList, 45);
        myArrayList.insertSorted(myArrayList, 45);
        myArrayList.removeValue(myArrayList, 45);
        if(myArrayList.indexOf(45) == -1) {
            status = "Passed";
        }
        status = "Test \"" + Thread.currentThread().getStackTrace()[1].getMethodName() + "\" : " + status;
        results.testResults.add(status);       
    }

}

