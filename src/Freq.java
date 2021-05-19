import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command {
    public String name() {
        return "freq";
    }

    public Boolean run(Scanner sc) {
        System.out.println("entrer chemin fichier");
        String i = sc.nextLine();
        Path path = null;
        try {
            path = Paths.get(i);
        } catch (InvalidPathException e) {
            System.out.println("wrong path");
        }
        System.out.println(path);
        try {
            i = java.nio.file.Files.readString(path);
        } catch (java.io.IOException e) {
            System.out.println(e);
        }
        String[] words = i.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");

        Stream<String> wordstream = Arrays.stream(words);
        Map<String, Long> countByword = wordstream
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Comparator<Map.Entry<String, Long>> countreversed =
                Comparator.<Map.Entry<String, Long>, Long>comparing(e -> e.getValue())
                        .reversed();

        String reuslt = countByword.entrySet().stream()
                .sorted(countreversed)
                .limit(3)
                .map(e -> e.getKey())
                .collect(Collectors.joining(" "));
        System.out.println(reuslt);
        return false;
    }
}
