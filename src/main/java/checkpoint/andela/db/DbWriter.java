package checkpoint.andela.db;

//import checkpoint.andela.log.LogWriter;
import checkpoint.andela.parser.FileParser;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wilson Omokoro
 */
public class DbWriter implements Runnable {

    private final String threadName;
    Connection conn;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    private HashMap<String, String> record;

    public DbWriter(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        //test
        String[] fields = {"field1", "field2", "field3"};
        System.out.println(Arrays.toString(fields).replace('[', ' ').replace(']', ' ').trim());
        
        //prepare databases resources
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/reactiondb";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            s = conn.createStatement();
            
            String sql = "INSERT INTO reactions(field1, field2) VALUES(?, ?)";
            
            ps = conn.prepareStatement(sql);

            readFromBuffer();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception, run method, DbWriter.java: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    System.out.println("Closed rs.");
                }
                if (s != null) {
                    s.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                System.out.println(threadName + " closed all database resources.");
            } catch (SQLException sqle) {
                System.out.println("SQLException, run method, DbWriter.java: " + sqle);
            }
        }
    }

    public boolean readFromBuffer() {
        boolean readFromBuffer = false;
        System.out.println(threadName + " is reading " + FileParser.bytesWritten + " bytes of data from the buffer...");

        FileParser.buf.flip();

        char character;
        String line = "";
        boolean appendToLine = true;
        int linesCount = 1;
        int recordCount = 0;
        String[] keyValuePair;

        while (FileParser.buf.hasRemaining()) {
            character = (char) FileParser.buf.get(); // read 1 byte at a time from buffer

            if (character == '#') {
                appendToLine = false;
            }

            if (appendToLine) {
                line = line + character;
            }

            if (character == '\n') { //if end of line is reached
                if (!line.equals("")) { //if line is not empty
                    //System.out.print("line " + linesCount + "->" + line);
                    if (line.contains("//")) { //if line contains end of record marker
                        writeToDb(++recordCount); //write record's (i.e. hashmap object's) content to db
                        record = null;
                    } else if (line.contains(" - ")) {
                        keyValuePair = extractKeyAndValue(line, linesCount);
                        if (record == null) {
                            record = new HashMap<>();
                        }

                        if (record.containsKey(keyValuePair[0])) {
                            record.put(keyValuePair[0], record.get(keyValuePair[0]) + ", " + keyValuePair[1]);
                        } else {
                            record.put(keyValuePair[0], keyValuePair[1]);
                        }
                    }
                }
                line = "";
                keyValuePair = null;
                appendToLine = true;
                linesCount++;
            }
        }

        readFromBuffer = true;
        FileParser.buf.clear();

        return readFromBuffer;
    }

    public String[] extractKeyAndValue(String line, int lineNo) {
        try {
            String separator = " - ";
            int separatorIndex = line.indexOf(separator);
            String key = line.substring(0, separatorIndex);
            String value = line.substring(separatorIndex + separator.length());
            value = value.replace('\n', ' ');
            String[] keyAndValue = {key.trim(), value.trim()};
            return keyAndValue;
        } catch (Exception e) {
            System.out.println("Exception, extractKeyAndValue method, DbWriter.java: " + e);
            System.out.println("Line " + lineNo + " in the file is causing the problem:>>>" + line);
            return new String[0];
        }
    }

    public boolean writeToDb(int recordCount) {
        System.out.println(threadName + " is writing record " + recordCount + " to database...");

        /*for(Map.Entry<String, String> fileRec : record.entrySet()){
            System.out.println(fileRec.getKey() +" :: "+ fileRec.getValue());
        }*/
        
        /*try{
            
            ps.setString(1, "");
            ps.setString(2, "");
            //int rows = ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception, writeToDb method, DbWriter.java: "+ e);
        }*/
        return true;
    }
}
