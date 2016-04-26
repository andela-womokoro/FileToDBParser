package checkpoint.andela.log;

/**
 *
 * @author Wilson Omokoro
 */
public class LogWriter implements Runnable {
    
    public static String logFile = "";
    
    @Override
    public void run() {
        
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
