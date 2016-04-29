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
        t1.start();
        
        Thread t2 = new Thread(new DbWriter("DbWriterThread"));
        t2.start();
        
        Thread t3 = new Thread(new LogWriter("LogWriterThread"));
        t3.start();
    }
}
