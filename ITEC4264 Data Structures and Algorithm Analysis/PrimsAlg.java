import java.util.*;

public class PrimsAlg
{

    // Helper class to represent edge
    static class Edge
    {
        int targetVert;
        int weight;

        public Edge (int targetVert, int weight)
        {
            this.targetVert = targetVert;
            this.weight = weight;
        }
    }

    // Helper class to store result of MST construction
    static class MSTResult
    {
        List<String> edges;
        int totalWeight;

        public MSTResult(List<String> edges, int totalWeight)
        {
            this.edges = edges;
            this.totalWeight = totalWeight;
        }
    }

    // Execute Prim's algorithm starting from specified source vertex
    public static MSTResult findMST(List<List<Edge>> graph, int numVert, int startVert)
    {
        // Store edges to consider; ensures edge with min weight is priority
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Track vertices already included in MST
        boolean[] visited = new boolean[numVert +1];

        // List to store edges of MST
        List<String> mstEdges = new ArrayList<>();
        int totalWeight = 0;
        // Stop when number of edges = N - 1
        int edgeCount = 0;

        // Start algorithm from source vertex; add all edges from starting vertex to priority queue
        visited[startVert] = true;
        for (Edge edge : graph.get(startVert))
        {
            // Store as [weight, targetVert, sourceVert] to track edge
            minHeap.offer(new int[]{edge.weight, edge.targetVert, startVert});
        }

        // Loop until all vertices are included (N-1 edges) or heap is empty
        while (!minHeap.isEmpty() && edgeCount < numVert - 1)
        {
            // Get the min weight edge
            int[] currentEdge = minHeap.poll();
            int weight = currentEdge[0];
            int target = currentEdge[1];
            int source = currentEdge[2];

            // If target already visited, skip this edge
            if (visited[target])
            {
                continue;
            }

            // Include new vertex and edge in MST
            visited[target] = true;
            mstEdges.add("(" + source + " - " + target + ") Weight:" + weight);
            totalWeight += weight;
            edgeCount++;

            // Add unvisited to priority queue
            for (Edge edge : graph.get(target))
            {
                if (!visited[edge.targetVert])
                {
                    // Store as [weight, targetVert, sourceVert]
                    minHeap.offer(new int[]{edge.weight, edge.targetVert, target});
                }
            }
        }

        return new MSTResult(mstEdges, totalWeight);
    }

    // Main method sets up graph and runs algorithm
    public static void main(String[] args)
    {
        int numVert = 8;
        int startVert = 1;

        // Start adjacency List
        List<List<Edge>> graph = new ArrayList<>(numVert + 1);
        for (int i = 0; i <= numVert; i++)
        {
            graph.add(new ArrayList<>());
        }

        // Define edges from picture on instructions
        // Vertex 1
        graph.get(1).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 1));

        graph.get(1).add(new Edge(4, 10));
        graph.get(4).add(new Edge(1, 10));

        graph.get(1).add(new Edge(6, 12));
        graph.get(6).add(new Edge(1, 12));

        // Vertex 2
        graph.get(2).add(new Edge(3, 8));
        graph.get(3).add(new Edge(2, 8));

        graph.get(2).add(new Edge(4, 4));
        graph.get(4).add(new Edge(2, 4));

        graph.get(2).add(new Edge(5, 7));
        graph.get(5).add(new Edge(2, 7));

        // Vertex 3
        graph.get(3).add(new Edge(5, 2));
        graph.get(5).add(new Edge(3, 2));

        graph.get(3).add(new Edge(8, 5));
        graph.get(8).add(new Edge(3, 5));

        // Vertex 4
        graph.get(4).add(new Edge(5, 5));
        graph.get(5).add(new Edge(4, 5));

        graph.get(4).add(new Edge(6, 8));
        graph.get(6).add(new Edge(4, 8));

        graph.get(4).add(new Edge(7, 11));
        graph.get(7).add(new Edge(4, 11));

        // Vertex 5
        graph.get(5).add(new Edge(7, 3));
        graph.get(7).add(new Edge(5, 3));

        graph.get(5).add(new Edge(8, 9));
        graph.get(8).add(new Edge(5, 9));

        // Vertex 6
        graph.get(6).add(new Edge(7, 5));
        graph.get(7).add(new Edge(6, 5));

        graph.get(6).add(new Edge(8, 6));
        graph.get(8).add(new Edge(6, 6));

        // Vertex 7
        graph.get(7).add(new Edge(8, 4));
        graph.get(8).add(new Edge(7, 4));

        // Execute the algorithm
        System.out.println("Running Prim's Algorithm (Source: Vertex " + startVert + ")");
        MSTResult result = findMST(graph, numVert, startVert);

        // Output results
        System.out.println("\nMST Edges:");
        for (String edge : result.edges)
        {
            System.out.println(" " + edge);
        }

        System.out.println("\nTotal MST weight: " + result.totalWeight);

    }
}