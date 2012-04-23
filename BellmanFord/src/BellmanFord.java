
public class BellmanFord {
	public static void InitializeSingleSource(Node[] nodes, Node s)
	{
		for(Node node: nodes) {
			node.d = 10000;
			node.parent = "NIL";
		}
		
		s.d = 0;
	}
	
	public static void Relax(Node u, Node v, int w)
	{
		if (v.d > u.d + w) {
			v.d = u.d + w;
			v.parent = u.name;
		}
	}
	
	public static Boolean BellFord(Node[] nodes, Edge[] edges, Node s)
	{
		InitializeSingleSource(nodes, s);
		System.out.println("Initialization : 0");
		printResult(nodes);
		
		for (int i = 1; i < nodes.length - 1; i++) {
			for(Edge edge: edges) {
				Relax(edge.u, edge.v, edge.weight);

			}
			System.out.println("Pass : " + i);
			printResult(nodes);
		}
		
		for(Edge edge: edges)
			if (edge.v.d > edge.u.d + edge.weight)
				return false;
		return true;
	}
	
	public static void printResult(Node[] nodes)
	{
		for (Node node: nodes)
			System.out.println("Node: " + node.name + ", parent: " + node.parent + ", weight: " + node.d);
	}
}
