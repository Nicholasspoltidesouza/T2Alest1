import java.time.LocalDate;

public class ListaRua {
    private class Node{ 
        private Node prev;
        private Node next;
        private ListaSinalizacoes lista;
        private String nomeRua;
        private String idRua;

            public Node(String idRua, String nomeRua){
                this.nomeRua = nomeRua;
                lista = new ListaSinalizacoes();
                this.idRua = idRua;
            }
    }

    private Node header;
    private Node trailer;
    private Node current;     
    private int count;

    public ListaRua(){
        header = new Node(null, null);
        trailer = new Node(null, null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void orderedAdd(String idRua, String nomeRua, Sinalizacao sinalizacao) {
        Node aux = contains(nomeRua);
    
        if (aux == null) {
            Node n = new Node(idRua, nomeRua);
            n.lista.add(sinalizacao);
    
            Node current = header.next;
    
            while (current != trailer && nomeRua.compareTo(current.nomeRua) > 0) {
                current = current.next;
            }
    
            n.prev = current.prev;
            n.next = current;
            current.prev.next = n;
            current.prev = n;
    
            count++;
        } else {
            aux.lista.add(sinalizacao);
        }
    }
    
    private Node contains(String nomeRua) {
        Node aux = header.next;
        
        for (int i = 0; i < count; i++) {
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
            current = current.next;
            return current.nomeRua;
        }
        return null;
    }  

    public String prev() {
        if (current != header) {
            current = current.prev;
            return current.nomeRua;
        }
        return null;
    }  

    public String getRuaComMaisSinalizacoes(){
        Node maior = null;
        int numMaior = 0;
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.lista.size() > numMaior) {
                numMaior = aux.lista.size();
                maior = aux;
            }
            aux = aux.next;
        }
        
        return maior.nomeRua;
    }

    public int getMesComMaisSinalizacoes() {
        int[] meses = new int[12];

        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < aux.lista.size(); j++) {
                Integer mes = aux.lista.getMes(j);
                if (mes != null) {
                    meses[mes-1]++;
                }
            }
            aux = aux.next;
        }

        int maiorMes = 0;
        int maiorMesPos = 0;
        for (int k = 0; k < meses.length; k++) {
            if (meses[k] > maiorMes) {
                maiorMes = meses[k];
                maiorMesPos = k;
            }
        }

        return maiorMesPos + 1;
    }

    public int size(){
        return count;
    }

    public int getTotalSinalizacoesPorRua(String nomeRua) {
        Node aux = contains(nomeRua);
        
        if (aux != null) {
            return aux.lista.size();
        }
        
        return 0;
    }

    public LocalDate getDataRecente(String nomeRua) {
        Node aux = contains(nomeRua);
        
        if (aux != null) {
            return aux.lista.getMenorData();
        }
        
        return null;
    }

    public LocalDate getDataAntiga(String nomeRua) {
        Node aux = contains(nomeRua);
        
        if (aux != null) {
            return aux.lista.getMaiorData();
        }
        
        return null;
    }

}


