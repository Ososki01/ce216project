import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "src/eng-tur.dict";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        ArrayList<String> englishWords = new ArrayList<String>();
        ArrayList<String> turkishWords = new ArrayList<String>();
        Graph dictionary = new Graph();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("/");
            if (parts.length >= 2) {
                String englishWord = parts[parts.length-2].trim();
                String turkishWord = parts[parts.length-1].trim();
                String[] turkishMeanings = turkishWord.split(",");

                englishWords.add(englishWord);
                turkishWords.add(turkishWord);

                dictionary.addNode(englishWord, "english", "");
                dictionary.addNode(turkishWord, "turkish", "");

                for (String meaning : turkishMeanings) {
                    if (!meaning.trim().equals("")) {
                        dictionary.getNode(turkishWord, "turkish").addMeaning("turkish", meaning.trim());
                    }
                }
                dictionary.addConnection(englishWord, "english", turkishWord, "turkish");
            }
        }
        System.out.println(turkishWords);
    }
}
