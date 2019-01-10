package FelixWilking;

public class Main {

    public static void main(String[] args) {
        int[] arr = randIntArr(10, 10);
        insertionSort(arr);
        for(int num : arr){
            System.out.println(num);
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j , j - 1);
                }
            }
        }
    }

    public static int[] randIntArr(int len, int range){
        int[] output = new int[len];
        for (int i = 0; i < len; i++){
            output[i] = (int) (Math.random() * (range + 1));
        }
        return output;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
