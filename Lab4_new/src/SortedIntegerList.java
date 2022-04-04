import java.util.ListIterator;
import java.util.LinkedList;

public class SortedIntegerList {
    private LinkedList<Integer> list;
    private boolean isMultiSet;

    public SortedIntegerList(boolean flag) {
        isMultiSet = flag;
        list = new LinkedList<Integer>();
    }

    public void add(int value) {
        boolean flag = false;
        ListIterator<Integer> i = list.listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (value == n && !(isMultiSet)) {
                return;
            } else if (value < n) {
                i.previous();
                i.add(value);
                flag = true;
                return;
            }
        }
        if (!flag)
            list.add(value);
    }

    public void remove(int value) {
        ListIterator<Integer> i = list.listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (value == n) {
                i.remove();
                if (!isMultiSet)
                    break;
            }
        }
    }

    public void copy(SortedIntegerList o) {
        isMultiSet = o.isMultiSet;
        list.clear();
        ListIterator<Integer> i = o.list.listIterator();
        while (i.hasNext())
            list.add(i.next());
    }

    public boolean equals(SortedIntegerList o) {
        if (list.size() != o.list.size())
            return false;
        ListIterator<Integer> i1 = list.listIterator();
        ListIterator<Integer> i2 = o.list.listIterator();
        while (i1.hasNext())
            if (i1.next() != i2.next())
                return false;
        return true;
    }

    public String toString(String nameOfList) {

        StringBuilder sb = new StringBuilder();
        sb.append("List " + "\"" + nameOfList + "\"" + ": ");
        ListIterator<Integer> i = list.listIterator();
        int counter = 0;
        while (i.hasNext()) {
            if (counter != list.size()) {
                sb.append("[");
                sb.append(list.get(counter));
                sb.append("]");
                sb.append(", ");
                if (counter == (list.size() - 1)) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(";");
                }
            } else {
                break;
            }
            ++counter;
        }

        String S = sb.toString();
        return S;
    }
}
