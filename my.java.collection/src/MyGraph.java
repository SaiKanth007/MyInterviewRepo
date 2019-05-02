package src;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//djikstra's algorithm, Prims algorithm, minimum spanning tree
//https://stackoverflow.com/questions/2218322/what-is-better-adjacency-lists-or-adjacency-matrices-for-graph-problems-in-c
//bellman ford - https://www.youtube.com/watch?v=FtN3BYH2Zes

// A graph can be a tree if 
//i) its a connected graph (use BFS or DFS from one vertex and check if all vertices can be covered)
//ii) There are no cycles present
public class MyGraph {
	int noOfVertices;
	LinkedList<Integer>[] adjacencyMatrix;

	public MyGraph(int pNoOfVertices) {
		this.noOfVertices = pNoOfVertices;
		// size of the adjacency matrix is pNoOfVertices and not pNoOfVertices-1,
		// because it can also point to itself
		adjacencyMatrix = new LinkedList[pNoOfVertices];
	}

	public void addEdge(int startVertex, int endVertex) {
		if (Objects.isNull(adjacencyMatrix[startVertex])) {
			adjacencyMatrix[startVertex] = new LinkedList();
		}
		adjacencyMatrix[startVertex].add(endVertex);

	}

	public void addTwoSideEdge(int startVertex, int endVertex) {
		if (Objects.isNull(adjacencyMatrix[startVertex])) {
			adjacencyMatrix[startVertex] = new LinkedList();
		}
		adjacencyMatrix[startVertex].add(endVertex);
		if (Objects.isNull(adjacencyMatrix[endVertex])) {
			adjacencyMatrix[endVertex] = new LinkedList();
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

		MyGraph directedGraph = new MyGraph(6);
		directedGraph.addEdge(1, 2);
		directedGraph.addEdge(2, 0);
		directedGraph.addEdge(1, 0);
		directedGraph.addEdge(3, 0);
		directedGraph.addEdge(0, 4);

		System.out.println("Cycle is present in the graph:" + directedGraph.isCyclePresentForDirectedGraph());

		MyGraph undirectedGraph = new MyGraph(6);
		undirectedGraph.addTwoSideEdge(1, 2);
		undirectedGraph.addTwoSideEdge(1, 0);
		undirectedGraph.addTwoSideEdge(0, 3);
		undirectedGraph.addTwoSideEdge(2, 3);
		undirectedGraph.addTwoSideEdge(3, 4);

		System.out.println(
				"Cycle is present in the undirected graph:" + undirectedGraph.isCyclePresentForUnDirectedGraph());

		MyGraph hamiltonianGraph = new MyGraph(5);
		hamiltonianGraph.addTwoSideEdge(0, 1);
		hamiltonianGraph.addTwoSideEdge(1, 2);
		hamiltonianGraph.addTwoSideEdge(1, 3);
		hamiltonianGraph.addTwoSideEdge(2, 4);
		hamiltonianGraph.addTwoSideEdge(4, 3);
		hamiltonianGraph.addTwoSideEdge(3, 0);
		visited = new boolean[hamiltonianGraph.noOfVertices];
		Count count = new Count();
		System.out.println("Given graph is hamiltonian" + hamiltonianGraph.hamiltonianCycle(0, visited, count, -1));
	}

	public void BFS(Integer startVertex) {
		if (startVertex >= this.noOfVertices) {
			return;
		} else {
			boolean[] visited = new boolean[this.noOfVertices];
			visited[startVertex] = true;
			LinkedList<Integer> adjList;
			Queue<Integer> vertices = new LinkedList();
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

	// https://www.programcreek.com/2014/05/leetcode-course-schedule-java/
	public void topologicalSort(Integer startVertex, boolean[] visited) {
		if (startVertex >= this.noOfVertices)
			return;
		else {
			visited[startVertex] = true;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			if (Objects.nonNull(adjList))
				for (Integer vertex : adjList) {
					if (!visited[vertex]) {
						topologicalSort(vertex, visited);
					}
				}
			System.out.print(startVertex + " ");
		}

	}

	// can also be used for detecting cycle in a directed graph
	// https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
	public boolean isCyclePresentForDirectedGraph() {
		int visited[] = new int[this.noOfVertices];
		for (int i = 0; i < this.noOfVertices; i++) {
			if (visited[i] != 1)
				if (isCyclePresentForDirectedGraph(i, visited))
					return true;
		}
		return false;
	}

	public boolean isCyclePresentForDirectedGraph(Integer startVertex, int[] visited) {
		if (startVertex >= this.noOfVertices)
			return false;
		else {
			if (visited[startVertex] == -1)
				return true;
			else if (visited[startVertex] == 1)
				return false;

			visited[startVertex] = -1;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			if (Objects.nonNull(adjList))
				for (Integer vertex : adjList) {
					if (isCyclePresentForDirectedGraph(vertex, visited)) {
						return true;
					}
				}
			visited[startVertex] = 1;
			return false;
		}
	}

	// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
	// working
	public boolean isCyclePresentForUnDirectedGraph() {
		boolean visited[] = new boolean[this.noOfVertices];
		for (int i = 0; i < this.noOfVertices; i++) {
			if (!visited[i])
				if (isCyclePresentForUnDirectedGraph(i, visited, -1))
					return true;
		}
		return false;
	}

	public boolean isCyclePresentForUnDirectedGraph(Integer startVertex, boolean[] visited, int parent) {
		if (startVertex >= this.noOfVertices)
			return false;
		else {
			visited[startVertex] = true;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			if (Objects.nonNull(adjList))
				for (Integer vertex : adjList) {
					if (!visited[vertex]) {
						if (isCyclePresentForUnDirectedGraph(vertex, visited, startVertex)) {
							return true;
						}
					} else if (vertex != parent) {
						return true;
					}
				}
			return false;
		}

	}

	// Time complexity of DFS or BFS is O(E+V) (and not O(V) which we think, read
	// the link for the reason)
	// https://www.quora.com/What-is-the-time-complexity-of-Breadth-First-Search-Traversal-of-a-graph
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

	/*
	 * public boolean checkIfCyclePresentInGraph(Integer startVertex, boolean[]
	 * visited, Integer parent) { { visited[startVertex] = true; LinkedList<Integer>
	 * adjList = adjacencyMatrix[startVertex]; System.out.println("Vertex is: " +
	 * startVertex); if (Objects.nonNull(adjList)) { for (Integer adjVertex :
	 * adjList) { if (!visited[adjVertex]) { if
	 * (checkIfCyclePresentInGraph(adjVertex, visited, startVertex)) return true; }
	 * else { if (adjVertex != parent) return true; } } } return false; }
	 * 
	 * }
	 * 
	 * // Returns true if the graph contains a cycle, else false. public boolean
	 * isCyclic() { // Mark all the vertices as not visited and not part of //
	 * recursion stack boolean visited[] = new boolean[this.noOfVertices]; for (int
	 * i = 0; i < this.noOfVertices; i++) visited[i] = false;
	 * 
	 * // Call the recursive helper function to detect cycle in // different DFS
	 * trees for (int u = 0; u < this.noOfVertices; u++) if (!visited[u]) // Don't
	 * recur for u if already visited if (this.checkIfCyclePresentInGraph(u,
	 * visited, -1)) return true;
	 * 
	 * return false; }
	 * 
	 */

	// yet to do
	public static void minimumSpanningTree() {

	}

	// https://www.geeksforgeeks.org/hamiltonian-cycle-backtracking-6/
	// working
	public boolean hamiltonianCycle(Integer startVertex, boolean[] visited, Count count, Integer parent) {
		if (startVertex >= this.noOfVertices)
			return false;
		else {
			visited[startVertex] = true;
			count.value++;
			LinkedList<Integer> adjList = adjacencyMatrix[startVertex];
			if (Objects.nonNull(adjList))
				for (Integer vertex : adjList) {
					if (!visited[vertex]) {
						Count newCount = new Count();
						newCount.value = count.value;
						if (hamiltonianCycle(vertex, visited, newCount, startVertex)) {
							return true;
						}
					} else if (vertex != parent) {
						if (count.value == this.noOfVertices)
							return true;
					}
				}
			return false;
		}

	}

	// yet to do
	// https://www.geeksforgeeks.org/prims-mst-for-adjacency-list-representation-greedy-algo-6/
	public void primsAlgorithm() {

	}

}

class Count {
	Integer value = 0;
}
