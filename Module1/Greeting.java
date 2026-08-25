import java.util.Scanner;
public class Greeting {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "! Welcome to the program.");
        System.out.print("What do you do for work (job title)? ");
        String jobTitle = scanner.nextLine();
        System.out.println("Hello, " + name +"! As a "+ jobTitle+", you are exactly in the right place.");
        scanner.close();
    }
}
