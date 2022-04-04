public class Main {
    public static void main(String[] args) {
        SortedIntegerList l1 = new SortedIntegerList(true);
        SortedIntegerList l2 = new SortedIntegerList(false);
        ;
        l1.add(34);
        l1.add(-1);
        l1.add(11);
        l1.add(11);
        l1.add(11);
        l1.add(11);
        l1.add(11);
        l1.add(5);
        l1.add(7);
        l1.add(90);
        l1.add(56);
        System.out.println(l1.toString("First"));
        l1.remove(5);
        l1.remove(4);
        l1.remove(-1);
        System.out.println(l1.toString("First"));
        l2.add(4);
        l2.add(1);
        l2.add(4);
        l2.add(4);
        l2.add(4);
        l2.add(4);
        l2.add(4);
        l2.add(4);

        System.out.println(l2.toString("Second"));
        System.out.println(l1.equals(l2) + "");
        /*l2.copy(l1);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l1.equals(l2)+"");
        l1.add(32);
        l1.add(-8);
        l1.add(-23);
        l1.add(65);
        System.out.println(l1.toString());
        l2 = l1.getLessThan(33);
        System.out.println(l2.toString());*/
    }
}
