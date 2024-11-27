package com.lab_7_8_9;

interface Function {
    int evaluate(int value);
}

class Half implements Function {
    public int evaluate(int value) {
        return value / 2;
    }
}

public class FunctionEvaluator {
    public static int[] applyFunctionToArray(int[] array, Function function) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = function.evaluate(array[i]);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] values = {10, 20, 30, 40, 50};
        
        System.out.print("Original array      : ");
        for ( int i=0 ; i<5 ; i++ )
        {
        	System.out.print(values[i]+" ");
        }
        System.out.println(" ");
        
        Half halfFunction = new Half();
        int[] result = applyFunctionToArray(values, halfFunction);

        System.out.print("Half of array values: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
