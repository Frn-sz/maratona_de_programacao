public class Carta{
    String value;
    char naipe;

    public Carta(String value, char naipe){
        this.value = value;
        this.naipe = naipe;
    }

    public void print(){
        System.out.printf("%s%c ", this.value, this.naipe);
    }
}