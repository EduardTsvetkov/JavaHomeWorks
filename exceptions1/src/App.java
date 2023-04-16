import java.util.Arrays;

public class App {
    public static void main(String[] args){

        System.out.println("Начнёмс...");

        int[] array1 = new int[]{5, -4, 3, -2, 1, 6};
        int[] array2 = new int[]{1, -2, 3, -4, 5, 0};        

        // Разность массивов. Используем консольные сообщения
        System.out.println("Считаем разность.");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        int[] resArray = difArray(array1, array2);
        if (resArray.length == 0) {
            System.out.println("Массивы разниго размера или пустые !");
        } else {
            System.out.println(Arrays.toString(resArray));
        }
        System.out.println();

        // Деление массивов. Используем RuntimeException.
        System.out.println("Считаем частное.");
        resArray = divArray(array1, array2);
        System.out.println(Arrays.toString(resArray));
    }

    private static int[] difArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            int[] result = new int[] {};
            return result;
        } else {
            int[] result = new int[arr1.length]; 
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }    
            return result;        
        }       
    }

    private static int[] divArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разниго размера или пустые!");
        } else {
            int[] result = new int[arr1.length]; 
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] == 0) {
                    throw new RuntimeException(String.format("Элемент с индексом %d равен 0. Деление на 0!", i));
                }
                result[i] = arr1[i] / arr2[i];
            }    
            return result;        
        }
    }
}
