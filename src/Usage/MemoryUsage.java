package Usage;

import java.io.File;

public class MemoryUsage {

	public static void main(String args[])throws Exception{  
		  Runtime r=Runtime.getRuntime();  
		  System.out.println("Total Memory: "+r.totalMemory());  
		  System.out.println("Free Memory: "+r.freeMemory());  
		  System.out.println("Maximum Memory: "+r.maxMemory());
		  System.out.println("Avalible Processor: "+r.availableProcessors());
		  //Get total free space available in a drive
		  File file = new File("C:\\"); 
          
	        double size = file.getFreeSpace() / (1024.0 * 1024 * 1024); 
	        System.out.printf( "%.3f GB\n", size);
	        
	       
		 }

}
