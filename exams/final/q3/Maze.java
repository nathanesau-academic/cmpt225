import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Maze {
    
    private static Map<String, List<Integer[]>> build_graph(int[][] grid) {

        var graph = new HashMap<String, List<Integer[]>>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                var nb = new ArrayList<Integer[]>();
                if (i-1 >= 0 && grid[i][j] == 1) nb.add(new Integer[]{i-1, j});
                if (i+1 < grid.length && grid[i][j] == 1) nb.add(new Integer[]{i+1, j});
                if (j-1 >= 0 && grid[i][j] == 1) nb.add(new Integer[]{i, j-1});
                if (j+1 < grid[i].length && grid[i][j] == 1) nb.add(new Integer[]{i, j+1});
                graph.put(String.format("%d-%d", i, j), nb);
            }
        }

        return graph;
    }

    private static List<Integer[]> shortest_path(Map<String, Integer[]> prev,
            Integer[] src, Integer[] dest) {
        
        List<Integer[]> path = new ArrayList<>();
        Integer[] u = dest;
        while (!u.equals(src)) {
            path.add(0, u);
            u = prev.get(String.format("%d-%d", u[0], u[1]));
        }
        path.add(0, src);
        return path;
    }

    private static List<Integer[]> solve(Map<String, List<Integer[]>> graph,
        Integer[] src, Integer[] dest) {

        String destk = String.format("%d-%d", dest[0], dest[1]);
        Map<String, Integer> dist = new HashMap<String, Integer>();
        Map<String, Integer[]> prev = new HashMap<String, Integer[]>();

        for (Entry<String, List<Integer[]>> entry : graph.entrySet()) {
            dist.put(entry.getKey(), Integer.MAX_VALUE);
            prev.put(entry.getKey(), null);
        }

        List<Map.Entry<Integer, Integer[]>> q = new ArrayList<>();
        q.add(new AbstractMap.SimpleEntry<>(0, src));

        while (!q.isEmpty()) {

            Entry<Integer, Integer[]> entry = q.remove(0);
            Integer distu = entry.getKey();
            Integer[] u = entry.getValue();
            String uk = String.format("%d-%d", u[0], u[1]);

            if (uk.equals(destk)) {
                return shortest_path(prev, src, u);
            }

            var nb = graph.get(uk);
            for (Integer[] v : nb) {
                Integer alt = distu + 1;
                String vk = String.format("%d-%d", v[0], v[1]);
                if (alt < dist.get(vk)) {
                    dist.put(vk, alt);
                    prev.put(vk, u);
                    q.add(new AbstractMap.SimpleEntry<>(alt, v));
                }
            }
        }

        return Arrays.asList();
    }

    public static void printPath(int[][] grid) {
        var graph = build_graph(grid);
        var src = new Integer[]{0, 0};
        var dest = new Integer[]{grid.length-1, grid[0].length-1};
        var path = solve(graph, src, dest);
        path.forEach(p -> System.out.printf("%d,%d%n", p[0], p[1]));
    }

    public static void main(String[] args) {
        int[][] board = {
            {1,1,1,1,1},
            {1,0,0,0,1},
            {1,0,1,1,1},
            {1,1,1,0,0},
            {1,1,1,1,1},
            {0,0,1,0,1}
        };        
        printPath(board);
    }

}