import java.time.LocalDate;
import java.time.LocalDateTime;

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
     private Node current;    
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

     public int getMes(int index){
        Node aux = head;
        if (head == null) {
            return -1;
     }
     for (int i = 0; i < index; i++) {
        aux = aux.next;
     }
      return aux.element.getDataImplantacao().getMonthValue();
    }

    public LocalDateTime getDataDeImplantacao(int index){
        Node aux = head;
        if (head == null) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.element.getDataImplantacao();
    }

    public LocalDateTime getMenorData(){
        LocalDateTime menor = head.element.getDataImplantacao();
        Node aux = head.next;
        if (head == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (aux.element.getDataImplantacao().isAfter(menor)){
                menor = aux.element.getDataImplantacao();
            }
            aux = aux.next;
        }
        return menor;
    }

    public LocalDateTime getMaiorData(){
        LocalDateTime maior = head.element.getDataImplantacao();
        Node aux = head.next;
        if (head == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (aux.element.getDataImplantacao().isBefore(maior)){
                maior = aux.element.getDataImplantacao();
            }
            aux = aux.next;
        }
        return maior;
    }
    
    public void reset() { 
        current = head;
    }
    
    public Sinalizacao next() { 
        Sinalizacao numPosCurrent = null;
        if (current != null) { 
            numPosCurrent = current.element; 
            current = current.next; 
            return numPosCurrent; 
        }
        return null;
    }    

    public int size(){
        return count;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }
    

}
