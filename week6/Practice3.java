public class Practice3 {
    public static void main(String[] args){
        MyTree tree = new MyTree("Computers'R Us");

        MyNode c1 = tree.addNode("Sales");
        MyNode c2 = tree.addNode("Manufacturing");
        MyNode c3 = tree.addNode("R&D");
    
        MyNode cc1 = tree.addChild(c1, "US");
        MyNode cc2 = tree.addChild(c1, "International");
        MyNode cc3 = tree.addChild(c2, "Laptops");
        MyNode cc4 = tree.addChild(c2, "Desktops");

        MyNode ccc1 = tree.addChild(cc2, "Europe");
        MyNode ccc2 = tree.addChild(cc2, "Asia");
        MyNode ccc3 = tree.addChild(cc2, "Canada");

        System.out.println("[Level 0]");
        System.out.println(tree.root().element());
        System.out.println("");

        System.out.println("[Level 1]");
        System.out.println(c1.element() + ", " + c2.element() + ", " + c3.element());
        System.out.println("");

        System.out.println("[Level 2]");
        System.out.println(cc1.element() + ", " + cc2.element() + ", " + cc3.element()+ ", " + cc4.element());
        System.out.println("");

        System.out.println("[Level 3]");
        System.out.println(ccc1.element() + ", " + ccc2.element() + ", " + ccc3.element());
        System.out.println("");


        System.out.println("* Tree size = Total " + tree.size() + " Nodes");

    }
}
