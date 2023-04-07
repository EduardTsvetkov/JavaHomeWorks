public class App {
    public static void main(String[] args) throws Exception {


        DoubleLinked dbl = new DoubleLinked();
        for (int index = 0; index < 5; index++) {
            dbl.addLast(index);
        }

        dbl.print();
        dbl.revert();
        dbl.print();

    }
}
