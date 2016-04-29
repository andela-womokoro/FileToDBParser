package checkpoint.andela.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class DbWriterTest {
    public DbWriter instance;
    
    @Before
    public void setUp() {
        instance = new DbWriter("DbWriterTestThread");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of run method, of class DbWriter.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Thread testThread = new Thread(instance);
        testThread.start();
    }

    /**
     * Test of readFromBuffer method, of class DbWriter.
     */
    @Test
    public void testReadFromBuffer() {
        System.out.println("readFromBuffer");
        assertTrue(instance.readFromBuffer());
    }

    /**
     * Test of writeToDb method, of class DbWriter.
     */
    @Test
    public void testWriteToDb() {
        System.out.println("writeToDb");
        assertTrue(instance.writeToDb());
    }   
}
