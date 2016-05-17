package checkpoint.andela.log;

/**
 *
 * @author Wilson Omokoro
 */
public class LogWriter implements Runnable {
    
    public static String logFile = "";
    private final String threadName;
    
    public LogWriter(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        System.out.println("Running " +  threadName);
    }
   
    public static boolean writeToLog(){
        return true;
    }
    
    public boolean readFromLog() {
        return true;
    }
    
    public boolean writeToFile(String fileName){
        return true;
    }
}
