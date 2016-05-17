package checkpoint.andela.db;

//import checkpoint.andela.log.LogWriter;
import checkpoint.andela.parser.FileParser;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println(threadName +" accessing FileParser bytesWritten: "+ FileParser.bytesWritten);
        
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
    }
    
    public boolean readFromBuffer() {
        //read the data from the buffer
        /*
        while (bytesWritten != -1) {
            buf.flip();

            while(buf.hasRemaining()) {
                System.out.print((char) buf.get()); // read 1 byte at a time
            }

            //buf.clear(); //make buffer ready for writing
            bytesWritten = inChannel.read(buf);
        }
        */
        
        return true;
    }
    
    public boolean writeToDb() {
        
        
        return true;
    }
}
