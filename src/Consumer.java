import java.util.Random;

public class Consumer extends Thread{
    private static Buffer b;

    /**
     * Inicializa um buffer para a classe Producer.
     */
    public static void atribuir(Buffer b1){
        b = b1;
    }

    /**
     * Representa o método de execução de um Consumidor, que após consumir
     * uma mensagem deve, esperar um tempo aleatório (entre 1 e 5 seg.)
     * para tentar consumir uma nova mensagem.
     */
    public void run(){
        while(true){
            b.retirar();

            try {
                Thread.sleep(getRandom(1,5)*1000);
            } catch(InterruptedException ex){ /* DO NOTHING */ }
        }
    }

    /**
     * Gera um número aleatório entre a e b.
     * 
     * @param a Limite inferior.
     * @param b Limite superior.
     * @return Valor aleatório no intervalo [a,b).
     */
    public int getRandom(int a, int b){
        return a + (new Random()).nextInt(b);
    }
}