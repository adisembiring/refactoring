

import com.refactoring.practice01.before.Parser;

import java.io.File;
import java.io.IOException;

/**
 * Created by Adi on 12/26/2014.
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        final Parser parser = new Parser(new File("E:\\Temp\\java\\ts.txt"));
        Thread t1 = createReaderThread("t1", parser);
        Thread t2 = createReaderThread("t2", parser);
        Thread t3 = createReaderThread("t3", parser);
        Thread t4 = createReaderThread("t4", parser);

        Thread w1 = createWriterThread("w1", parser);
        Thread w2 = createWriterThread("w2", parser);
        Thread w3 = createWriterThread("w3", parser);
        Thread w4 = createWriterThread("w4", parser);

        t1.start();
        t2.start();
        w1.start();
        w2.start();
        w3.start();
        t3.start();
        w4.start();
        t4.start();
    }

    private static Thread createReaderThread(String name, Parser parser) {
        return new Thread(() -> {
                try {
                    Thread.sleep(100);
                    System.out.println(name + " :" + parser.getContent());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                }
        });
    }

    private static Thread createWriterThread(String name, Parser parser) {
        return new Thread(() -> {
            try {
                Thread.sleep(100);
                parser.saveContent("Blahx blahx blahx: " + name);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
            }
        });
    }
}
