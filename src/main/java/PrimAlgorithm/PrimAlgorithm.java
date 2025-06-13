package PrimAlgorithm;

import java.util.*;

public class PrimAlgorithm {
    public static int iterationCounter = 0;

    public static class Edge {
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static List<Edge> primMST(List<Edge> edges, int vertexCount) {
        iterationCounter = 0;
        List<Edge> mst = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        visited[0] = true;
        for (Edge edge : edges) {
            if (edge.from == 0) {
                pq.add(edge);
            }
        }

        while (!pq.isEmpty() && mst.size() < vertexCount - 1) {
            iterationCounter++;
            Edge minEdge = pq.poll();

            if (!visited[minEdge.to]) {
                visited[minEdge.to] = true;
                mst.add(minEdge);

                for (Edge edge : edges) {
                    if (edge.from == minEdge.to && !visited[edge.to]) {
                        pq.add(edge);
                    }
                }
            }
        }

        return mst;
    }
}