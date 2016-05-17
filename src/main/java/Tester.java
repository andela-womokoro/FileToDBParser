import checkpoint.andela.db.DbWriter;
import checkpoint.andela.log.LogWriter;
import checkpoint.andela.parser.FileParser;
/**
 *
 * @author Wilson Omokoro
 */
public class Tester {
    public static void main(String[] args) {
        Thread t1 = new Thread(new FileParser("FileParserThread"));
        Thread t2 = new Thread(new DbWriter("DbWriterThread"));
        Thread t3 = new Thread(new LogWriter("LogWriterThread"));
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException, main method, Tester.java, on t1.");
        }
        
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException, main method, Tester.java, on t2.");
        }
        
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException, main method, Tester.java, on t3.");
        }
    }
}
