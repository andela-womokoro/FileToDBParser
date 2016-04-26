/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpoint.andela.parser;

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
public class FileParserTest {
    
    public FileParserTest() {
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
     * Test of run method, of class FileParser.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FileParser instance = new FileParser();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class FileParser.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        FileParser instance = new FileParser();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFromFile method, of class FileParser.
     */
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        String fileName = "";
        FileParser instance = new FileParser();
        instance.readFromFile(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeToBuffer method, of class FileParser.
     */
    @Test
    public void testWriteToBuffer() {
        System.out.println("writeToBuffer");
        FileParser instance = new FileParser();
        instance.writeToBuffer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
