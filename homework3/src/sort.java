// 1. Реализовать алгоритм сортировки слиянием

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class sort {
/**
* Метод разбивает исходный массив на два массива (рекурсивно) и затем сливает обратно в упорядоченном виде
* @param array - исходный массив (int[]), он же и результат
*/  
    public static int[] sortArray(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }

        int[] arrayB = new int[array.length / 2];
        System.arraycopy(array, 0, arrayB, 0, array.length / 2);

        int[] arrayC = new int[array.length - arrayB.length];
        System.arraycopy(array, arrayB.length, arrayC, 0, array.length - arrayB.length);

        sortArray(arrayB);
        sortArray(arrayC);

        mergeArray(array, arrayB, arrayC);

        return array;
    }

/**
* Метод сливает два упорядоченных массива в один упорядоченный массив
* @param array - исходный массив (int[]), он же и результат
* @param array1 - первый упорядоченный массив (int[])
* @param array2 - второй упорядоченный массив (int[])
*/   
    private static void mergeArray(int[] array, int[] array1, int[] array2) {
        
        int position1 = 0;
        int position2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (position1 == array1.length) {
                array[i] = array2[position2];
                position2++;
            } else if (position2 == array2.length) {
                array[i] = array1[position1];
                position1++;
            } else if (array1[position1] < array2[position2]) {
                array[i] = array1[position1];
                position1++;
            } else {
                array[i] = array2[position2];
                position2++;
            }
        }
    }

/**
* Программа сортировки "слиянием" 
*/   
    public static void main(String[] args) throws IOException {
        System.out.println();

        boolean flag = true;
        int arrSize = 0;
        String inputString;

        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Введите размер массива (целое число больше 0):  ");
            inputString = scanner.nextLine().strip();
            if (mylib.isInteger(inputString)) {
                arrSize = Integer.valueOf(inputString);
                if (arrSize <= 0) {
                    System.out.printf("%d - не больше 0. ", arrSize); 
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. ", inputString);      
            }
        }

        int minElement = 0;
        flag = true;
        while (flag) {
            System.out.println("Введите величину минимального элемента массива (целое число):  ");
            inputString = scanner.nextLine().strip();
            if (mylib.isInteger(inputString)) {
                minElement = Integer.valueOf(inputString);
                flag = false;
            } else {
                System.out.printf("%s - это не число. ", inputString);    
            }
        }

        int maxElement = 0;
        flag = true;
        while (flag) {
            System.out.printf("Введите величину максимального элемента массива (целое число, больше %d): \n", minElement);
            inputString = scanner.nextLine().strip();
            if (mylib.isInteger(inputString)) {
                maxElement = Integer.valueOf(inputString);
                if (maxElement <= minElement) {
                    System.out.printf("%d - не больше %d. ", maxElement, minElement); 
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. \n", inputString);     
            }
        }

        scanner.close();

        System.out.printf("Генерируем массива из %d элементов", arrSize);
        System.out.printf("от %d до %d\n", minElement, maxElement);
        int[] array = new int[arrSize];
        Random rnd = new Random();
        for (int i = 0; i < arrSize; i++) {
            array[i] = rnd.nextInt((maxElement - minElement) + 1) + minElement;
        }
        System.out.println("Несортированный массив:");
        System.out.println(Arrays.toString(array));

        int [] sortedArray = new int[arrSize];
        sortedArray = sortArray(array);

        System.out.println("Cортированный массив:");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println();
         
    }
}