package checkpoint.andela.db;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wilson Omokoro
 */
public class SQLTest {
    /**
     * Test of getInsertAttributes method, of class SQL.
     */
    @Test
    public void testGetInsertAttributes() {
        System.out.println("getInsertAttributes");
        String result = SQL.getInsertAttributes();
        assertTrue(result != null);
        assertTrue(result.length() > 0);
    }

    /**
     * Test of getInsertPlaceHolders method, of class SQL.
     */
    @Test
    public void testGetInsertPlaceHolders() {
        System.out.println("getInsertPlaceHolders");
        String result = SQL.getInsertPlaceHolders();
        assertTrue(result != null);
        assertTrue(result.length() > 0);
    }

    /**
     * Test of fetchValue method, of class SQL.
     */
    @Test
    public void testFetchValue() {
        System.out.println("fetchValue");
        HashMap<String, String> record = new HashMap<>();
        record.put("Foo", "Boo");
        String expResult = "Boo";
        String result = SQL.fetchValue(record, "Foo");
        assertEquals(expResult, result);
    }
    
}
