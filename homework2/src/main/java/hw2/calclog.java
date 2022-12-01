package hw2;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class calclog {


/**
* Простейший калькулятор c подробным (излишним) логгированием
* Level.INFO - только в файл
* Level.WARNING - в файл и в консоль
*/ 
    public static void main(String[] args) throws IOException {
        System.out.println();
        Logger logger = Logger.getLogger(calclog.class.getName());    
        
        FileInputStream configFile =  new FileInputStream("calclog.ini");
        LogManager.getLogManager().readConfiguration(configFile);
        configFile.close();

        FileHandler fh = new FileHandler("calclog.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        logger.addHandler(fh);
        fh.setFormatter(sFormat);
        logger.setLevel(Level.INFO);
        
        logger.info("---------- Программа запущена ----------");

        String userString;
        boolean flag = true;
        Scanner iScanner = new Scanner(System.in);
        do {
            logger.info("Запрашиваем данные у пользователя. ");
            System.out.println("Введите пример (операнды и оператор через пробел) ");
            System.out.println("например 2 + 7 или 4 * 3");
            System.out.print("-> ");
            userString = iScanner.nextLine().trim(); 
            logger.info("Проверяем введенные данные. " + userString);
            if (userString.matches("-?\\d+(\\.\\d+)? [+\\-*/] -?\\d+(\\.\\d+)?")) {
                logger.info("Формат совпадает. ");
                flag = false;
            } else {
                logger.log(Level.WARNING, "Неправильный формат данных. ");
                System.out.println("Неправильный формат данных.");
            }
        } while (flag);
        iScanner.close();
        
        logger.info("Формат совпадает. ");
        List<String> userData = new  ArrayList<String>(Arrays.asList(userString.split(" ")));
        logger.info("Получили пользовательские данные. " + userData);
        double a = Double.parseDouble(userData.get(0));
        double b = Double.parseDouble(userData.get(2));
        String sign = userData.get(1);
        double total;
        logger.info("Считаем пример. ");
        switch (sign) {
            case "+":
                total = a + b;
                logger.info(String.format("%f + %f = %f", a, b, total));
                break;
            case "-":
                total = a - b;
                logger.info(String.format("%f - %f = %f", a, b, total));
                break;
            case "*":
                total = a * b;
                logger.info(String.format("%f * %f = %f", a, b, total));
                break;                
            case "/":
                total = a / b;
                if (b == 0) {
                    logger.log(Level.WARNING, "Деление на ноль! Итог - бесконечность!");
                    System.out.println("Вообще-то на ноль делить нельзя, но... Не в java! ;-)");
                } 
                logger.info(String.format("%f / %f = %f", a, b, total));
                break;  
            default:
                logger.log(Level.WARNING, "Какой-то странный пример... ");
                total = 0;
                break;                  

        }
        logger.info("Выводим результат. ");
        System.out.printf("%f %s %f = %f\n", a, sign, b, total);
        logger.info("---------- Программа завершена ----------");
        System.out.println();
    }
}
