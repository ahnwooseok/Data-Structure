public class Assignment2 {

    public static int getNum(String s){
        int idx1 = s.indexOf("(");
        int idx2 = s.indexOf(")");
        int ret =  Integer.parseInt(s.substring(idx1+1, idx2-1));
        return ret;
    }

    public static void main(String[] args){
        MyTree tree = new MyTree("cs16/");

        MyNode c1 = tree.addNode("homeworks/");
        MyNode c2 = tree.addNode("programs/");
        MyNode c3 = tree.addNode("todo.txt(1K)");

        MyNode cc1 = tree.addChild(c1, "h1c.doc(3K)");
        MyNode cc2 = tree.addChild(c1, "h1nc.doc(2K)");
        MyNode cc3 = tree.addChild(c2, "DDR.java(10K)");
        MyNode cc4 = tree.addChild(c2, "Stocks.java(25K)");
        MyNode cc5 = tree.addChild(c2, "Robot.java(20K)");


        String a = "h1c.doc(3K)";
        System.out.println(getNum(a));
        System.out.println(c1.element()+" = " + (getNum(String.valueOf(cc1.element())) + getNum(String.valueOf(cc2.element())) ) + "KB");
        System.out.println(c2.element()+" = " + (getNum(String.valueOf(cc3.element())) + getNum(String.valueOf(cc4.element()))+ getNum(String.valueOf(cc5.element())) ) + "KB");
        System.out.println(tree.root().element()+" = " + ( (getNum(String.valueOf(c3.element()))) + getNum(String.valueOf(cc1.element())) + getNum(String.valueOf(cc2.element())) + getNum(String.valueOf(cc3.element())) + getNum(String.valueOf(cc4.element()))+ getNum(String.valueOf(cc5.element())) ) + "KB");
    }


}
