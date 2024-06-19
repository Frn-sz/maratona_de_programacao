public class Node{
    public int value;
    public Node left;
    public Node right;
    public Node dad;
    private static int h;

    public Node(){
        this.h = -1;
    }

    public Node(int value){
        this.value = value;
    }

    public void insert(Node no, Node dad){
        if (this.left == null && this.value >= no.value){
            no.dad = dad;
            this.left = no;
        }else if (this.right == null && this.value <= no.value){
            no.dad = dad;
            this.right = no;
        }else if (this.value >= no.value){
            this.left.insert(no, this.left);
            this.increment_h(no, -1);
        }else if (this.value <= no.value){
            this.right.insert(no, this.right);
            this.increment_h(no, 1);
        }
    }

    static void increment_h(Node dad, int i){
        Node.h += i;
        if (Node.h == 1){
            dad.balance_left();
        }else if(Node.h == -1){
            dad.balance_right();
        }
    }

    void balance_left(){
        Node tmp_right = this.dad;
        tmp_right.right.left = tmp_right;
        tmp_right.right = null;
    }

    void balance_right(){
        Node tmp_right = this.dad;
        tmp_right.left.right = tmp_right;
        tmp_right.left = null;
    }

    public void print(){
        if (this.left != null){
            System.out.print("<-");
            this.left.print();
        }

        System.out.print("("+this.value+")");
        
        if (this.right != null){
            System.out.print("->");
            this.right.print();
        }

    }
}