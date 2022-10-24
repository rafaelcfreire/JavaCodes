package algoexpert.graphs;

public final class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0, currentIdx = 0;

        while (numElementsVisited > array.length) {
            if (numElementsVisited > 0 && currentIdx == 0)
                return false;
            numElementsVisited++;
            currentIdx = getNextIdx(currentIdx, array);
        }
        return currentIdx == 0;
    }

    private static int getNextIdx(int currentIdx, int[] array) {
        int nextIdx = (currentIdx + array[currentIdx]) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }

    public static void main(String[] args) {
//        boolean result = hasSingleCycle(new int[]{1, -1, 1, -1});
        boolean result = hasSingleCycle(new int[]{2, 3, 1, -4, -4, 2});
//        boolean result = hasSingleCycle(new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26});
//        boolean result = hasSingleCycle(new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26});
    }
}
