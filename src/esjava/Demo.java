package esjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;
public class Demo {
	public static void main(String[] args){
		int nthread = 0;
		int nMax = 0;
		int nmin = 0;
		int timer = 0;
		//Instanza BufferReader
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		//Instanza dei due semafori
		Semaphore pittore = new Semaphore(1);
		Semaphore sedie = new Semaphore(4);
		//Richiesta del Massimo e Minimo nella sleep
		try {
			System.out.println("\nInserisci tempo MAX: ");
			nMax=Integer.parseInt(keyboard.readLine());
			System.out.println("\nInserisci tempo min: ");
			nmin=Integer.parseInt(keyboard.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//Richiesta del numero di clienti
		try {
			System.out.println("\nInserisci numero clienti: ");
			nthread=Integer.parseInt(keyboard.readLine());
			System.out.println("\nInserisci tempo in wait in millisecondi: ");
			timer=Integer.parseInt(keyboard.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//Istanze dei Thread e Avvio dei Thread
		
		for(int i=0;i<nthread;i++) {
			Cliente  p = new Cliente(sedie,pittore,timer,nMax,nmin,i);
			p.start();
		}
	}
}
