package PBL2;

import PBL.IMPAR_1;
import PBL.PAR_1;

import java.util.concurrent.Semaphore;

public class Inicio {
    public static void main(String[] args) {
        while (1 != 0) {
            int[] x = {10};

            Semaphore semaforo1 = new Semaphore(0);
            Gerador t1 = new Gerador(x, semaforo1);

            t1.start();

            try {

                t1.join(); // espera a thread t1 terminar


                Thread.sleep( 30);  // MUDE ESSA LINHA PARA CONTROLAR A VELOCIDADE
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}