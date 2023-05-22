public class Rua {
    private String logradouro;
    private String nomeLogradouro;

    
    public Rua(String logradouro, String nomeLogradouro) {
        this.logradouro = logradouro;
        this.nomeLogradouro = nomeLogradouro;
    }

    private class Node{ 
        public Node prev;
        public Node next;
        public ListaSinalizacoes lista;
        public String nomeRua;
        public String idRua;
    }

    private Node header;
    private Node trailer;
    private Node current;     
    private int count;
    
    public Rua() {
       header = null;
       trailer = null;
       header.next = trailer;
       trailer.prev = header;
       count = 0;
    }

    public int compareTo(Rua element) {
        return 0;
    }
}

