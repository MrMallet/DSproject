package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class VigenereRequestHandler {
	private int MaximumNoOfRequests = 10;
	private BlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(MaximumNoOfRequests);
	private Map<Long,String> out = new ConcurrentHashMap<Long, String>();
	
	
	public void add (final Request r){
		try{
			//blocks if queue is full
			new Thread(new Runnable(){
				public void run(){
					try{
						queue.put(r);
						out.put(r.getJobNumber(), r.getCypherText());
						
						
					}catch(Exception e){
						
					}
				}
			}).start();
			
		}catch (Exception e){
			
		}
	}
	
	public String getResult(long jobNumber){
		if (out.containsKey(jobNumber)) {
			return out.get(jobNumber);	
		}else{
			return null;//no result
		}
	}
	//stop it going to sleep use for both 

		
}
