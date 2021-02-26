package second;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
    private final NodeComparator nodeComparator;
    private ArrayList<Integer>[] adjLists;
    private boolean[] visited;
    private StringBuilder result;

    public Graph(int vertices) throws ArrayIndexOutOfBoundsException {
        nodeComparator = new NodeComparator();
        adjLists = new ArrayList[vertices];
        visited = new boolean[vertices];
        result = new StringBuilder();

        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        ArrayList<Integer> node = adjLists[src];
        node.add(dest);
        node.sort(nodeComparator);
    }

    public String DFS(int vertex) {
        visited[vertex] = true;
        result.append(String.format("%d ", vertex));

        Iterator<Integer> iterator = adjLists[vertex].listIterator();
        while (iterator.hasNext()) {
            int adj = iterator.next();
            if (!visited[adj]) {
                DFS(adj);
            }
        }
        return result.toString().trim();
    }
}
