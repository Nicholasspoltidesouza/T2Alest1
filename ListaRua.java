public class ListaRua {
    private class Node{ 
        public Node prev;
        public Node next;
        public ListaSinalizacoes lista;
        public String nomeRua;
        public String idRua;

        Node(String idRua, String nomeRua){
            this.idRua = idRua;
            this.nomeRua = nomeRua;
            lista = new ListaSinalizacoes();
        }
    }

    private Node header;
    private Node trailer;
    private Node current;     
    private int count;


    public void orderedAdd (String idRua, String nomeRua, Sinalizacao sinalizacao)  { 
        Node aux = containsElement(nomeRua); 
        if (aux == null) {  
            Node n = new Node(idRua, nomeRua);

            if (header.next == trailer) { 
                n.prev = header;
                n.next = trailer;
                trailer.prev = n;
                header.next = n;

            } 
            else if (nomeRua.compareTo(header.next.nomeRua)<0) { 
                n.next = header.next;
                n.prev = header;
                header.next = n;
                n.next.prev = n;
            }
            else if (nomeRua.compareTo(trailer.prev.nomeRua)>0) {
                n.next = trailer;
                n.prev = trailer.prev;
                trailer.prev.next = n;
                trailer.prev = n;
            }
            else {
                aux = header.next;
                boolean inseriu=false;
                while (aux!=trailer && !inseriu) {
                    if (nomeRua.compareTo(aux.nomeRua)<0) {
                        inseriu = true;
                        n.next = aux;
                        n.prev=aux.prev;
                        aux.prev.next = n;
                        aux.prev = n;
                    }
                    aux = aux.next;
                }
            }
            count++;
        }
    }
    
    private Node containsElement(String nomeRua) {
        Node aux = header;
        
        while (aux != trailer) {
            if (aux.nomeRua.equals(nomeRua)) {
                return aux;
            }
            aux = aux.next;
        }
        
        return null;
    } 
}

