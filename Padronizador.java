package PBL2;


import java.util.Random;
import java.util.concurrent.Semaphore;

public class Padronizador extends Thread {
    /*
    1. Espera um novo texto ser disponibilizado pelo Gerador
    2. Gera uma nova versão do texto com todas as letras em maiúsculo (converte as minúsculas em maiúsculas)
    3. Sinaliza o Contador (por meio de semáforo) que um novo texto está disponível
    */
    static String txt;
    public int[] x;
    Semaphore semaforo2;
    public Padronizador(int[] x, Semaphore semaforo2 ) {
        this.x = x;
        this.semaforo2 = semaforo2;

    }

    public static String getTxt() {
        return txt;
    }

    public static void setTxt(String txt) {
        Padronizador.txt = txt;
    }


    public void run() {
        Semaphore semaforo3 = new Semaphore(0);

        Contador     t3 = new Contador    (x, semaforo3);




        try {
            semaforo2.release();
            setTxt(txt=Gerador.getTring());
            txt=txt.toUpperCase();
            System.out.print("String padronizada:"+ txt+"\n");
            semaforo2.acquire();
            t3.start();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
