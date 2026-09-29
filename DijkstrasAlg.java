import java.util.*;

public class DijkstrasAlg
{
    // Helper class to represent edge
    static class Edge
    {
        int neighbor;
        int weight;

        public Edge(int neighbor, int weight)
        {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    // Helper class to store the state in priority queue
    static class State implements Comparable<State>
    {
        int vertex;
        int distance;

        public State(int vertex, int distance)
        {
            this.vertex = vertex;
            this.distance = distance;
        }

        // Compare based on distance for priority queue
        @Override
        public int compareTo(State other)
        {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Executes Dijkstra's alg to find the shortest path from source vertex to all other vertices in a weighted graph
    public static int[] dijkstra(List<List<Edge>> graph, int source, int numVert)
    {
        // Array stores shortest distance from source to vertex i
        int[] distances = new int[numVert + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Priority queue selects the vertex with smallest distance
        PriorityQueue<State> pQueue = new PriorityQueue<>();

        // Start at source vertex
        distances[source] = 0;
        pQueue.add(new State(source, 0));

        System.out.println("Dijkstra's Algorithm:");
        System.out.printf("Starting from source vertex: %d\n\n", source);

        while (!pQueue.isEmpty())
        {
            State current = pQueue.poll();
            int u = current.vertex;
            int distanceU = current.distance;

            // Skip longer path to u
            if (distanceU > distances[u])
            {
                continue;
            }

            System.out.printf("Processing vertex %d (Current shortest distance %d)\n", u, distanceU);

            // Iterate neighbors (v) of the current vertex (u)
            for (Edge edge : graph.get(u))
            {
                int v = edge.neighbor;
                int weight = edge.weight;

                int newDistance = distanceU + weight;

                // Relax if shorter path is found
                if (newDistance < distances[v])
                {
                    System.out.printf(" > Relaxing edge (%d -> %d) with weight %d. New distance to %d is %d (was %s)\n",
                    u, v, weight, v, newDistance, distances[v] == Integer.MAX_VALUE ? "INF" : String.valueOf(distances[v]));

                    // Update distance
                    distances[v] = newDistance;
                    
                    // Push neighbor to queue
                    pQueue.add(new State(v, newDistance));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args)
    {
        final int NUMVERT = 8;

        List<List<Edge>> graph = new ArrayList<>(NUMVERT + 1);
        for (int i = 0; i <= NUMVERT; i++)
        {
            graph.add(new ArrayList<>());
        }

        // Add edges from provided image
        // Vertex 1
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(4, 13));
        graph.get(1).add(new Edge(6, 12));

        // Vertex 2
        graph.get(2).add(new Edge(1, 1));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 6));
        graph.get(2).add(new Edge(5, 7));

        // Vertex 3
        graph.get(3).add(new Edge(2, 8));
        graph.get(3).add(new Edge(5, 2));
        graph.get(3).add(new Edge(8, 10));

        // Vertex 4
        graph.get(4).add(new Edge(1, 13));
        graph.get(4).add(new Edge(2, 6));
        graph.get(4).add(new Edge(5, 15));
        graph.get(4).add(new Edge(6, 14));
        graph.get(4).add(new Edge(7, 11));

        // Vertex 5
        graph.get(5).add(new Edge(2, 7));
        graph.get(5).add(new Edge(3, 2));
        graph.get(5).add(new Edge(4, 15));
        graph.get(5).add(new Edge(7, 3));
        graph.get(5).add(new Edge(8, 9));

        // Vertex 6
        graph.get(6).add(new Edge(1, 12));
        graph.get(6).add(new Edge(4, 14));
        graph.get(6).add(new Edge(7, 5));
        graph.get(6).add(new Edge(8, 16));

        // Vertex 7
        graph.get(7).add(new Edge(4, 11));
        graph.get(7).add(new Edge(5, 3));
        graph.get(7).add(new Edge(6, 5));
        graph.get(7).add(new Edge(8, 4));

        // Vertex 8
        graph.get(8).add(new Edge(3, 10));
        graph.get(8).add(new Edge(5, 9));
        graph.get(8).add(new Edge(6, 16));
        graph.get(8).add(new Edge(7, 4));

        final int SOURCEVERT = 1;

        int[] shortestDistances = dijkstra(graph, SOURCEVERT, NUMVERT);

        // Display final results
        System.out.println("\nShortest distances from vertex " + SOURCEVERT);
        for (int i = 1; i <= NUMVERT; i++)
        {
            String distance = shortestDistances[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(shortestDistances[i]);
            System.out.printf("Shortest distance to vertex %d: %s\n", i, distance);
        }
    }
}
