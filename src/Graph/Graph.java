package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Graph {

    //nodes provides fast lookup of nodes by their labels.
    private Map<String, Node> nodes = new HashMap<>();
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
}
