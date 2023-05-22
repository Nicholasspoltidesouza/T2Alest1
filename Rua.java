public class Rua {
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
}

