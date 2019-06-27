public class Main {
    /**
     * Segundo trabalho de Sistemas Operacionais 2019/1.
     * Threads Producer-Consumer
     * 
     * Grupo:
     *     Leonardo Khoury Picoli
     *     Matheus Gomes Arante de Souza
     *     Matheus Salomão
     */
    public static void main(String[] args){
        Buffer b = new Buffer(); 
        Consumer.atribuir(b); // Atribui o mesmo buffer a classe Consumer e Producer.
        Producer.atribuir(b);

        for(int i = 0; i < 10; i++){
            Producer p = new Producer();
            p.start();
            Consumer c = new Consumer();
            c.start();
        }
    }
}