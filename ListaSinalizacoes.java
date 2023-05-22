public class ListaSinalizacoes {
    private class Node{ 
        public Sinalizacao element;
        public Node next;
        public Node(Sinalizacao element) {
            this.element = element;
            next = null;
        }
    
    }

     private Node head;
     private Node tail;    
     private int count;

     public ListaSinalizacoes(){
        Node head = null;
        Node tail = null;
        int count = 0;
     }

     public void add(Sinalizacao element){
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
     }
}
