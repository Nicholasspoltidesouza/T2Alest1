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
        //String ruaCMS = null;
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

    public int getMesComMaisSinalizacoes(){
        Node aux = header.next;
        int mes = 0;
        int maiorMes = 0;
        int maiorMesPos = 0;
        int mes1 = 0, mes2 = 0, mes3 = 0,mes4 = 0, mes5 = 0, mes6 = 0, mes7 = 0, mes8 = 0, mes9 = 0, mes10 = 0, mes11 = 0, mes12 = 0;
        for (int i = 0; i < count; i++) {
            mes = aux.lista.getMes(i);
            if (mes == 1){
                mes1+=1;
            }
            if (mes == 2){
                mes2+=1;
            }
            if (mes == 3){
                mes3+=1;
            }
            if (mes == 4){
                mes4+=1;
            }
            if (mes == 5){
                mes5+=1;
            }
            if (mes == 6){
                mes6+=1;
            }
            if (mes == 7){
                mes7+=1;
            }
            if (mes == 8){
                mes8+=1;
            }
            if (mes == 9){
                mes9+=1;
            }
            if (mes == 10){
                mes10+=1;
            }
            if (mes == 11){
                mes11+=1;
            }
            if (mes == 12){
                mes12+=1;
            }
            aux = aux.next;
        }
        int[] meses = new int[12];
        meses[0] = mes1;
        meses[1] = mes2;
        meses[2] = mes3;
        meses[3] = mes4;
        meses[4] = mes5;
        meses[5] = mes6;
        meses[6] = mes7;
        meses[7] = mes8;
        meses[8] = mes9;
        meses[9] = mes10;
        meses[10] = mes11;
        meses[11] = mes12;
        for (int j = 0; j < meses.length; j++){
            if (meses[j] > maiorMes){
                maiorMes = meses[j];
                maiorMesPos = j;
            }
        }
        return maiorMesPos+1;
    }
}


