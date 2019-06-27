public class Message {
    private int priority;
    private String content;

    /**
     * Construtor da classe Message
     * @param p Prioridade da mensagem.
     * @param c Conteúdo da menasgem.
     */
    public Message(int p, String c) {
        priority = p;
        content = c;
    }

    public String getContent() {
        return content;
    }

    public int getPriority() {
        return priority;
    }

}