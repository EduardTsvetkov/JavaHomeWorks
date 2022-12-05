// 4*. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> 
// так, что на 0й позиции каждого внутреннего списка содержится название жанра, 
// а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class catalog {
    public static void main(String[] args) {
        List<ArrayList<String>> allBooks = new ArrayList<>(); 
        
        Scanner scanner = new Scanner(System.in, "Cp866");
        String inpuString = "";
        while (true) {
            ArrayList<String> genre = new ArrayList<>();
            System.out.println("Введите жанр книг (либо Enter для выхода): ");
            inpuString = scanner.nextLine();
            System.out.println(inpuString);
            if (inpuString == "") {
                // if (genre.size() > 0) {
                //     allBooks.add(genre);
                // }
                break;
            }    
            genre.add(inpuString);
            System.out.printf("Введите информацию о книгах жанра %s: \n", inpuString);
            while (true) {
                System.out.println("Введите информацию об очередной книге этого жанра (либо Enter для выхода): ");
                inpuString = scanner.nextLine();
                if (inpuString == "") {
                    break;
                }
                genre.add(inpuString);
            } 
            allBooks.add(genre);    
            

        } 

        scanner.close();
        System.out.println("Каталог книг по жанрам: ");
        for(ArrayList<String> obj: allBooks){

            System.out.println(obj); 

        }
    }
}

