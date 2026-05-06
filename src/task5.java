import java.util.*;

class Edge {
    String target;
    int weight;

    Edge(String t, int w) {
        target = t;
        weight = w;
    }
}

public class task5 {

    static Map<String, List<Edge>> graph = new HashMap<>();

    public static void main(String[] args) {

        addEdge("Edinburgh", "Perth", 100);
        addEdge("Perth", "Dundee", 60);
        addEdge("Edinburgh", "Stirling", 50);
        addEdge("Stirling", "Perth", 40);
        addEdge("Glasgow", "Stirling", 50);
        addEdge("Glasgow", "Edinburgh", 70);

        dijkstra("Edinburgh", "Dundee");
    }

    static void addEdge(String a, String b, int w) {
        graph.computeIfAbsent(a, k -> new ArrayList<>()).add(new Edge(b, w));
        graph.computeIfAbsent(b, k -> new ArrayList<>()).add(new Edge(a, w));
    }

    static void dijkstra(String start, String end) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (Edge e : graph.get(current)) {
                int newDist = dist.get(current) + e.weight;
                if (newDist < dist.get(e.target)) {
                    dist.put(e.target, newDist);
                    prev.put(e.target, current);
                    pq.add(e.target);
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Shortest path: " + path);
        System.out.println("Distance: " + dist.get(end));
    }
}
