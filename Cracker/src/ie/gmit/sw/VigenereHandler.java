package ie.gmit.sw;

import java.rmi.Naming;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import org.omg.CORBA.Request;

public class VigenereHandler implements Runnable{
	private BlockingQueue<Request> queue;
	
	public VigenereHandler(BlockingQueue<Request> q){
		this.queue = q;
	}
	
	public void run(){
		try{
			Request req = queue.take();
			VigenereBreaker vb = (VignereBreaker)Naming.lookup("cypher-service");
			String result = vb.decrypt(req.getText(), req.getKeyLen());
		}catch (Exception e){
			System.out.println(e);
		}
	}
	
	private Map<Long, String> out = new ConcurrentHashMap<Long,String>();
	
}
