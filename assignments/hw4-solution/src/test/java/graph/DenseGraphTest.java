package graph;

import java.util.Arrays;
import java.util.Iterator;

public class DenseGraphTest {

    public DenseGraph getGraph1() {

        DenseGraph graph = new DenseGraph(7);
        graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(2,5);
		graph.addEdge(2,6);
		graph.addEdge(3,6);
		graph.addEdge(4,5);
		graph.addEdge(5,6);

        return graph;
    }

    @org.junit.Test
    public void testGetAdjacencyMatrix() {
    
        DenseGraph graph = getGraph1();
        int[][] expected = new int[][]{
			{0,1,1,1,0,0,0},
			{1,0,1,0,1,0,0},
			{1,1,0,1,1,1,1},
			{1,0,1,0,0,0,1},
			{0,1,1,0,0,1,0},
			{0,0,1,0,1,0,1},
			{0,0,1,1,0,1,0},
		};
		
        assert (Arrays.deepEquals(expected, graph.getAdjacencyMatrix()));
    }

    @org.junit.Test
    public void testAddEdge() {

        DenseGraph graph = getGraph1();
        graph.addEdge(1, 6);
        
        assert (graph.areAdjacent(1, 6));
    }

    @org.junit.Test
    public void testRemoveEdge() {

        DenseGraph graph = getGraph1();
        graph.addEdge(1, 6);
        graph.removeEdge(1, 6);
        
        assert (!graph.areAdjacent(1, 6));
    }

    @org.junit.Test
    public void testAreAdjacent() {

        DenseGraph graph = getGraph1();
        
        assert (graph.areAdjacent(6, 3));
    }

    @org.junit.Test
    public void testDegree() {
        
        DenseGraph graph = getGraph1();

        assert (graph.degree(1) == 3);
        assert (graph.degree(2) == 6);
    }

    @org.junit.Test
    public void testNeighboursIterator() {

        DenseGraph graph = getGraph1();

        Iterator<Integer> it = graph.neighboursIterator(3);
		assert (it != null);
        assert (it.hasNext() && it.next() == 0);
        assert (it.hasNext() && it.next() == 2);
        assert (it.hasNext() && it.next() == 6);
        assert (!it.hasNext());
    }

    @org.junit.Test
    public void testNumberOfVertices() {
        
        DenseGraph graph = getGraph1();

        assert (graph.numberOfVertices() == 7);
    }

    @org.junit.Test
    public void testNumberOfEdges() {

        DenseGraph graph = getGraph1();

        assert (graph.numberOfEdges() == 12);
    }

    @org.junit.Test
    public void testDistance() {

        DenseGraph graph = getGraph1();

        assert (graph.distance(0, 5) == 2);  
        assert (graph.distance(4, 5) == 1);      
    }

    @org.junit.Test
    public void testGenerateRandomGraph() {

        DenseGraph randomGraph = DenseGraph.generateRandomGraph(100, 0.5);

        int max = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = i+1; j < 100; j++) {
				max = Math.max(max, randomGraph.distance(i, j));
			}
		}

        assert (max == 2);
        assert (randomGraph.degree(1) > 35 && randomGraph.degree(1) < 65);
        assert (randomGraph.numberOfEdges() > 1500 && randomGraph.numberOfEdges() < 3500);
    }

}