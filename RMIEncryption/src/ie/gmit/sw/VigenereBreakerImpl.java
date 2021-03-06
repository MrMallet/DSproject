package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class VigenereBreakerImpl extends UnicastRemoteObject implements VigenereBreaker {

	private static final long serialVersionUID = 1L;
	private KeyEnumerator breaker;
	private static String filename; 
	
	public VigenereBreakerImpl() throws Exception {
		breaker = new KeyEnumerator(filename);
		//UnicastRemoteObject.exportObject(this);
		
	}
	
	public String decrypt(String cypherText, int maxKeyLength) throws RemoteException {
		return breaker.crackCypher(cypherText, maxKeyLength);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("starting remote service");
		
		filename =args[0];
		
		LocateRegistry.createRegistry(1099);
		
		Naming.bind("cypher-service", new VigenereBreakerImpl());
		
		System.out.println("service started...");
		
		
	}
	
}
