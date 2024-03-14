public class Baralho{
    Carta cartas[];
    int topo;

    public Baralho(){
        this.topo = 0;
        this.cartas = new Carta[52];
    }

    public Carta pop(){
        if (this.topo == 0){
            return null;
        }
        return this.cartas[this.topo--];
    }

    public void push(Carta carta){
        if (this.topo == 51){
        }else{
            this.topo++;
            this.cartas[this.topo] = carta;
        }
    }
}