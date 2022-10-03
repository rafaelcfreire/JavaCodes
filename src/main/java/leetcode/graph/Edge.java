package leetcode.graph;

public class Edge implements Comparable<Edge> {
    private int from;
    private int to;
    private int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}