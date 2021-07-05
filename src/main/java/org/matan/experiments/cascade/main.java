package org.matan.experiments.cascade;

import java.util.*;

public class main {

    public static void shuffle(int[] arr) {
        Random r = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int[] getArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        Random random = new Random();
        int idx = random.nextInt(size - 1);
        int val = random.nextInt(size - 1);
        while (idx == val) {
            val = random.nextInt(size - 1);
        }
        arr[idx] = val;

        return arr;
    }

    public static int switchFlowIteration(int[] arr, int index) {
        int res = -1;

        int hand = arr[index];
        arr[index] = -1;
        int temp;

        while (hand != -1) {
            if (arr[hand] == hand) {
                arr[index] = hand;
                res = hand;
                break;
            } else if (arr[hand] == -1) {
                arr[hand] = hand;
                hand = -1;
            } else {
                temp = arr[hand];
                arr[hand] = hand;
                hand = temp;
            }
        }

        return res;
    }

    public static int getDuplicate(int[] arr) {
        int index = 0;
        int res;
        do {
            res = switchFlowIteration(arr, index);
            if (res == -1) {
                index++;
            }
        } while (res == -1);
//        System.out.println(String.format("From flow on index %d", index));
        return res;
    }

    public static int getMissing(int[] arr, int dup) {
        int allXor = 0;
        int arrXor = 0;

        for (int i = 1; i < arr.length; i++) {
            allXor = allXor ^ i;
        }

        for (int i = 0; i < arr.length; i++) {
            arrXor = arrXor ^ arr[i];
        }

        return allXor ^ arrXor ^ dup;
    }

    public static void main(String[] args) {
        int[] array = getArray(25);
        int[] idxArr = getArray(25);
        shuffle(array);

        System.out.println(Arrays.toString(idxArr));
        System.out.println(Arrays.toString(array));
        int dup = getDuplicate(array);
        System.out.printf("Duplicate is: %d", dup);
        System.out.println(Arrays.toString(array));
        System.out.printf("Missing is: %d", getMissing(array, dup));
    }
}