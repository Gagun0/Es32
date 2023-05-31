package esjava;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	Semaphore sedie;										//Instanza del semaforo delle sedie 
	Semaphore pittore;										//Instanza del semaforo del pittore
	long timerWait;											//Instanza del tempo che Aspetta
	long timerFinal;										//Instanza del tempo che Finale	
	int nMin,nMax; 											//Numero Massimo e Minimo del range per lo sleep
	int num;												//Numero del Thread
	
	public Cliente(Semaphore s,Semaphore p,long timfin,int nM,int nm,int i) {
		this.sedie=s;
		this.pittore=p;
		this.timerFinal=timfin;
		this.nMax=nM;
		this.nMin=nm;
		this.num=i;
		timerWait=0;
		
	}
	
	public void run() {
		while(true) {
			try {												//Sleep random in range
				int range = (nMax - nMin) + 1;     
				Thread.sleep((int)(Math.random() * range) + nMin);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				sedie.acquire();							//Acquire mutex sedie
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timerWait=System.currentTimeMillis();
			try {
				pittore.acquire();							//Acquire mutex pittore
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\nIl Trhead numero "+num+" Ha Aspettato: "+(System.currentTimeMillis()-timerWait));
			if((System.currentTimeMillis()-timerWait)<=timerFinal) {
				System.out.println("\nIl Trhead numero "+num+" è Entrato");
				try {												//Sleep random in range
					int range = (nMax - nMin) + 1;     
					Thread.sleep((int)(Math.random() * range) + nMin);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			pittore.release();
			sedie.release();
		}
	}
	
	
}

