package checkpoint.andela.db;

import java.util.Arrays;
import java.util.HashMap;
/**
 *
 * @author Wilson Omokoro
 */
public class SQL {
    private static final String[] insertAttributes = {"UNIQUE-ID", "TYPES", "COMMON-NAME", "ATOM-MAPPINGS", "CANNOT-BALANCE?", "CITATIONS", "COMMENT", "COMMENT-INTERNAL", "CREDITS", "DATA-SOURCE", "DBLINKS", "DELTAG0", "DOCUMENTATION", "EC-NUMBER", "ENZYMATIC-REACTION", "ENZYMES-NOT-USED",  "EQUILIBRIUM-CONSTANT", "HIDE-SLOT?", "IN-PATHWAY", "INSTANCE-NAME-TEMPLATE", "LEFT", "MEMBER-SORT-FN", "ORPHAN?", "PATHOLOGIC-NAME-MATCHER-EVIDENCE", "PATHOLOGIC-PWY-EVIDENCE", "PHYSIOLOGICALLY-RELEVANT?", "PREDECESSORS", "PRIMARIES", "REACTION-DIRECTION", "REACTION-LIST", "REGULATED-BY", "REQUIREMENTS", "RIGHT", "RXN-LOCATIONS", "SIGNAL", "SPECIES", "SPONTANEOUS?", "STD-REDUCTION-POTENTIAL", "SYNONYMS", "SYSTEMATIC-NAME", "TEMPLATE-FILE"};
    
    public static String getInsertAttributes() {
        return Arrays.toString(insertAttributes).replace('[', ' ').replace(']', ' ').trim();
    }
    
    public static String getInsertPlaceHolders() {
        String placeholders = "";
        
        for(int i = 0; i < insertAttributes.length; i++) {
            placeholders = placeholders + "?";
            if(i < (insertAttributes.length - 1)) {
               placeholders = placeholders + ", "; 
            }
        }
        return placeholders;
    }
    
    public static String fetchValue(HashMap<String, String> record, String key) {
        if (record.containsKey(key)) {
            return record.get(key);
        }
        else {
            return null;
        }
    }
}
