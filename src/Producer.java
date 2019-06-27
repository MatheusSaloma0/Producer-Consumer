import java.util.Random;

public class Producer extends Thread{
    private static Buffer b;
    
    /**
     * Inicializa um buffer para a classe Producer.
     */
    public static void atribuir(Buffer b1){
        b = b1;
    }

    /**
     * Representa o método de execução de um Produtor, que deve produzir 
     * mensagens a cada x segundos (x é um valor aleatório entre 1 e 5). 
     * A prioridade da mensagem também é definida de forma aleatória.
     */
    public void run(){
        while(true){
            b.inserir(new Message(getRandom(0,4),genEmoji()));

            try {
                Thread.sleep(getRandom(1,5)*1000);
            } catch(InterruptedException ex) { /* DO NOTHING */ }
        }
    }

    /**
     * Gera um número aleatório entre a e b.
     * @param a Limite inferior.
     * @param b Limite superior.
     * @return Valor aleatório no intervalo [a,b).
     */
    public int getRandom(int a, int b){
        return a + (new Random()).nextInt(b);
    }

    /**
     * Gera uma mensagem aleatória dentro do vetor de Strings predeterminadas.
     */
    public String genEmoji(){
        String[] emojis = {":)",":S",":P",":(",":O",":*","*-*",";D","<3","o.O",";-;","XD",":3"};
        return emojis[getRandom(0,emojis.length)];
    }

}