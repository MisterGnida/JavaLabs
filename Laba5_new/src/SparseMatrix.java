import java.util.*;

public class SparseMatrix implements IMatrix<SparseMatrix> {
    LinkedList<Integer> listMatrix;
    int[][] spMatrix;
    protected int size = 10;
    Element head;

    public SparseMatrix() {
        this.listMatrix = new LinkedList<>();
        this.spMatrix = new int[this.size][this.size];
        head = new Element(0, 0, 0);
    }

    public void fillSparseMatrix() {
        int number;
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                number = randomList();
                this.setElement(i, j, number);
            }
        }

        int col;
        for (int i = 0; i < this.size; ++i) {
            col = randomList();
            this.setElement(i, col, 0);
        }

        this.arrayToList();

    }

    public void arrayToList(){
        int row = 0;
        int column = 0;
        for (int i = 0; i < this.size * this.size; ++i) {
            if (column == this.size) {
                column = 0;
                ++row;
            }

            head.setValues(i, this.getElement(row, column));
            ++column;
        }

        int counterValues = 0;
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                if (head.allValues[counterValues] != 0) {
                    listMatrix.add(head.allValues[counterValues]);
                }
                ++counterValues;
            }
        }
    }

    public int randomList() {
        return (int) ((Math.random() * (size - 1)) + 1);
    }

    @Override
    public SparseMatrix sum(SparseMatrix x) {
        SparseMatrix tempMatrix = new SparseMatrix();

        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                tempMatrix.spMatrix[i][j] = this.spMatrix[i][j] + x.spMatrix[i][j];
            }
        }
        tempMatrix.arrayToList();

        return tempMatrix;
    }

    @Override
    public SparseMatrix product(SparseMatrix x) {
        SparseMatrix matrix = new SparseMatrix();

        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.size; ++j) {
                for (int k = 0; k < this.size; ++k) {
                    matrix.spMatrix[i][j] += this.spMatrix[i][k] * x.spMatrix[k][j];
                }
            }
        }
        matrix.arrayToList();

        return matrix;
    }

    @Override
    public void setElement(int row, int column, int value) {
        this.spMatrix[row][column] = value;
    }

    @Override
    public int getElement(int row, int column){
        return this.spMatrix[row][column];
    }

    public String toStringList() {
        return listMatrix.toString();
    }

    public String toStringMatrix() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                sb.append(this.spMatrix[i][j]);
                sb.append('\t');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

}
