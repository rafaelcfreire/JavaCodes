package princeton.week1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class NetworkConnectivity {
    private int[] id;
    private int[] sz;
    private int count;
    private FileInputStream fileInputStream;

    public NetworkConnectivity(int n, FileInputStream ins) {
        this.fileInputStream = ins;
        this.id = new int[n];
        this.sz = new int[n];

        this.count = n;

        for (int i = 0; i < n; i++)
            this.id[i] = i;

        for (int i = 0; i < n; i++)
            this.sz[i] = 1;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j)
            return;

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public String getEarliestTime() {
        Scanner scanner = new Scanner(fileInputStream,"utf-8");
        String time = null;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line != null&&!line.trim().equals("")){
                String[] lineArray = line.split(" ");
                Integer p = Integer.parseInt(lineArray[1]);
                Integer q = Integer.parseInt(lineArray[2]);
                union(p,q);
                if (count == 1){
                    return lineArray[0];
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        FileInputStream ins;

        try {
            ins = new FileInputStream("files/network-connectivity");
            NetworkConnectivity networkConnectivity = new NetworkConnectivity(10, ins);
            networkConnectivity.getEarliestTime();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
