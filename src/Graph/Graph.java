package Graph;
import java.util.*;

public class Graph {

//    nodes:
//    +-------+-------------+
//    | Label |   Node      |
//    +-------+-------------+
//    |   A   | Node("A")   |
//    |   B   | Node("B")   |
//    |   C   | Node("C")   |
//    |  ...  |    ...      |
//    +-------+-------------+
    //nodes provides fast lookup of nodes by their labels.
    private Map<String, Node> nodes = new HashMap<>();

//    adjacencyList:
//    +-------------------+--------------------------+
//    |      Node         |         Neighbors         |
//    +-------------------+--------------------------+
//    |     Node("A")     |     [Node("B"), Node("C")]|
//    |     Node("B")     |     [Node("C")]           |
//    |     Node("C")     |     [Node("A")]           |
//    |       ...         |            ...            |
//    +-------------------+--------------------------+
    // adjacencyList efficiently represents the connections (edges) between those nodes.
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();


    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    // The addNode method is designed to ensure that:
    //  - Node Creation and Storage: A new node is created with the given label and added to the nodes map if it doesn't already exist, allowing efficient lookup by label.
    //  - Graph Structure Maintenance: An entry for the new node is initialized in the adjacencyList with an empty list, preparing the graph to store any future edges (connections) from this node to others.
    public void addNode(String label)
    {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    //The addEdge method retrieves the nodes corresponding to the given from and to labels,
    //ensures they exist in the graph, and then adds an edge by appending the toNode to the list of neighbors of fromNode in the adjacencyList,
    //effectively creating a directed connection from one node to another.
    public void addEdge(String from, String to)
    {
        var fromNode = nodes.get(from);
        if(fromNode == null){
            throw new IllegalArgumentException();
        }

        var toNode = nodes.get(to);

        if(toNode == null){
            throw new IllegalArgumentException();
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    //removeNode removes the node with the given label from the graph by deleting it from both the nodes map and the adjacencyList,
    //ensuring that all connections to and from the node are also removed to maintain the integrity of the graph structure.
    public void removeNode(String label)
    {
        var node = nodes.get(label);

        if(node == null){
            return;
        }

        for(var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    //removeEdge method deletes the connection from the node labeled from to the node labeled to if both nodes exist in the graph.
    public void removeEdge(String from, String to)
    {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode == null || toNode == null){
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    //The print method iterates through all the nodes in the adjacencyList,
    //and for each node with at least one neighbor, it prints the node and its list of connected nodes,
    //displaying the graph's structure in terms of its connections.
    public void print()
    {
        for(var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println(source + " is connected to " + targets);
            }
        }

    }

//    Start at the Root Node: Begin traversal at the specified starting node.
//    Visit Node and Mark as Visited: Print the node and add it to the visited set.
//    Recursively Visit Neighbors: For each neighbor of the current node, if it hasn't been visited, recursively perform DFS on that neighbor.
//    Backtrack When Necessary: If all neighbors are visited, backtrack to the previous node in the stack and continue.
    public void traverseDepthFirst(String root)
    {
        var node = nodes.get(root);
        if(node == null){
            return;
        }
        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited)
    {
        System.out.println(root);
        visited.add(root);

        for(var node : adjacencyList.get(root)){
            if(!visited.contains(node)){
                traverseDepthFirst(node, visited);
            }
        }
    }

//    Initialize: Start with the root node, mark it as unvisited, and push it onto the stack.
//    Process Nodes:
//    While there are nodes in the stack, pop a node and process it.
//    If it hasn't been visited, visit it and mark it as visited.
//    Push all unvisited neighbors of the current node onto the stack.
//    Repeat Until Stack is Empty: Continue this process until all reachable nodes are visited.
    public void traverseDepthFirstIterative(String root)
    {
        var node = nodes.get(root);
        if(node == null){
            return;
        }

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            var current = stack.pop();

            if(visited.contains(current)){
                continue;
            }
            System.out.println(current);
            visited.add(current);

            for(var neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour)){
                    stack.push(neighbour);
                }
            }
        }
    }

}
