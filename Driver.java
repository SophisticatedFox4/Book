import java.util.Scanner;
import java.io.*;
import java.net.URL;

public class Driver {
    public static void main(String[] args) {
        Book b = new Book();
        try {
            Scanner input = new Scanner(new URL("https://www.gutenberg.org/cache/epub/6130/pg6130.txt").openStream());
            BufferedWriter output = new BufferedWriter(new FileWriter("file.txt"));
            int counter = 0;
            while (input.hasNext()) {
                String a = input.nextLine();
                output.write(b.translate(a) + "\n");
                counter += a.split(" ").length;
            }
            System.out.println("Done! Total words translated: " + counter);
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}