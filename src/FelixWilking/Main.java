package FelixWilking;

public class Main {

    public static void main(String[] args) {
        int size = 1000;
        getAverage(size, 0);
        getAverage(size, 1);
        getAverage(size, 2);

    }

    public static void getAverage(int size, int sortID){
        int[] arr = randIntArr(size, size);
        double average = 0;
        for(int i = 0; i < 10; i++){
            long time = System.nanoTime();
            if(sortID == 0) {
                insertionSort(arr);
            }
            else if(sortID == 1){
                selectionSort(arr);
            }
            else if(sortID == 2){
                bubbleSort(arr);
            }
            time = System.nanoTime() - time;
            average += time;
            average = average / 5;
        }
        System.out.println(average);
    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static int[] bubbleSort(int[] arr){
        int[] output = arr;
        boolean sorted = false;
        for (int num:output){
            num = (int) (Math.random() * output.length);
        }
        while (!sorted){
            sorted = true;
            for (int i = 0; i < output.length - 1; i++){
                if (output[i] > output[i + 1]){
                    swap(output, i, i + 1);
                    sorted = false;
                }
            }
        }
        return output;
    }

    public static int[] selectionSort(int[] arr){
        while (!isSorted(arr)) {
            for (int i = 0; i < arr.length; i++) {
                swap(arr, i, minimum(arr, i));
            }
        }
        return arr;
    }

    public static boolean isSorted(int[] arr){
        for (int i = 2; i < arr.length; i += 2){
            if (arr[i] < arr[i - 2]) return false;
        }
        return true;
    }

    public static int minimum(int[] arr, int index){
        for(int i = index; i < arr.length; i++){
            if(arr[i] < arr[index]) index = i;
        }
        return index;
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
