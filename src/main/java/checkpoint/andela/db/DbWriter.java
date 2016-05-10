package checkpoint.andela.db;

//import checkpoint.andela.log.LogWriter;
import java.sql.*;

/**
 *
 * @author Wilson Omokoro
 */
public class DbWriter implements Runnable {
    private String threadName;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public DbWriter(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        try{
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
        }
    }
    
    public boolean readFromBuffer() {
        return true;
    }
    
    public boolean writeToDb() {
        
        
        return true;
    }
}
