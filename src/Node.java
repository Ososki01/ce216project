import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private String word;
    private String language;
    private ArrayList<Node> neighbors;
    private HashMap<String, String> meanings; // new HashMap to store meanings for each language


    public Node(String word, String language) {
        this.word = word;
        this.language = language;
        this.neighbors = new ArrayList<>();
        this.meanings = new HashMap<>(); // initialize the HashMap
        this.meanings.put(language, ""); // add the language and an empty meaning

    }

    public String getWord() {
        return word;
    }
    public void addMeaning(String language, String meaning) {
        this.meanings.put(language, meaning);
    }
    public List<String> getMeanings(String language) {
        List<String> meanings = new ArrayList<>();
        for (Map.Entry<String, String> entry : this.meanings.entrySet()) {
            if (entry.getKey().equals(language)) {
                meanings.add(entry.getValue());
            }
        }
        return meanings;
    }


    public String getLanguage() {
        return language;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}