import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class App{
    public static void main(String args[]){
        Baralho baralho = new Baralho();

        char naipes[] = new char[4];
        naipes[0] = 'O';
        naipes[1] = 'C';
        naipes[2] = 'P';
        naipes[3] = 'E';

        String values[] = new String[13];
        values[0] = "2";
        values[1] = "3";
        values[2] = "4";
        values[3] = "5";
        values[4] = "6";
        values[5] = "7";
        values[6] = "8";
        values[7] = "9";
        values[8] = "10";
        values[9] = "J";
        values[10] = "Q";
        values[11] = "K";
        values[12] = "A";

        boolean tem =  false;

        for (int i = 0; i < 52; i++){
            tem = false;
            int n = ThreadLocalRandom.current().nextInt(0, 3 + 1);
            int v = ThreadLocalRandom.current().nextInt(0, 12 + 1);

            Carta carta = new Carta(values[v], naipes[n]);
            for (int j = 0; j < 52; j++){
                if (baralho.cartas[j] != null){
                    if (baralho.cartas[j].naipe == carta.naipe && baralho.cartas[j].value == carta.value){
                        tem = true;
                        break;
                    }

                }
            }
            if (!tem){
                baralho.push(carta);
            }else{
                --i;
            }
        }

        String jogadores[] = { "João", "Tavares", "Luís"};
        
        Carta cartasJ1[] = {baralho.pop(), baralho.pop()};
        Carta cartasJ2[] = {baralho.pop(), baralho.pop()};
        Carta cartasJ3[] = {baralho.pop(), baralho.pop()};
        Carta cartasJ4[] = {baralho.pop(), baralho.pop()};
        
        Jogador j1 = new Jogador(jogadores[0], cartasJ1);
        Jogador j2 = new Jogador(jogadores[1], cartasJ2);
        Jogador j3 = new Jogador(jogadores[2], cartasJ3);
        Jogador cleber = new Jogador("Cleber", cartasJ4);

        Jogador mesa[] = {j1, j2, j3, cleber};
        Carta globais[] = {baralho.pop(), baralho.pop(), baralho.pop(), baralho.pop(), baralho.pop()};

        int aposta = 0;
        int n = 1;

        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < 4; i++){
            mesa[i].pontos += isRoyalFlush(globais, mesa[i].cartas) ? 20 : 0;
            mesa[i].pontos += isStraightFlus(globais, mesa[i].cartas) ? 15 : 0;
            mesa[i].pontos += repeats(globais, mesa[i].cartas);
            mesa[i].pontos += cartaAlta(globais, mesa[i].cartas);
            mesa[i].pontos += sequencia(globais, mesa[i].cartas);
        }


        while (true){
            System.out.println("\n\nIniciando rodada " + n);
            System.out.println("Cartas comunitárias:");
            if (n > 1 && n < 3){
                for (int i = 0; i < 3; i++){
                    globais[i].print();
                }
            }else if( n > 1 ){
                for (int i = 0; i < n+1; i++){
                    globais[i].print();
                }
            }
            
            

            for (int i = 0; i<4; i++){
                int desistencias = 0;
                for (int j = 0; j < n; j++){
                    if (!mesa[j].jogando){
                        desistencias++;                 
                    }
                }

                if(desistencias == 3){
                    break;
                }
                
                System.out.println("Apostas: " + aposta + " fichas\n");
                
                if (mesa[i].jogando){

                    System.out.println("Vez do " + mesa[i].nome);
                     
                    if (mesa[i].nome != "Cleber"){
                        int decision = ThreadLocalRandom.current().nextInt(0, 2);
                        int value = ThreadLocalRandom.current().nextInt(1, 12);

                        if (decision == 0 && aposta > 0){
                            decision = ThreadLocalRandom.current().nextInt(1, 3);
                        }

                        if (aposta == 0){
                            aposta = mesa[i].check(value);
                        }else if (decision == 1 && aposta > 0){

                            boolean pagou = mesa[i].pagar(aposta);

                            if (pagou){
                                continue;
                            }else{
                                mesa[i].desistir();
                            }
                        }else if (decision == 2 && aposta > 0){

                            int new_aposta = mesa[i].aumentar(aposta, value);

                            if (new_aposta > 0){
                                aposta = new_aposta;
                                continue;
                            }else{
                                boolean pagou = mesa[i].pagar(aposta);
                                if (pagou){
                                    continue;
                                }else{
                                    mesa[i].desistir();
                                }
                            }
                        }else{
                            System.out.println("Pediu mesa (passou)");
                        }
                        
                    }
                    else if (mesa[i].jogando){
                        
                        if(!mesa[i].jogando){
                            scan.close();
                        }
                        System.out.println("Suas fichas: "+mesa[i].fichas);

                        System.out.print("Suas cartas: ");
                        mesa[i].espiar();

                        System.out.println("Escolha uma ação:\n[1] Pagar\n[2] Aumentar\n[3] Desistir");
                        int choice = scan.nextInt();

                        if (choice == 1){
                            mesa[i].pagar(aposta);
                        }else if (choice == 2){
                            System.out.println("Informe um valor entre 1 e 12");
                            int value = 0;

                            do{
                                value = scan.nextInt();
                            }while(value < 1 && value < 12);

                            mesa[i].aumentar(aposta, value);
                        }else{
                            mesa[i].desistir();
                        }
                    }
                }

            }

            if(n == 4){
                break;
            }

            n++;
        }

        Jogador winner = new Jogador("", null);
        for (int i = 0; i < n; i++){
            if (mesa[i].jogando){
                if(winner.pontos < mesa[i].pontos){
                    winner = mesa[i];
                }
            }
        }

        
        
        if (winner.nome == ""){
            System.out.println("Sem vencedores " + winner.nome);
        }else{
            System.out.println(winner.nome + " fez "+winner.pontos + " pontos");
            System.out.println("Vencedor " + winner.nome);
        }


    }

    public static boolean isRoyalFlush(Carta globais[], Carta jogador[]){
        Carta comb[] = new Carta[globais.length + jogador.length];
        // Copia os elementos do array globais para o array comb
        System.arraycopy(globais, 0, comb, 0, globais.length);

        // Copia os elementos do array jogador para o array comb, após os elementos de globais
        System.arraycopy(jogador, 0, comb, globais.length, jogador.length);
        
        String values[] = new String[5];
        values[0] = "10";
        values[1] = "J";
        values[2] = "Q";
        values[3] = "K";
        values[4] = "A";


        int pos[] = new int[5];

        int x = 0;
        for (int i = 0; i < comb.length; i++){
            for(int j = i+1; j < comb.length; j++){
                if(comb[i].naipe == comb[j].naipe){
                    if (x == 0){
                        pos[x] = i;
                        pos[++x] = j;
                    }else{
                        pos[x] = j;
                    }
                    if (x < 4){
                        x++;
                    }
                }
            }
        }

        int count = 0;
        System.out.print("\n");
        for (int i = 0; i < 5; i++){

            comb[pos[i]].print(); 
            if (comb[pos[i]].value == values[i]){
                count++;
            }
        }

        return count == 5;
    }

    public static boolean isStraightFlus(Carta globais[], Carta jogador[]){
        Carta comb[] = new Carta[globais.length + jogador.length];
        // Copia os elementos do array globais para o array comb
        System.arraycopy(globais, 0, comb, 0, globais.length);

        // Copia os elementos do array jogador para o array comb, após os elementos de globais
        System.arraycopy(jogador, 0, comb, globais.length, jogador.length);
        
        String values[] = new String[5];
        values[0] = "A";
        values[1] = "K";
        values[2] = "Q";
        values[3] = "J";
        values[4] = "10";

        int pos[] = new int[5];

        int x = 0;
        for (int i = 0; i < comb.length; i++){
            for(int j = i+1; j < comb.length; j++){
                if(comb[i].naipe == comb[j].naipe){
                    if (x == 0){
                        pos[x] = i;
                        pos[++x] = j;
                    }else{
                        pos[x] = j;
                    }
                    if (x < 4){
                        x++;
                    }
                }
            }
        }

        int count = 0;
        System.out.print("\n");
        for (int i = 0; i < 5; i++){

            comb[pos[i]].print(); 
            if (comb[pos[i]].value == values[i]){
                count++;
            }
        }

        return count == 5;
    }

    public static int repeats(Carta globais[], Carta jogador[]){
        Carta comb[] = new Carta[globais.length + jogador.length];
        // Copia os elementos do array globais para o array comb
        System.arraycopy(globais, 0, comb, 0, globais.length);

        // Copia os elementos do array jogador para o array comb, após os elementos de globais
        System.arraycopy(jogador, 0, comb, globais.length, jogador.length);

        int naipes = 0;
        int values = 0;
        for (int i = 0; i < comb.length; i++){
            for(int j = i+1; j < comb.length; j++){
                if(comb[i].value == comb[j].value){
                    values++;
                    break;
                }else if(comb[i].naipe == comb[j].naipe){
                    naipes++;
                    break;
                }
            }
        }

        // flush        => 10
        // full house   => 6
        // quadra       => 6
        // trinca       => 4
        // par          => 4
        // dois pares   => 4
        return (naipes+values)*2;
    }

    public static int cartaAlta(Carta globais[], Carta jogador[]){
        Carta comb[] = new Carta[globais.length + jogador.length];
        // Copia os elementos do array globais para o array comb
        System.arraycopy(globais, 0, comb, 0, globais.length);

        // Copia os elementos do array jogador para o array comb, após os elementos de globais
        System.arraycopy(jogador, 0, comb, globais.length, jogador.length);
        
        int hight = 0;
        for (int i = 0; i < comb.length; i++){
            if (hight > 11){
                break;
            }
            if(comb[i].value == "A"){
                hight = 14;
            }else if(comb[i].value == "K"){
                hight = 13;
            }else if(comb[i].value == "Q"){
                hight = 12;
            }else if(comb[i].value == "J"){
                hight = 11;
            }else{
                hight = Integer.parseInt(comb[i].value);
            }
        }
        
        return hight;
    }

    public static int sequencia(Carta globais[], Carta jogador[]){
        Carta comb[] = new Carta[globais.length + jogador.length];
        // Copia os elementos do array globais para o array comb
        System.arraycopy(globais, 0, comb, 0, globais.length);

        // Copia os elementos do array jogador para o array comb, após os elementos de globais
        System.arraycopy(jogador, 0, comb, globais.length, jogador.length);

        int count = 0;
        for (int i = 0; i < comb.length; i++){
            for(int j = i+1; j < comb.length; j++){
                if (comb[i].value.matches("-?\\d+")){
                        if(
                            comb[j].value.matches("-?\\d+")
                        ){
                            if(Integer.parseInt(comb[i].value)+1 == Integer.parseInt(comb[j].value)){
                                count++;
                                break;
                            }
                        }
                    }
                
            }
        }

        // flush        => 10
        // full house   => 6
        // quadra       => 6
        // trinca       => 4
        // par          => 4
        // dois pares   => 4
        if (count > 0){
            return count*2;
        }else{
            return 0;
        }
    }

}