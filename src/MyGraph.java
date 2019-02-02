import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//djikstra's algorithm, Prims algorithm, minimum spanning tree
public class MyGraph {
	int noOfVertices;
	LinkedList<Integer>[] adjacencyMatrix;

	public MyGraph(int pNoOfVertices) {
		this.noOfVertices = pNoOfVertices;
		adjacencyMatrix = new LinkedList[pNoOfVertices];
	}

	public void addEdge(int startVertex, int endVertex) {
		if (Objects.isNull(adjacencyMatrix[startVertex])) {
			adjacencyMatrix[startVertex] = new LinkedList<>();
		}
		adjacencyMatrix[startVertex].add(endVertex);

	}

	public void addTwoSideEdge(int startVertex, int endVertex) {
		if (Objects.isNull(adjacencyMatrix[startVertex])) {
			adjacencyMatrix[startVertex] = new LinkedList<>();
		}
		adjacencyMatrix[startVertex].add(endVertex);
		if (Objects.isNull(adjacencyMatrix[endVertex])) {
			adjacencyMatrix[endVertex] = new LinkedList<>();
		}
		adjacencyMatrix[endVertex].add(startVertex);
	}

	public static void main(String[] args) {
		MyGraph graph = new MyGraph(6);
		graph.addEdge(5, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(0, 4);
		graph.addEdge(5, 0);
		System.out.println("Printing BFS");

		graph.BFS(5);
		boolean[] visited = new boolean[graph.noOfVertices];
		System.out.println("Printing DFS");
		graph.DFS(5, visited);
		System.out.println("Printing Topological");
		visited = new boolean[graph.noOfVertices];
		graph.topologicalSort(5, visited);

		MyGraph undirectedGraph = new MyGraph(5);
		undirectedGraph.addEdge(1, 0);
		undirectedGraph.addEdge(0, 2);
		undirectedGraph.addEdge(2, 0);
		undirectedGraph.addEdge(0, 3);
		undirectedGraph.addEdge(3, 4);
		visited = new boolean[graph.noOfVertices];

		System.out.println("Given graph is cyclic:" + undirectedGraph.isCyclic());
	}

	public void BFS(Integer startVertex) {
		if (startVertex >= this.noOfVertices) {
			return;
		} else {
			boolean[] visited = new boolean[this.noOfVertices];
			visited[startVertex] = true;
			LinkedList<Integer> adjList;
			Queue<Integer> vertices = new LinkedList<>();
			vertices.add(startVertex);
			System.out.println("Vertex is: " + startVertex);

			while (!vertices.isEmpty()) {
				adjList = this.adjacencyMatrix[vertices.poll()];
				if (Objects.nonNull(adjList)) {
					for (Integer adjVertex : adjList) {
						if (!visited[adjVertex]) {
							System.out.println("Vertex is: " + adjVertex);
							visited[adjVertex] = true;
							vertices.add(adjVertex);
						}
					}
				}

			}
		}
	}

	public void topologicalSort(Integer startVertex, boolean[] visited) {
		if (startVertex >= this.noOfVertices)
			return;
		else {
			visited[startVertex] = true;
			LinkedList<Integer> adjList;
			adjList = adjacencyMatrix[startVertex];
			if (adjList != null && !adjList.isEmpty())
				for (Integer vertex : adjList) {
					if (!visited[vertex]) {
						topologicalSort(vertex, visited);
					}
				}
			System.out.print(startVertex + " ");
		}

	}

	public void DFS(Integer startVertex, boolean[] visited) {
		if (startVertex >= this.noOfVertices) {
			return;
		} else {
			visited[startVertex] = true;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			System.out.println("Vertex is: " + startVertex);
			if (Objects.nonNull(adjList)) {
				for (Integer adjVertex : adjList) {
					if (!visited[adjVertex]) {
						DFS(adjVertex, visited);
					}
				}
			}
		}
	}

	public void primsAlgorithm() {

	}

	public boolean checkIfCyclePresentInGraph(Integer startVertex, boolean[] visited, Integer parent) {
		{
			visited[startVertex] = true;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			System.out.println("Vertex is: " + startVertex);
			if (Objects.nonNull(adjList)) {
				for (Integer adjVertex : adjList) {
					if (!visited[adjVertex]) {
						if (checkIfCyclePresentInGraph(adjVertex, visited, startVertex))
							return true;
					} else {
						if (adjVertex != parent)
							return true;
					}
				}
			}
			return false;
		}

	}

	// Returns true if the graph contains a cycle, else false.
	public boolean isCyclic() {
		// Mark all the vertices as not visited and not part of
		// recursion stack
		boolean visited[] = new boolean[this.noOfVertices];
		for (int i = 0; i < this.noOfVertices; i++)
			visited[i] = false;

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < this.noOfVertices; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (this.checkIfCyclePresentInGraph(u, visited, -1))
					return true;

		return false;
	}

	public static void minimumSpanningTree() {

	}

}
