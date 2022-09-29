package PBL2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Contador extends Thread{
    /*
       1. Espera um novo texto ser disponibilizado pelo Padronizador
       2. Conta e imprime o número de vogais no texto
   */
    public int[] x;
    Semaphore semaforo3;

    public Contador(int[] x, Semaphore semaforo3) {
        this.x = x;
        this.semaforo3 = semaforo3;
    }


    public void run() {

        try {
            semaforo3.release(); // esperar

            String txt = Padronizador.getTxt();
            txt = txt.toUpperCase();

            int contarVogais = 0;

            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    contarVogais++;
            }
            System.out.print("Quantia de vogais na String:"+contarVogais+"\n\n");
            semaforo3.acquire();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
