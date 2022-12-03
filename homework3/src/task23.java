// 2. Пусть дан произвольный список целых чисел, удалить из него четные числа.
// 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. 


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class task23 {
    
    public static void main(String[] args) {
        
        boolean flag = true;
        int listSize = 0;
        String inputString;

        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("Введите размер списка (целое число больше 0):  ");
            inputString = scanner.nextLine().strip();
            if (mylib.isInteger(inputString)) {
                listSize = Integer.valueOf(inputString);
                if (listSize <= 0) {
                    System.out.printf("%d - не больше 0. ", listSize); 
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
            System.out.println("Введите величину минимального элемента спсика (целое число):  ");
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
            System.out.printf("Введите величину максимального элемента списка (целое число, больше %d): \n", minElement);
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

        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(rnd.nextInt((maxElement - minElement) + 1) + minElement);
        }
    

        int maxInList = Collections.max(list);
        int minInList = Collections.min(list);
        float sumList = 0;
        for (int n : list) {
            sumList = sumList + n;
        }
        float average = sumList / list.size();

        System.out.println("В списке:");
        System.out.println(list);
        System.out.printf("максимальное значение: %d\n", maxInList);
        System.out.printf("минимальное значение: %d\n", minInList);
        System.out.printf("среднее значение: %f\n", average);


// Удаление четных
        int counter = 0;
        while (counter < listSize) {
            if ((list.get(counter) % 2 == 0) && !(list.get(counter) == 0)) {
                list.remove(counter);
                listSize--;
            } else {
                counter++;
            }
        }

        System.out.println("Чётные числа удалены:");
        System.out.println(list);

    }
    
}
