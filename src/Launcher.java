import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenu en enfer!");
        String i ;
        Scanner sc = new Scanner(System.in);
        do {
            i = sc.next();
            if ("fibo".equals(i)) {
                System.out.println("donner nombre");
                int number = 0;
                boolean isNumber = true;
                while (isNumber) {
                    try {
                        number = sc.nextInt();

                    } catch (NoSuchElementException e) {
                        System.out.println("pas un nombre");
                        continue;
                    } finally {
                        sc.nextLine();
                    }
                    isNumber = false;
                }
                System.out.println(fibo(number));
            } else if ("freq".equals(i)) {
                System.out.println("entrer chemin fichier");
                i = sc.next();
                sc.nextLine();
                Path path =null;
                try {
                    path = Paths.get(i);
                } catch (InvalidPathException e) {
                    System.out.println("Unreadable File");
                }
                System.out.println(path);
                try {
                    i = java.nio.file.Files.readString(path);
                }catch (java.io.IOException e){
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

            } else {
                System.out.println("unknow Command");
            }
        } while ((!"quit".equals(i)));
    }

    private static int fibo(int n) {
        if (n <= 1) return n;
        else return fibo(n - 1) + fibo(n - 2);
    }
}
