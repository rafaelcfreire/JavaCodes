public final class BinarySearch {

    public static void main(String[] args) {
//        File f = new File("files/binarySearch");
//        BufferedReader b = new BufferedReader(new FileReader(f));
//        String temp1 = b.readLine();
//        Integer[] array = Arrays.stream(temp1.split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
//        Arrays.sort(array);
//        System.out.println(
//            binarySearch(array, 2)
//        );
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] < key) {
                low = middle + 1;
            } else if (array[middle] > key) {
                high = middle - 1;
            } else
                return middle;
        }
        return -1;
//        binarySearch(array, key, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int key, int low, int high) {
        if (high < low)
            return -1;

        int middle = low + (high - low) / 2;

        if (key < array[middle])
            return binarySearch(array, key, low, middle - 1);
        else if (key > array[middle])
            return binarySearch(array, key, middle + 1, high);
        else
            return middle;
    }

}
