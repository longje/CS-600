
public class Node {
	public String name;
	public int d;
	public String parent;
	public Edge[] adjEdges;
	
	public Node(String name)
	{
		this.name = name;
	}
	
	public Node(String name, Edge[] adjEdges)
	{
		this.name = name;
		this.adjEdges = adjEdges;
	}
}
