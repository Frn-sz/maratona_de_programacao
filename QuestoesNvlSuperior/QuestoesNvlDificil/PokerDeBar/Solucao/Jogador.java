public class Jogador{
    String nome;
    int fichas;
    Carta cartas[];
    boolean jogando;
    int pontos;


    public Jogador(String nome, Carta cartas[]){
        this.nome = nome;
        this.cartas = cartas;
        this.fichas = 60;
        this.jogando = true;
    }

    public void espiar(){
        this.cartas[0].print();
        this.cartas[1].print();
    }

    public boolean pagar(int aposta){
        if (this.fichas - aposta >= 0){
            this.fichas = this.fichas - aposta;
            System.out.println("O " + this.nome + " pagou a aposta e ficou com "+this.fichas+ " fichas!" );
            return true;
        }
        System.out.println("O " + this.nome + " não tem fichas pagar a aposta!");
        this.desistir();
        return false;
    }

    public int aumentar(int aposta, int aumento){
        int total = aposta + aumento;
        if (this.fichas - total >= 0){
            this.fichas -= total;
            System.out.println("O " + this.nome + " aumentou a aposta para " + total + " fichas e ficou com "+this.fichas+ " fichas!");
            return total;
        }else{
            // Fichas insuficientes
            System.out.println("O " + this.nome + " não tem fichas para aumentar a aposta");
            return -1;
        }
    }

    public void desistir(){
        System.out.println("O " + this.nome + " saiu do jogo!");
        this.jogando = false;
    }

    public int check(int valor){
        System.out.println("O " + this.nome + " abriu as apostas em "+valor+" fichas!");
        this.fichas -= valor;
        return valor;
    }


}