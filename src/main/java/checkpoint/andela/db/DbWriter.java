package checkpoint.andela.db;

//import checkpoint.andela.log.LogWriter;
import checkpoint.andela.parser.FileParser;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Wilson Omokoro
 */
public class DbWriter implements Runnable {
    private final String threadName;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public DbWriter(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        readFromBuffer();
        
        
    }
    
    public boolean readFromBuffer() {
        boolean readFromBuffer = false;
        System.out.println(threadName +" is reading "+FileParser.bytesWritten+" bytes of data from the buffer...");
        
        FileParser.buf.flip();

        while(FileParser.buf.hasRemaining()) {
            System.out.print((char)FileParser.buf.get()); // read 1 byte at a time from buffer
        }
        
        readFromBuffer = true;
        FileParser.buf.clear();
            
        return readFromBuffer;
    }
    
    public boolean writeToDb() {
        /*try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/reactiondb";
            String user = "root";
            String password = "root";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT VERSION()");
            if(rs.next()){
                System.out.println("MySQL version: "+rs.getString(1));
            }
        }
        catch(Exception e){
            System.out.println("Exception, run method, DbWriter.java: "+ e);
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch(SQLException sqle){
               System.out.println("SQLException, run method, DbWriter.java: "+ sqle); 
            }
        }*/
        
        return true;
    }
}
