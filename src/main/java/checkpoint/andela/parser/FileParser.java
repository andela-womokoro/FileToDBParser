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
    private String threadName;
    private RandomAccessFile inputFile = null;
    private FileChannel inChannel = null;
    private ByteBuffer buf = null;
    private int bytesWritten;
    
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
    }
    
    public boolean readFromFile() {
        boolean fileWasRead = false;
        
        try {
            System.out.println(threadName +" is reading input file (reactions.dat)...");
            inputFile = new RandomAccessFile("reactions.dat", "r");
            
            fileWasRead = true;
            /*
            //write the file's data into the buffer.
            int bytesRead = inChannel.read(buf); 
            
            //read the data from the buffer
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();

                while(buf.hasRemaining()) {
                    System.out.print((char) buf.get()); // read 1 byte at a time
                }

                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
            */
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
            //buf.clear();
        } catch (IOException ioe) {
            System.out.println("IOException, writeToBuffer method, FileParser.java: "+ ioe);
        }
        
        return wroteToBuffer;
    }
}
