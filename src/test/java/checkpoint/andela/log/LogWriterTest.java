package checkpoint.andela.log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wilson Omokoro
 */
public class LogWriterTest {
    public LogWriter instance;
    
    @Before
    public void setUp() {
        instance = new LogWriter();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of run method, of class LogWriter.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        instance.start();
    }

    /**
     * Test of writeToLog method, of class LogWriter.
     */
    @Test
    public void testWriteToLog() {
        System.out.println("writeToLog");
        assertTrue(instance.writeToLog());
    }

    /**
     * Test of readFromLog method, of class LogWriter.
     */
    @Test
    public void testReadFromLog() {
        System.out.println("readFromLog");
        assertTrue(instance.readFromLog());
    }

    /**
     * Test of writeToFile method, of class LogWriter.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        assertTrue(instance.writeToFile("someFile.txt"));
    }
}
