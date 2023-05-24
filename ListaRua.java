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
        Node aux = contains(nomeRua); 
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
        } else {
            aux.lista.add(sinalizacao);
        }
    }
    
    private Node contains(String nomeRua) {
        Node aux = header;
        
        while (aux != trailer) {
            if (aux.nomeRua.equals(nomeRua)) {
                return aux;
            }
            aux = aux.next;
        }
        
        return null;
    } 

    public void reset() {
        current = header.next;
    }

    public String next() {
        if (current != trailer) {
            String rua = current.nomeRua;
            current = current.next;
            return rua;
        }
        return null;
    }    

    public String prev() {
        if (current != header) {
            String rua = current.nomeRua;
            current = current.prev;
            return rua;
        }
        return null;
    }   

    public String getRuaComMaisSinalizacoes(){
        String ruaCMS = null;
        int maior = 0;
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.lista.size() > maior) {
                maior = aux.lista.size();
            }
        }
    }
}

