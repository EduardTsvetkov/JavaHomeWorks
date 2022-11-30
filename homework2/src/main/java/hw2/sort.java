package hw2;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        System.out.println();

// вставить логгер не забыть
        boolean flag = true;
        int arrSize = 0;
        String inputString;

        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Введите размер массива (целое число больше 0):  ");
            inputString = scanner.nextLine();
            if (mylib.isInteger(inputString)) {
                arrSize = Integer.valueOf(inputString);
                if (arrSize <= 0) {
                    System.out.printf("%d - не больше 0. \n", arrSize); 
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. \n", inputString);            
            }
        }

        int minElement = 0;
        flag = true;
        while (flag) {
            System.out.println("Введите величину минимального элемента массива (целое число):  ");
            inputString = scanner.nextLine();
            if (mylib.isInteger(inputString)) {
                minElement = Integer.valueOf(inputString);
                flag = false;
            } else {
                System.out.printf("%s - это не число. \n", inputString);            
            }
        }

        int maxElement = 0;
        flag = true;
        while (flag) {
            System.out.printf("Введите величину максимального элемента массива (целое число, больше %d): \n", minElement);
            inputString = scanner.nextLine();
            if (mylib.isInteger(inputString)) {
                maxElement = Integer.valueOf(inputString);
                if (maxElement <= minElement) {
                    System.out.printf("%d - не больше %d. \n", maxElement, minElement); 
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. \n", inputString);            
            }
        }
        
        scanner.close();

        System.out.printf("Генерируем массива из %d элементов\n", arrSize);
        System.out.printf("от %d до %d\n", minElement, maxElement);

        int[] array = new int[arrSize];
        Random rnd = new Random();
        for (int i = 0; i < arrSize; i++) {
            array[i] = rnd.nextInt((maxElement - minElement) + 1) + minElement;
        }
        System.out.println("Несортированный массив:");
        System.out.println(Arrays.toString(array));

        int temp = 0;
        for (int i = arrSize - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }     
        }
        System.out.println("Cортированный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println();
    }
}
