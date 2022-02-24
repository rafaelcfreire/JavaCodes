public class Main {
    public static void main(String[] args) {
        int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        findMinimum(arr);
    }


    public static int findMinimum(int[] arr){
        quickSort(arr, 0, arr.length - 1);

        int minimumDifference = Math.abs(arr[0] - arr[1]);
        for(int i = 1; i < arr.length -1; i++){
            if(Math.abs(arr[i] - arr[i + 1]) < minimumDifference)
                minimumDifference = Math.abs(arr[i] - arr[i + 1]);
        };
        return minimumDifference;
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}
