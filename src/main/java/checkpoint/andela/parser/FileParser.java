package checkpoint.andela.parser;

//import checkpoint.andela.log.LogWriter;

/**
 *
 * @author Wilson Omokoro
 */
public class FileParser implements Runnable {
    private String threadName;
    
    public FileParser(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        
    }
    
    public boolean readFromFile(String fileName) {
        return true;
    }
    
    public boolean writeToBuffer() {
        return true;
    }
}
