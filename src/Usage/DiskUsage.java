package Usage;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;

public class DiskUsage {

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		for (Path root : FileSystems.getDefault().getRootDirectories()) {

		   // System.out.print(root + ": \n");
		    try {
		        FileStore store = Files.getFileStore(root);
		        System.out.println(String.format("Total space: %.2f GB",
		      		  (double)store.getTotalSpace() /1073741824));
		      		System.out.println(String.format("Avalible space: %.2f GB", 
		      		  (double)store.getUsableSpace() /1073741824));	
		      		if(store.getUsableSpace() /1073741824 < 80){
		    			System.out.println("Your Diskspace is low.");
		    		}else{
		    			System.out.println("Your Diskspace is not low.");
		    		}
		    } catch (IOException e) {
		        System.out.println("error querying space: " + e.toString());
		    }
		}

	}

}
