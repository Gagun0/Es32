# Esercizion Numero 32

Un artista da strada esegue delle caricature e dei ritratti a carboncino. Chi vuole un ritratto si siede in una delle quattro sedie messe a disposizione e attende il suo turno per spostarsi nella zona di lavoro dove farsi fare il ritratto. Le persone intorno arrivano continuamente e guardano incuriosite, attendendo che una delle quattro sedie si liberi per potersi mettere in attesa del ritratto. Tuttavia, le persone che aspettano per troppo tempo una sedia libera (stabilire un tempo predefinito all’inizio del programma) rinunciano a farsi fare il ritratto. Simulare questa situazione utilizzando i semafori come meccanismo di sincronizzazione tra i processi. In particolare, tenere presente che:

- all’inizio non c’è nessun cliente
- i clienti arrivano in numero e a istanti di tempo casuali
- l’artista non impiega sempre lo stesso tempo per eseguire un ritratto


## TIPOLOGIA DI SINCRONIZAZZIONE
Per questo programma sono stati utilizzati rispettivamente __Due semafori__. Il primo semaforo a conteggio ha come scopo la rappresentazione delle __Sedie__, invece il secondo semaforo (mutex) è la rappresentazione del __Pittore__ che svolte il suo compito. 

## STARVATION E STALLO
All'interno del codice non è stato utilizzata nessuna tipologia di __Attesa Circolare__ eliminando quindi la possibilità che si presenti un __Deadlock__, facendo così impossibile lo stallo. Mentre la __Starvation__ risulta ovviata a causa della creazione di una __coda rappresentata dalle sedie__. 

## INQUADRAMENTO DELLA SOLUZIONE
Per rendere la simulazione tale sono è stato inserito un __mutex a conteggio__ che possa simulare le sedie, invece per il tempo di attesa dei clienti è stato utile creare un __meccanismo__ che possa __sottrarre al tempo finale__ (quindi il tempo in cui il cliente si mette in posa) il __tempo iniziale__ di arrivo e verificare che tale tempo non superi il massimo imposto. Ecco il meccanismo utilizzato nel nostro caso:

```java
if( (System.currentTimeMillis()- timerWait)<=timerFinal){
   Action();
}
