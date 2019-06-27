import java.util.LinkedList;
import java.util.Queue;

public class Buffer{
    @SuppressWarnings("unchecked")
    private Queue<Message>[] filas = new Queue[4];
    @SuppressWarnings("unchecked")
    private Queue<Long>[] bloqueados = new Queue[4];

    /**
     * Construtor da classe Buffer.
     */
    public Buffer(){
        for (int i = 0; i < 4; i++){
            filas[i] = new LinkedList<>();
            bloqueados[i] = new LinkedList<>();
        }
    }

    /**
     * Insere uma mensagem no buffer.
     */
    public synchronized void inserir(Message m){
        int p = m.getPriority();
        long threadID = (Thread.currentThread()).getId();
        if(filas[p].size() < 3){
            System.out.println("Thread "+threadID+" Produziu mensagem: "+m.getContent()+" de prioridade "+m.getPriority()+"\n");
            filas[p].add(m);
            notifyAll();
        } else {
            bloqueados[p].add(threadID);
            System.out.println("Thread "+threadID+" (Producer) foi bloqueada \n");
            while(filas[p].size() == 3 || bloqueados[p].peek() != threadID){
                try{ wait(); }
                catch(InterruptedException ex){}
            }
            System.out.println("Thread "+threadID+" (Producer) foi desbloqueada \n");
            bloqueados[p].remove();
            System.out.println("Thread "+threadID+" Produziu mensagem: "+m.getContent()+" de prioridade "+m.getPriority()+"\n");
            filas[p].add(m);
            notifyAll();
        }
    }

    /**
     * Retira uma mensagem do buffer.
     */
    public synchronized Message retirar(){
        Message tmp;
        long threadID = (Thread.currentThread()).getId();
        for(int i = 0; i < 4; i++){
            if(filas[i].size() > 0){
                tmp = filas[i].remove();
                System.out.println("Thread "+threadID+" Consumiu mensagem: "+tmp.getContent()+" de prioridade "+tmp.getPriority()+"\n");
                notifyAll();
                return tmp;
            }
        }
        System.out.println("Thread "+threadID+" (Consumer) foi bloqueada \n");
        int pos = -1;
        while(pos == -1){
            try{ wait(); }
            catch(InterruptedException ex){}
            pos = searchNotEmptyQueue();
        }
        System.out.println("Thread "+threadID+" (Consumer) foi desbloqueada \n");
        tmp = filas[pos].remove();
        System.out.println("Thread "+threadID+" Consumiu mensagem: "+tmp.getContent()+" de prioridade "+tmp.getPriority()+"\n");
        notifyAll();
        return tmp;
    }

    /**
     * Verifica se alguma fila de mensagens possui elementos.
     * @return Índice da fila que possui elementos. Caso todas estejam vazias,
     * retorna -1.
     */
    public int searchNotEmptyQueue(){  
        for(int i = 0; i < 4; i++){
            if(filas[i].size() > 0){
                return i;
            }
        }
        return -1;
    }
}