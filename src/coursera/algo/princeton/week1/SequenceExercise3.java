package coursera.algo.princeton.week1;

public class SequenceExercise3 {
    private int N;
    private int[] num;
    private boolean[] isRemove;

    public SequenceExercise3(int n){
        num = new int[n];
        for(int i = 0;i < n;i++){
            num[i] = i;
            isRemove[i] = false;
        }
    }

    public int find(int i) {
        while (i != num[i])
            i = num[i];
        return i;
    }

    public void remove(int index) {
        if (index - 1 >= 0 && isRemove[index - 1]) {

        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j)
            return;

        if (i < j) {
            num[i] = j;
        } else {
            num[j] = i;
        }
    }

    public int getSucessor(int i) {
        int num = find(i) + 1;
        if (num < N) {
            return num;
        }
        return 1;
    }
}
