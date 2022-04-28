public class Practice3 {
    public static void main(String[] args){
        MyBinTree t = new MyBinTree('+');

        MyBinNode b = t.inserLeft(t.root(), '*');
        MyBinNode c = t.inserRight(t.root(), '*');



        MyBinNode d = t.inserLeft(b, 2);
        MyBinNode e = t.inserRight(b, '-');

        

        MyBinNode f = t.inserLeft(c, 3);
        MyBinNode g = t.inserRight(c, 2);

        MyBinNode h = t.inserLeft(e, 3);
        MyBinNode i = t.inserRight(e, 1);

        
    
        t.inOrder(t.root());
        System.out.println();
        System.out.println("= " + t.postOrder(t, t.root()));


    }
}
