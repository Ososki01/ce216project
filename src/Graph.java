import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, Node> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(String word, String language, String meaning) {
        String key = word + "-" + language;
        if (!nodes.containsKey(key)) {
            Node newNode = new Node(word, language);
            if (language.equals("turkish")) {
                newNode.addMeaning("english", meaning); // add the English meaning for Turkish words
            }
            nodes.put(key, newNode);
        } else {
            Node node = nodes.get(key);
            if (language.equals("turkish")) {
                node.addMeaning("english", meaning); // add the English meaning for existing Turkish nodes
            }
        }
    }

    public void addConnection(String word1, String lang1, String word2, String lang2) {
        String key1 = word1 + "-" + lang1;
        String key2 = word2 + "-" + lang2;

        if (nodes.containsKey(key1) && nodes.containsKey(key2)) {
            Node node1 = nodes.get(key1);
            Node node2 = nodes.get(key2);
            node1.addNeighbor(node2);
            node2.addNeighbor(node1);
        }
    }

    public Node getNode(String word, String language) {
        String key = word + "-" + language;
        if (nodes.containsKey(key)) {
            return nodes.get(key);
        } else {
            return null;
        }
    }

    public ArrayList<Node> getNeighbors(String word, String language) {
        Node node = getNode(word, language);
        if (node != null) {
            return node.getNeighbors();
        } else {
            return null;
        }
    }

}