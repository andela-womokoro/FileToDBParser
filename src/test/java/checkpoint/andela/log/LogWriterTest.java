/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpoint.andela.log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wil
 */
public class LogWriterTest {
    
    public LogWriterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class LogWriter.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        LogWriter instance = new LogWriter();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class LogWriter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        LogWriter instance = new LogWriter();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToLog method, of class LogWriter.
     */
    @Test
    public void testWriteToLog() {
        System.out.println("writeToLog");
        LogWriter.writeToLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFromLog method, of class LogWriter.
     */
    @Test
    public void testReadFromLog() {
        System.out.println("readFromLog");
        LogWriter instance = new LogWriter();
        instance.readFromLog();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToFile method, of class LogWriter.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        LogWriter instance = new LogWriter();
        instance.writeToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
