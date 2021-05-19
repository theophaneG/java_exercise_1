import java.util.Scanner;

public class Quit implements Command{
    public String name(){
        return "quit";
    }
    public Boolean run(Scanner sc){
        return true;
    }

}
