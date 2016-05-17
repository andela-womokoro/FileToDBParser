package checkpoint.andela.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class FileParserTest {
    public FileParser instance;
    
    @Before
    public void setUp() {
        instance = new FileParser("FileParserTestThread");
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of run method, of class FileParser.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Thread testThread = new Thread(instance);
        testThread.start();
    }

    /**
     * Test of readFromFile method, of class FileParser.
     */
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        assertTrue(instance.readFromFile());
    }

    /**
     * Test of writeToBuffer method, of class FileParser.
     */
    @Test
    public void testWriteToBuffer() {
        System.out.println("writeToBuffer");
        boolean readFromFile = instance.readFromFile();
        
        if(readFromFile) {
            assertTrue(instance.writeToBuffer());
        }
    }
}
