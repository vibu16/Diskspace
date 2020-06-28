package Usage;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Space {

	public static void main(String[] args) {
		//For Windows
		File cDrive = new File("C:");
		System.out.println(String.format("Total space: %.2f GB",
		  (double)cDrive.getTotalSpace() /1073741824));
		System.out.println(String.format("Free space: %.2f GB", 
		  (double)cDrive.getFreeSpace() /1073741824));
		System.out.println(String.format("Usable space: %.2f GB", 
		  (double)cDrive.getUsableSpace() /1073741824));
		if(cDrive.getFreeSpace() /1073741824 < 150){
			System.out.println("Your Diskspace is low.");
		}else{
			System.out.println("Your Diskspace is not low.");
		}
		//For Linux
//		File root = new File("/");
//		System.out.println(String.format("Total space: %.2f GB", 
//		  (double)root.getTotalSpace() /1073741824));
//		System.out.println(String.format("Free space: %.2f GB", 
//		  (double)root.getFreeSpace() /1073741824));
//		System.out.println(String.format("Usable space: %.2f GB", 
//		  (double)root.getUsableSpace() /1073741824));
		
		//Memory Usage
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		System.out.println(String.format("Initial memory: %.2f GB", 
		  (double)memoryMXBean.getHeapMemoryUsage().getInit() /1073741824));
		System.out.println(String.format("Used heap memory: %.2f GB", 
		  (double)memoryMXBean.getHeapMemoryUsage().getUsed() /1073741824));
		System.out.println(String.format("Max heap memory: %.2f GB", 
		  (double)memoryMXBean.getHeapMemoryUsage().getMax() /1073741824));
		System.out.println(String.format("Committed memory: %.2f GB", 
		  (double)memoryMXBean.getHeapMemoryUsage().getCommitted() /1073741824));
		
		//CPU Usage
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		 
		for(Long threadID : threadMXBean.getAllThreadIds()) {
		    ThreadInfo info = threadMXBean.getThreadInfo(threadID);
		    System.out.println("Thread name: " + info.getThreadName());
		    System.out.println("Thread State: " + info.getThreadState());
		    System.out.println(String.format("CPU time: %s ns", 
		      threadMXBean.getThreadCpuTime(threadID)));
		  }

	}

}
