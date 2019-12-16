import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Writeer {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("lotsofvalues.txt", "UTF-8");

        long count = 50 * 1000 * 1000;

        for(int i = 0; i < count; i++) {
            Random r = new Random();
            long l = r.nextLong();
            writer.println(l);
        }

        writer.close();
    }

}
