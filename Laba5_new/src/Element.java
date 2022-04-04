import java.util.*;

public class Element {
    protected int value;
    protected int indexRow;
    protected int indexColumn;
    protected int[] allValues;
    protected int size = 10;

    public Element(int row, int column, int value) {
        this.indexRow = row;
        this.indexColumn = column;
        this.value = value;
        this.allValues = new int[size * size];
    }

    public int getElement(int index){
        return this.allValues[index];
    }

    public void setValues(int index, int value) {
        this.allValues[index] = value;
        this.value = value;
    }

}
