package src.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Spanning Tree: a Tree that includes all the vertexes
//Minimum Spanning Tree: a Tree that includes all the vertexes with minimum sum of weights
//Two possible algorithms are: Prims, Kruskals (yet to do)
//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
//Dijkstra's and Bellmanford (works for negative as well) are two algorithms used for finding the shortest distance between any two nodes
public class GraphForAlgorithms {

	int noOfVertices;

	public int getNoOfVertices() {
		return noOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		this.noOfVertices = noOfVertices;
	}

	public LinkedList<Node>[] getAdjList() {
		return adjList;
	}

	public void setAdjList(LinkedList<Node>[] adjList) {
		this.adjList = adjList;
	}

	LinkedList<Node>[] adjList;

	public GraphForAlgorithms(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjList = new LinkedList[noOfVertices];
	}

	static class Node {
		int vertex;
		int weightOfTheEdge;

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public int getWeightOfTheEdge() {
			return weightOfTheEdge;
		}

		public void setWeightOfTheEdge(int weightOfTheEdge) {
			this.weightOfTheEdge = weightOfTheEdge;
		}

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weightOfTheEdge = weight;
		}
	}

	// directed weight graph
	public void addDirectedEdge(int startVertex, int endVertex, int weight) {
		if (adjList[startVertex] == null) {
			adjList[startVertex] = new LinkedList();
		}
		adjList[startVertex].add(new Node(endVertex, weight));
	}

	public void addUnDirectedEdge(int startVertex, int endVertex, int weight) {
		if (adjList[startVertex] == null) {
			adjList[startVertex] = new LinkedList();
		}
		if (adjList[endVertex] == null) {
			adjList[endVertex] = new LinkedList();
		}
		adjList[startVertex].add(new Node(endVertex, weight));
		adjList[endVertex].add(new Node(startVertex, weight));
	}

	public static void main(String[] args) {
		minDiForDirectedGraphUsingBFS();
		minDiForDirectedGraphUsingDFS();

		minDisForUnDirectedGraphUsingBFS();
		minDisForUnDirectedGraphUsingDFS();

		minDisForDirectedGraphWithNegativeWeightsUsingBFS();
		minDisForDirectedGraphWithNegativeWeightsUsingDFS();

	}

	public static void minDiForDirectedGraphUsingDFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(5);
		graph.addDirectedEdge(0, 1, 4);
		graph.addDirectedEdge(0, 2, 1);
		graph.addDirectedEdge(2, 1, 2);
		graph.addDirectedEdge(2, 3, 4);
		graph.addDirectedEdge(3, 4, 4);
		graph.addDirectedEdge(1, 4, 4);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertex(0, visitedArray, minWeightsGraph, 0);
		minimumDistance(minWeightsGraph);
	}

	public static void minDiForDirectedGraphUsingBFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(5);
		graph.addDirectedEdge(0, 1, 4);
		graph.addDirectedEdge(0, 2, 1);
		graph.addDirectedEdge(2, 1, 2);
		graph.addDirectedEdge(2, 3, 4);
		graph.addDirectedEdge(3, 4, 4);
		graph.addDirectedEdge(1, 4, 4);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertexUsingBFS(0, visitedArray, minWeightsGraph);
		// we cannot assume this would be the minimum spanning tree, we have consider
		// running this method from all vertices and then check for minimum spannig tree
		minimumDistance(minWeightsGraph);
	}

	// will not work if there is a cycle with cumulative weight of all the cycle
	// edges is less than 0
	public static void minDisForDirectedGraphWithNegativeWeightsUsingDFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(7);
		graph.addDirectedEdge(0, 1, 6);
		graph.addDirectedEdge(0, 2, 5);
		graph.addDirectedEdge(0, 3, 5);
		graph.addDirectedEdge(2, 1, -2);
		graph.addDirectedEdge(3, 2, -2);
		graph.addDirectedEdge(3, 5, -1);
		graph.addDirectedEdge(1, 4, -1);
		graph.addDirectedEdge(2, 4, 1);
		graph.addDirectedEdge(5, 6, 3);
		graph.addDirectedEdge(4, 6, 3);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertex(0, visitedArray, minWeightsGraph, 0);
		minimumDistance(minWeightsGraph);
	}

	// will not work if there is a cycle with cumulative weight of all the cycle
	// edges is less than 0
	public static void minDisForDirectedGraphWithNegativeWeightsUsingBFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(7);
		graph.addDirectedEdge(0, 1, 6);
		graph.addDirectedEdge(0, 2, 5);
		graph.addDirectedEdge(0, 3, 5);
		graph.addDirectedEdge(2, 1, -2);
		graph.addDirectedEdge(3, 2, -2);
		graph.addDirectedEdge(3, 5, -1);
		graph.addDirectedEdge(1, 4, -1);
		graph.addDirectedEdge(2, 4, 1);
		graph.addDirectedEdge(5, 6, 3);
		graph.addDirectedEdge(4, 6, 3);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertexUsingBFS(0, visitedArray, minWeightsGraph);
		minimumDistance(minWeightsGraph);
	}

	public static void minDisForUnDirectedGraphUsingDFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(5);
		graph.addUnDirectedEdge(0, 1, 1);
		graph.addUnDirectedEdge(0, 2, 7);
		graph.addUnDirectedEdge(1, 2, 5);
		graph.addUnDirectedEdge(1, 3, 4);
		graph.addUnDirectedEdge(1, 4, 3);
		graph.addUnDirectedEdge(3, 4, 2);
		graph.addUnDirectedEdge(4, 2, 6);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertex(0, visitedArray, minWeightsGraph, 0);
		minimumDistance(minWeightsGraph);
	}

	public static void minDisForUnDirectedGraphUsingBFS() {
		GraphForAlgorithms graph = new GraphForAlgorithms(5);
		graph.addUnDirectedEdge(0, 1, 1);
		graph.addUnDirectedEdge(0, 2, 7);
		graph.addUnDirectedEdge(1, 2, 5);
		graph.addUnDirectedEdge(1, 3, 4);
		graph.addUnDirectedEdge(1, 4, 3);
		graph.addUnDirectedEdge(3, 4, 2);
		graph.addUnDirectedEdge(4, 2, 6);

		int[] minWeightsGraph = new int[graph.noOfVertices];
		Arrays.fill(minWeightsGraph, Integer.MAX_VALUE);
		boolean[] visitedArray = new boolean[graph.noOfVertices];
		graph.finMinDistanceForAllVerticesFromGivenVertexUsingBFS(0, visitedArray, minWeightsGraph);
		minimumDistance(minWeightsGraph);
	}

	public void finMinDistanceForAllVerticesFromGivenVertex(int startVertex, boolean[] visitedArray,
			int[] minWeightsGraph, int weightSoFar) {
		visitedArray[startVertex] = true;
		minWeightsGraph[startVertex] = weightSoFar;
		LinkedList<Node> adjList = this.getAdjList()[startVertex];
		if (adjList != null && !adjList.isEmpty()) {
			java.util.Iterator<Node> it = adjList.iterator();
			while (it.hasNext()) {
				Node neighbor = it.next();
				int currentVertex = neighbor.getVertex();
				if (!visitedArray[currentVertex] || (visitedArray[currentVertex]
						&& minWeightsGraph[currentVertex] > weightSoFar + neighbor.getWeightOfTheEdge())) {
					finMinDistanceForAllVerticesFromGivenVertex(currentVertex, visitedArray, minWeightsGraph,
							weightSoFar + neighbor.getWeightOfTheEdge());
				}
			}
		}
	}

	public void finMinDistanceForAllVerticesFromGivenVertexUsingBFS(int startVertex, boolean[] visitedArray,
			int[] minWeightsGraph) {
		visitedArray[startVertex] = true;
		minWeightsGraph[startVertex] = 0;
		Queue<Node> vertices = new LinkedList<>();
		Node vertexNode = new Node(startVertex, 0);
		vertices.add(vertexNode);
		while (!vertices.isEmpty()) {
			Node currentNode = vertices.poll();
			LinkedList<Node> adjList = this.getAdjList()[currentNode.getVertex()];
			if (adjList != null && !adjList.isEmpty()) {
				java.util.Iterator<Node> it = adjList.iterator();
				while (it.hasNext()) {
					Node neighbor = it.next();
					int neighborVertex = neighbor.getVertex();
					int weightToReachNeighborVertex = currentNode.getWeightOfTheEdge() + neighbor.getWeightOfTheEdge();
					if (!visitedArray[neighborVertex] || (visitedArray[neighborVertex]
							&& minWeightsGraph[neighborVertex] > weightToReachNeighborVertex)) {
						visitedArray[neighborVertex] = true;
						minWeightsGraph[neighborVertex] = weightToReachNeighborVertex;
						vertices.add(new Node(neighborVertex, weightToReachNeighborVertex));
					}
				}
			}
		}
	}

	public static void minimumDistance(int[] minimumDistance) {
		int length = minimumDistance.length;
		for (int i = 0; i < length; i++) {
			System.out.println(i + " -> " + minimumDistance[i]);
		}
		System.out.println();
	}

}
