import java.io.*;

public class Program {

	public static final int INFINITY = 10000;
	

	public static void main(String[] args) {
		
		/*
		int[][] W = { 	{0, 3, 8, INFINITY, -4},
						{INFINITY, 0, INFINITY, 1, 7},
						{INFINITY, 4, 0, INFINITY, INFINITY},
						{2, INFINITY, -5, 0, INFINITY},
						{INFINITY, INFINITY, INFINITY, 6, 0}
					};
		*/
		
		int[][] W = { 	{0, INFINITY, INFINITY, INFINITY, -1, INFINITY},
						{1, 0, INFINITY, 2, INFINITY, INFINITY},
						{INFINITY, 2, 0, INFINITY, INFINITY, -8},
						{-4, INFINITY, INFINITY, 0, 3, INFINITY},
						{INFINITY, 7, INFINITY, INFINITY, 0, INFINITY},
						{INFINITY, 5, 10, INFINITY, INFINITY, 0}
					};
		
		//printMatrix(W);
		int[][] solution = AllPairsShortestPaths.slowAllPairsShortestPaths(W);
		int[][] solution2 = AllPairsShortestPaths.fasterAllPairsShortestPaths(W);
		int[][] solution3 = AllPairsShortestPaths.floyedWarshall(W);
		//printMatrix(solution);
		
		Node[] nodes = new Node[]
	                {
						new Node("s"),
						new Node("t"),
						new Node("x"),
						new Node("y"),
						new Node("z"),
                    };
		Edge[] edges = new Edge[]
                         {
							new Edge(5, nodes[1], nodes[2]), // t -> x
							new Edge(8, nodes[1], nodes[3]), // t -> y
							new Edge(-4, nodes[1], nodes[4]), // t -> z
							new Edge(-2, nodes[2], nodes[1]), // x -> t
							new Edge(-3, nodes[3], nodes[2]), // y -> x
							new Edge(9, nodes[3], nodes[4]), // y-> z
							
							new Edge(4, nodes[4], nodes[2]), // z -> x
							new Edge(2, nodes[4], nodes[0]), // z -> s
							
							new Edge(6, nodes[0], nodes[1]), // s -> t
							new Edge(7, nodes[0], nodes[3]), // s -> y
							
                         };
		nodes[0].adjEdges = subArray(0, 1, edges);
		nodes[1].adjEdges = subArray(2, 4, edges);
		nodes[2].adjEdges = subArray(5, 5, edges);
		nodes[3].adjEdges = subArray(6, 7, edges);
		nodes[4].adjEdges = subArray(8, 9, edges);
		
		for (Node node: nodes)
			System.out.println("Node: " + node.name + ", parent: " + node.parent + ", weight: " + node.d);
		
		Boolean result = BellmanFord.BellFord(nodes, edges, nodes[4]);
		System.out.println("Contains no negative cycle? " + result);
		//printResult(nodes);
		

	}
	
	public static void printResult(Node[] nodes)
	{
		for (Node node: nodes)
			System.out.println("Node: " + node.name + ", parent: " + node.parent + ", weight: " + node.d);
	}
	
	public static Edge[] subArray(int begin, int end, Edge[] array)
	{
		Edge[] edges = new Edge[end - begin + 1];
		for (int i = 0; begin <= end; i++)
			edges[i] = array[begin++];
		return edges;
			
	}

}
