package checkpoint.andela.db;

//import checkpoint.andela.log.LogWriter;

/**
 *
 * @author Wilson Omokoro
 */
public class DbWriter implements Runnable {
    private String threadName;
    
    public DbWriter(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        
    }
    
    public boolean readFromBuffer() {
        return true;
    }
    
    public boolean writeToDb() {
        return true;
    }
}
