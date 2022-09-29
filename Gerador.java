package PBL2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Gerador extends Thread {

    //  1. Gera um texto aleatório contendo 10 letras, incluindo minúsculas e maiúsculas
    //  2. Sinaliza o Padronizador (por meio de semáforo) que um novo texto está disponível

    static String tring;
    int[] x;
    Semaphore semaforo1;

    public Gerador(int[] x, Semaphore semaforo1) {
        this.x = x;
        this.semaforo1 = semaforo1;
    }



    public static String getTring() {
        return tring;
    }


    public void run() {
        Semaphore semaforo2 = new Semaphore(0);

        Padronizador t2 = new Padronizador(x, semaforo2);



        try {
            semaforo1.release();
            Random random = new Random();

            String alfabeto = "abcdefghijklmnopqrstuvwxyz";

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {

                int index = random.nextInt(alfabeto.length());

                char randomChar = alfabeto.charAt(index);

                String maiuscula = Character.toString(randomChar);

                if ((index % 2) == 0) {
                    maiuscula = maiuscula.toUpperCase();
                }

                sb.append(maiuscula);


            }
            tring = sb.toString();
            t2.start();
            System.out.print("String aleatória:"+ tring+"\n");


        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
