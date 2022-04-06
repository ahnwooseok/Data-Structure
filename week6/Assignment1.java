public class Assignment1 {
    public static void main(String[] args){
        MyTree tree = new MyTree("Make Money Fast!");

        MyNode c1 = tree.addNode("1. Motivation");
        MyNode c2 = tree.addNode("2. Methods");
        MyNode c3 = tree.addNode("3. References");
    
        MyNode cc1 = tree.addChild(c1, "1.1 Greed");
        MyNode cc2 = tree.addChild(c1, "1.2 Avidity");
        MyNode cc3 = tree.addChild(c2, "2.1 Stock Fraud");
        MyNode cc4 = tree.addChild(c2, "2.2 Ponzi Scheme");
        MyNode cc5 = tree.addChild(c2, "2.3 Bank Robbery");

        System.out.println(tree.root().element());
        
        System.out.println(" " + c1.element());
        System.out.println("  " + cc1.element());
        System.out.println("  " + cc2.element());

        System.out.println(" " + c2.element());
        System.out.println("  " + cc3.element());
        System.out.println("  " + cc4.element());
        System.out.println("  " + cc5.element());

    }
}
