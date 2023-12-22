import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            String fileContent1 = new String(Files.readAllBytes(Paths.get("Resources/file1.txt")));
            String fileContent2 = new String(Files.readAllBytes(Paths.get("Resources/file2.txt")));
            Main main = new Main();
            main.numOfWords(fileContent1, fileContent2);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            main.firstWordWithMoreThanX(fileContent1, fileContent2, 4);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            main.longestWord(fileContent1, fileContent2);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            main.repeatedWords(fileContent1, fileContent2);
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void numOfWords(String fileContent1, String fileContent2) {
        int numOfWordsFile1 = (int) Arrays.stream(fileContent1.split("[\\s,\\.]+"))
                .count();
        System.out.println("The number of words on file 1 is: " + numOfWordsFile1 + ".");

        int numOfWordsFile2 = (int) Arrays.stream(fileContent2.split("[\\s,\\.]+"))
                .count();
        System.out.println("The number of words on file 2 is: " + numOfWordsFile2 + ".");

    }

    public void firstWordWithMoreThanX(String fileContent1, String fileContent2, int n) {
        System.out.print("The first word with more than " + n + " characters in file 1 is: ");
        Arrays.stream(fileContent1.split("[\\s,\\.]+"))
                .filter(word -> word.length() > n)
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println(".");

        System.out.print("The first word with more than " + n + " characters in file 2 is: ");
        Arrays.stream(fileContent2.split("[\\s,\\.]+"))
                .filter(word -> word.length() > n)
                .findFirst()
                .ifPresent(System.out::print);
        System.out.println(".");
    }

    public void longestWord(String fileContent1, String fileContent2) {
        String longestWord1 = Arrays.stream(fileContent1.split("[\\s,\\.]+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("The longest word in file 1 is: " + longestWord1 + ".");

        String longestWord2 = Arrays.stream(fileContent2.split("[\\s,\\.]+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("The longest word in file 2 is: " + longestWord2 + ".");
    }

    public void repeatedWords(String fileContent1, String fileContent2) {
        List<String> wordsList1 = Arrays.asList(fileContent1.split("[\\s,\\.]+"));
        String repeatedWords = Arrays.stream(fileContent2.split("[\\s,\\.]+"))
                .filter(wordsList1::contains)
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("The repeated words were: " + repeatedWords + ".");
    }


}

