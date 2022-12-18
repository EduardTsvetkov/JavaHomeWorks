import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


public class notebook {
    // public static HashMap<String, HashMap<String, String>> catalog = new HashMap<>();
    // HashMap<String, String> specifications = new HashMap<>();


/**
 * Метод читает данные о ноутбуках из файла в каталог
 * @param f путь к фпйлу с данными (String)
 * @return - каталог ноутбуков из файла (HashMap<String, HashMap<String, String>>)
 * @throws Exception
 */
    public static HashMap<String, HashMap<String, String>> GetData(String f) throws Exception {
        HashMap<String, HashMap<String, String>> result = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String str;
        String[] tempArray = new String[7];
        while ((str = br.readLine()) != null) {
            HashMap<String, String> specifications = new HashMap<>();
            tempArray = str.split(", ");
            specifications.put("брэнд", tempArray[1]);
            specifications.put("ОЗУ", tempArray[2]);
            specifications.put("диск", tempArray[3]);
            specifications.put("ОС", tempArray[4]);
            specifications.put("цвет", tempArray[5]);
            specifications.put("цена", tempArray[6]);
            result.put(tempArray[0], specifications);
        }
        br.close();     
  
        System.out.printf("Загрузка данных из файла %s завершена!\n", f);
        return result; 
    }


/**
 * Метод выводит в консоль указанный каталог
 * @param arg - каталог для отображения в консоли (HashMap<String, HashMap<String, String>>)
 */    
    public static void ShowCatalog(HashMap<String, HashMap<String, String>> arg) {

        for (HashMap.Entry<String, HashMap<String, String>> extMap : arg.entrySet()) {
 
            HashMap<String, String> specifications = new HashMap<>();
            // Printing all elements of a Map
            System.out.println();
            System.out.println(extMap.getKey());
            specifications = extMap.getValue();
            for (HashMap.Entry<String, String> intSet : specifications.entrySet()) {
                System.out.printf(" %s-%s ", intSet.getKey(), intSet.getValue());
            }    
            System.out.println();
        }
    }
    


/**
 * Метод определяет фильтры для каталога
 * @param arg - сканер программ (Scaner)
 * @return - перечень фильтров (HashMap<String, String>)
 */    
    public static HashMap<String, String> SetFilter(Scanner scan) {
        HashMap<String, String> result = new HashMap<>();
        String choise;
        String item = "";
        String value = "";
        boolean flag = true;
        while (MyLib.getAnswer(scan, "Добавляем фильтр? ")) {
            flag = true;
            System.out.println("Существующие фильтры:");
            System.out.println("   1. По брэнду.");
            System.out.println("   2. По ОЗУ.");
            System.out.println("   3. По размеру диска.");
            System.out.println("   4. По ОС.");
            System.out.println("   5. По цвету.");
            System.out.println("   6. По цене.");
            System.out.println("Выберите номер фильтра: ");
            choise = scan.nextLine();
            switch (choise) {
                case "1":
                    item = "брэнд";
                    break;
                case "2":
                    item = "ОЗУ";
                    break;
                case "3":
                    item = "диск";
                    break;
                case "4":
                    item = "ОС";
                    break;
                case "5":
                    item = "цвет";
                    break;
                case "6":
                    item = "цена";
                    break;
                                                                        
                default:
                    flag = false;
                    break;
            }
            if (flag) {
                System.out.printf("Введите значение для фильтра %s: ", item);
                value = scan.nextLine();
                System.out.println();
                result.put(item, value);
            }
        }
        ShowFilter(result);

        // result.put("ОЗУ", "16");
        // result.put("диск", "512");
        // result.put("ОС", "Linux");


        return result;
    }

    public static void ShowFilter(HashMap<String, String> args) {
        if (args.size() == 0) {
            System.out.println("Фильтр не установлен ");
        } else {
            System.out.println("Фильтр: ");
            for (HashMap.Entry<String, String> filter : args.entrySet()) {
                System.out.printf(" %s-%s ", filter.getKey(), filter.getValue() );
                
            }    
            System.out.println();        
        }
        System.out.println("-----------------------------");
    }





/**
 * 
 * @param inputCatalog - Каталог для фильтрации (HashMap<String, HashMap<String, String>>)
 * @param filtrMap - перечень фильтров (HashMap<String, String>)
 * @return - отфильтрованный каталог (HashMap<String, HashMap<String, String>>)
 */
    public static HashMap<String, HashMap<String, String>> ApplyFilter(HashMap<String, HashMap<String, String>> inputCatalog, HashMap<String, String> filterMap) {
        HashMap<String, HashMap<String, String>> result = new HashMap<>();
        HashMap<String, HashMap<String, String>> temp = new HashMap<>(inputCatalog);
        String name;

        for (HashMap.Entry<String, String> filter : filterMap.entrySet()) {  // читаем построчно фильтр
            result = new HashMap<>();  

            for (HashMap.Entry<String, HashMap<String, String>> extMap : temp.entrySet()) {  // читаем построчно каталог
        
                HashMap<String, String> specifications = new HashMap<>(); 
            
                name = extMap.getKey();              // ключ - наименование товара
                specifications = extMap.getValue();  // значение - словарь характеристик
                for (HashMap.Entry<String, String> intSet : specifications.entrySet()) {  // читаем характеристики
                    if ( intSet.getKey().equals(filter.getKey())) {
                        if (intSet.getValue().equals(filter.getValue()) ){  // фильтр Ok
                            result.put(name, specifications);  // добавляем в результат
                        }
                        if (MyLib.isInteger(filter.getValue()) && MyLib.isInteger(intSet.getValue()) &&
                        Integer.parseInt(intSet.getValue()) > Integer.parseInt(filter.getValue())) {
                            result.put(name, specifications);  // добавляем в результат
                        }
                    }           
                }    
            }
            temp = result;  // и опять фильтруем (если есть по чём)
        }
        return result;
    }

}