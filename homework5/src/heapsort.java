import java.util.Arrays;

public class heapsort
{   
    public static void sort(int arr[])
    {
        int len = arr.length;
 
        for (int i = len / 2 - 1; i >= 0; i--) {
          heapify(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
 
    /**
    * Метод ищет в "треугольнике" (родительский узел и дочерние левый и правый узлы)
    * максимальное значение и ставит его в родителя.
    * @param arr - сортируемый массив (int[])
    * @param n - длинна текущего массива (int)  
    * @param i - индекс максималного элемента треугольника с предыдущей итерации (int)        
    * @return - индекс первой свободной ячейки или -1 если все заняты (int)
    */    
    public static void heapify(int arr[], int n, int i)
    {
        int indMax = i; 
        int indL = 2*i + 1; 
        int indR = 2*i + 2;  
 
        if (indL < n && arr[indL] > arr[indMax]){
            indMax = indL;
        }
        if (indR < n && arr[indR] > arr[indMax]) {
            indMax = indR;
        }
        
        if (indMax != i)  // ставим в вершину треугольника максимальный элемент
        {
            int temp = arr[i];
            arr[i] = arr[indMax];
            arr[indMax] = temp;
 
            heapify(arr, n, indMax);
        }
    }

 
    public static void main(String args[])
    {
        int arr[] = {11, 12, 3, 9, 12, 5, 4, 6, 10, 1, 7, 20, 1, 1, 8, 8};
        System.out.println("Не сортированный массив:");
        System.out.println(Arrays.toString(arr));

        sort(arr);
 
        System.out.println("Сортированный массив:");
        System.out.println(Arrays.toString(arr));
    }
}