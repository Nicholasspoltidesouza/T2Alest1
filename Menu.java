import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    private Scanner in;
    private ListaRua listaRua;
    private ListaSinalizacoes lista;

    Menu(){
        in = new Scanner(System.in);
        lista = new ListaSinalizacoes();
        listaRua = new ListaRua();
    }

    public void leituraArquivo(){
        String linhas[] = new String[110000];
        int numLinhas = 0;

        Path filePath = Paths.get("dataEditado.csv");

        // Ler o arquivo
        try ( BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: ", e.getMessage());
        }

        // Mude numLinhas para algum numero pequeno para executar testes mais rapidamente.
        // Ex:
        // for (int i = 0; i < 50; i++) {
        for (int i = 0; i < numLinhas; i++) {
            String[] campos = linhas[i].split(";");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.parse(campos[0], formatter);
            int anoDataExtracao = dateTime.getYear();
            int mesDataExtracao = dateTime.getMonthValue();
            int diaDataExtracao = dateTime.getDayOfMonth();
            int horaDataExtracao = dateTime.getHour();
            int minDataExtracao = dateTime.getMinute();

            LocalDate date = null;
            String descricao = campos[1];
            String estado = campos[2];
            String complemento = campos[3];


            int anoImplantacao = 0;
            int mesImplantacao = 0;
            int diaImplantacao = 0;
            if(!campos[4].equals("")) {
                if(campos[4].contains("-"))
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                else
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                 date = LocalDate.parse(campos[4], formatter);
                anoImplantacao = date.getYear();
                mesImplantacao = date.getMonthValue();
                diaImplantacao = date.getDayOfMonth();
            }

            String logradouro = campos[5].split(" ", 2)[0];
            String nomeLog = campos[5].split(" ", 2)[1];

            double numInicial;
            if(campos[6].equals(""))
                numInicial = 0;
            else
                numInicial = Double.parseDouble(campos[6]);

            double numFinal;
            if(campos[7].equals(""))
                numFinal = 0;
            else
                numFinal = Double.parseDouble(campos[7]);

            String defronte = campos[8];
            String cruzamento = campos[9];
            String lado = campos[10];
            String fluxo = "";
            if(campos.length>=12)
                fluxo = campos[11];
            String localInstalacao = "";
            if(campos.length>=13)
                localInstalacao = campos[12];


           
            Sinalizacao sinalizacao = new Sinalizacao(numInicial, numFinal, descricao, lado, localInstalacao, date);

            listaRua.orderedAdd(logradouro,nomeLog,sinalizacao);

            lista.reset();
            listaRua.reset();
            

            System.out.println("Num inicial e final: " + numInicial + ", " + numFinal + "; "
                    + defronte + "; " + cruzamento + "; " + lado + "; " + fluxo + "; " + localInstalacao);
            System.out.println("---------------------------------------> " + i + "\n");
        }
    }

    public void menu(){
        System.out.println("------Menu De Interação------\n");
        System.out.println("0 - Fechar App");
        System.out.println("1 - Rua/Av/Trav com mais sinalizações registradas");
        System.out.println("2 - Mês que mais foram implatadas sinalizações em Rua/Av/Trav");
        System.out.println("3 - Menu de Navegação");
        System.out.println("Opção Escolhida:");
    }

    public void executa() {
        in = new Scanner(System.in);
        int opcao = -1;
        do {
            menu();
            boolean ok;
            do {
                ok = true;
                try {
                opcao = in.nextInt();
                } catch (InputMismatchException e1) {
                    in.nextLine();
                    ok = false;
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e2) {
                    in.nextLine();
                    ok = false;
                    e2.printStackTrace();
                    System.out.println("Redigite.\n");
                }
            } while (!ok);
            in.nextLine();

            switch (opcao) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nRua com mais sinalizações: " + listaRua.getRuaComMaisSinalizacoes() + "\n");
                    break;
                case 2:
                    System.out.println("\nMês em que foram mais implantadas sinalizações: " + listaRua.getMesComMaisSinalizacoes() + "\n");
                    break;
                case 3:
                    menuNavegacaoStart();
                break;
                default:
                    System.out.println("Opção inválida" + "\n");
            } 
        } while (opcao != 0);
    }

     public void menuNavegacao(){
        System.out.println("------Menu de Navegação------");
        System.out.println("nr - Próxima rua");
        System.out.println("pr - Rua anterior");
        System.out.println("exit - Voltar");
        System.out.println("Opção escolhida:");
     }

     public void menuNavegacaoStart() {
        in = new Scanner(System.in);
        String opcao = " ";
        do {
            menuNavegacao();
            boolean ok;
            do {
                ok = true;
                try {
                opcao = in.nextLine();
                } catch (InputMismatchException e1) {
                    in.nextLine();
                    ok = false;
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e2) {
                    in.nextLine();
                    ok = false;
                    e2.printStackTrace();
                    System.out.println("Redigite.\n");
                }
            } while (!ok);

            switch (opcao) {
                case "nr":
                    String nr = listaRua.next();
                    lista.reset();
                    System.out.println("\n" + nr.toString() + " Total de implantações: " + listaRua.getTotalSinalizacoesPorRua(nr) + " Primeira Implantação: " + listaRua.getDataAntiga(nr) +
                    " Ultima Implantação: " + listaRua.getDataRecente(nr) + "\n");
                    break;
                case "pr":
                    String pr = listaRua.prev();
                    lista.reset();
                    System.out.println("\n" + pr.toString() + " Total de implantações: " + listaRua.getTotalSinalizacoesPorRua(pr) + " Primeira Implantação: " + listaRua.getDataAntiga(pr) +
                    " Ultima Implantação: " + listaRua.getDataRecente(pr) + "\n");
                    break;
                case "exit":
                    executa();
                    break;
                default:
                    System.out.println("Opção inválida" + "\n");
            } 
        } while (opcao != null);
    }

}