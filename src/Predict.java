import javax.swing.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.gc;
import static java.lang.System.out;

public class Predict implements Command {
    @Override
    public String name() {
        return "predict";
    }

    @Override
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
            System.out.println("unreadable file : " + e);
        }

        String[] words = i.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");

       /* Stream<String> wordstream = Arrays.stream(words);
        System.out.println(wordstream);
        Map<String, Long> countByword = wordstream
                .filter(s -> !s.isBlank())
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countByword);*/

        List<String> myfile = new ArrayList();
        for (String worldo:words) {
            myfile.add(worldo);
        }
        String word = sc.nextLine();
        if (myfile.contains(word)) {
            Map<String, ArrayList<String>> mappy = new TreeMap<String, ArrayList<String>>();
            for (int y = 0 ; y < myfile.size()-1;y++)
            {
                if (mappy.containsKey(myfile.get(y)))
                {
                    mappy.get(myfile.get(y)).add(myfile.get(y+1));
                    Collections.sort(mappy.get(myfile.get(y)));
                }
                else
                {
                    mappy.put(myfile.get(y), new ArrayList<String>());
                    mappy.get(myfile.get(y)).add(myfile.get(y+1));
                }

            }
            for (Map.Entry<String, ArrayList<String>> entry : mappy.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
            }
            out.println("this is the last sentence");
            String last_words = new String();
            for (int z = 0 ; z <= 20 ; z++ )
            {
                last_words = last_words + " " + mappy.get(word).get(0);
                word = mappy.get(word).get(0);
            }
            out.println(last_words);
        }
        else
            out.println("dat ist not a walid word");

        return false;
    }
}
