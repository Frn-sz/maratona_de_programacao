public class Avl{
    public static void main(String args[]){
        Node no = new Node(5);
        no.insert(new Node(6), no);
        no.insert(new Node(7), no);
        no.print();
    }
}