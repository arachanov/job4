package ru.job4j.array;

public class SortArray {
    public int[] sort(int[] array1, int[] array2) {
        int dlina = array1.length + array2.length;
        int[] array3 = new int[dlina];
        for (int i = 0; i < dlina; i++) {
            if (i < array1.length) {
                array3[i] = array1[i];
            } else {
                array3[i] = array2[i - array2.length];
            }
        }
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3.length - i; j++) {
                if (j + 1 != array3.length) {
                    if (array3[j] > array3[j + 1]) {
                        int tmp = array3[j];
                        array3[j] = array3[j + 1];
                        array3[j + 1] = tmp;
                    }
                }
            }
        }
        return array3;
    }
}