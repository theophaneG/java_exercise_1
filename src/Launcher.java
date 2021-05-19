import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {
        List<Command> commands = List.of(new Quit(),new Fibo(),new Freq());
        System.out.println("Bienvenu en enfer!");
        Scanner sc = new Scanner(System.in);
        String i = null;
        boolean mayQuit = false;
        boolean commandFound = false;
        do {
            i = sc.nextLine();
            for(Command command : commands){

                if(command.name().equals(i))
                {
                    commandFound = true;
                    mayQuit = command.run(sc);
                }
            }
            if (!commandFound) {
                System.out.println("unknow command");
            }
            commandFound = false;
        } while (!mayQuit);
    }


}
