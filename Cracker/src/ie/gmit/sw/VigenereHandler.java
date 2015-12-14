package ie.gmit.sw;

import java.rmi.Naming;
import java.util.*;
import java.util.concurrent.*;
import ie.gmit.sw.VigenereBreaker;

public class VigenereHandler implements Runnable{
	private BlockingQueue<Request> queue;
	private String result;
	private Request req = null;
	private Map<Long, String> outmap = new ConcurrentHashMap<Long,String>();
	
	public VigenereHandler(BlockingQueue<Request> q, Map<Long, String> out){
		this.queue = q;
		this.outmap = out;
		run();
	}
	
	public void run(){
		 
		//Request req = null; 
		try {
			req = queue.take();
		}
		
		catch(InterruptedException e1)
		{
			e1.printStackTrace();
		}
		
		try{
			//Request req = queue.take();
			VigenereBreaker vb = (VigenereBreaker) Naming.lookup("cypher-service");
			result = vb.decrypt(req.getCypherText(), req.getMaxKeySize());
			outmap.put(req.getJobNumber(), result);
			
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	
	
}
