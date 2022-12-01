package hw2;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import java.util.Random;

public class sort {
/**
* Программа сортировки "пузырьком" c подробным (излишним) логгированием
* Level.INFO - только в файл
* Level.WARNING - в файл и в консоль
*/     
    public static void main(String[] args) throws IOException {
        System.out.println();

        Logger logger = Logger.getLogger(calclog.class.getName());    
        
        FileInputStream configFile =  new FileInputStream("sort.ini");
        LogManager.getLogManager().readConfiguration(configFile);
        configFile.close();

        FileHandler fh = new FileHandler("sort.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);
        logger.setLevel(Level.INFO);        
 
        logger.info("---------- Программа запущена ----------");

        boolean flag = true;
        int arrSize = 0;
        String inputString;

        Scanner scanner = new Scanner(System.in);
        logger.info("Запрашиваем сведения о размере массива. ");
        while (flag) {
            System.out.println("Введите размер массива (целое число больше 0):  ");
            inputString = scanner.nextLine().strip();
            logger.info(String.format("Пользователь ввел %s ", inputString));
            if (mylib.isInteger(inputString)) {
                arrSize = Integer.valueOf(inputString);
                if (arrSize <= 0) {
                    System.out.printf("%d - не больше 0. ", arrSize); 
                    logger.log(Level.WARNING, "Число меньше или равно 0. ");  
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. ", inputString);      
                logger.log(Level.WARNING, "Неправильный формат данных. ");      
            }
        }
        logger.info(String.format("Размере массива %d \n", arrSize));

        logger.info("Запрашиваем сведения о минимальном значении. ");
        int minElement = 0;
        flag = true;
        while (flag) {
            System.out.println("Введите величину минимального элемента массива (целое число):  ");
            inputString = scanner.nextLine().strip();
            logger.info(String.format("Пользователь ввел %s ", inputString));
            if (mylib.isInteger(inputString)) {
                minElement = Integer.valueOf(inputString);
                flag = false;
            } else {
                System.out.printf("%s - это не число. ", inputString);    
                logger.log(Level.WARNING, "Неправильный формат данных. ");          
            }
        }
        logger.info(String.format("Минимальный элемент массива %d \n", minElement));

        logger.info("Запрашиваем сведения о максимальном значении. ");
        int maxElement = 0;
        flag = true;
        while (flag) {
            System.out.printf("Введите величину максимального элемента массива (целое число, больше %d): \n", minElement);
            inputString = scanner.nextLine().strip();
            logger.info(String.format("Пользователь ввел %s ", inputString));
            if (mylib.isInteger(inputString)) {
                maxElement = Integer.valueOf(inputString);
                if (maxElement <= minElement) {
                    System.out.printf("%d - не больше %d. ", maxElement, minElement); 
                    logger.log(Level.WARNING, "Число меньше или равно минимальному значению. ");  
                } else {
                    flag = false;
                }
            } else {
                System.out.printf("%s - это не число. \n", inputString);     
                logger.log(Level.WARNING, "Неправильный формат данных. ");         
            }
        }
        logger.info(String.format("Максимальный элемент массива %d \n", maxElement));

        scanner.close();

        System.out.printf("Генерируем массива из %d элементов", arrSize);
        System.out.printf("от %d до %d\n", minElement, maxElement);
        logger.info(String.format("Заполняем массив случайными числами от %d до %d. ", minElement, maxElement));
        int[] array = new int[arrSize];
        Random rnd = new Random();
        for (int i = 0; i < arrSize; i++) {
            array[i] = rnd.nextInt((maxElement - minElement) + 1) + minElement;
        }
        System.out.println("Несортированный массив:");
        System.out.println(Arrays.toString(array));
        logger.info(String.format("Получили массив %s \n", Arrays.toString(array)));

        logger.info("Начинаем сортировку 'пузырьком'. ");
        int temp = 0;
        int count = 0;
        for (int i = arrSize - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                logger.info(String.format("Сравниваем array[%d]=%d и array[%d]=%d ", j, array[j], j + 1, array[j + 1]));
                if (array[j] > array[j + 1]) {
                    logger.info(String.format("%d > %d - меняем их местами ", array[j], array[j + 1]));
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                } else {
                    logger.info(String.format("%d < %d - оставляем без изменений ", array[j], array[j + 1]));
                }
                count++;
                logger.info(String.format("По итогам шага № %d получили массив %s \n", count, Arrays.toString(array)));
            }     
        }
        System.out.println("Cортированный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println();
         
        logger.info("---------- Программа завершена ----------");
    }
}