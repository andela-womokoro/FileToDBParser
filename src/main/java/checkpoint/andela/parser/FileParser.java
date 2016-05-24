package checkpoint.andela.parser;

//import checkpoint.andela.log.LogWriter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 *
 * @author Wilson Omokoro
 */
public class FileParser implements Runnable {
    private final String threadName;
    private final String fileName = "temp.txt";
    public static RandomAccessFile inputFile = null;
    public static FileChannel inChannel = null;
    public static ByteBuffer buf = null;
    public static int bytesWritten;
    
    public FileParser(String name){
       threadName = name;
       System.out.println("Creating " +  threadName);
    }
    
    @Override
    public void run() {
        boolean fileReadSuccessful = readFromFile();
        
        if(fileReadSuccessful) {
            boolean bufferWriteSuccessful = writeToBuffer();
            
            if(bufferWriteSuccessful) {
                System.out.println(threadName +" wrote " + bytesWritten +" bytes from input file to buffer.");
            }
        }
        
        if(inputFile != null) {
            try {
                inputFile.close();
            } catch (IOException ioe) {
                System.out.println("IOException, run method, FileParser.java, while closing inputFile: "+ ioe);
            }
        }
        
        //generate action log at this point...
    }
    
    public boolean readFromFile() {
        boolean fileWasRead = false;
        
        try {
            System.out.println(threadName +" is reading input file ("+fileName+")...");
            inputFile = new RandomAccessFile(fileName, "r");
            
            fileWasRead = true;
        }
        catch(IOException ioe) {
            System.out.println("IOException, readFromFile method, FileParser.java: "+ ioe);
        }
        
        return fileWasRead;
    }
    
    public boolean writeToBuffer() {
        boolean wroteToBuffer = false;
        
        try {
            buf = ByteBuffer.allocate((int) inputFile.length()); //sets the buffer capacity to length of file
            inChannel = inputFile.getChannel();
            bytesWritten = inChannel.read(buf); //reads (i.e. writes) the file's content into the buffer.
            
            wroteToBuffer = true;
        } 
        catch (IOException ioe) {
            System.out.println("IOException, writeToBuffer method, FileParser.java: "+ ioe);
        }
        
        return wroteToBuffer;
    }
}
