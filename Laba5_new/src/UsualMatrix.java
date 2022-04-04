public class UsualMatrix implements IMatrix<UsualMatrix> {
    protected int[][] matrix;
    protected int height;
    protected int width;
    protected int number;

    public UsualMatrix() {
        this.height = 10;
        this.width = 10;
        this.matrix = new int[this.height][this.width];

        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                if (i == j) {
                    this.matrix[i][j] = 1;
                } else {
                    this.matrix[i][j] = 0;
                }
            }
        }
    }

    public UsualMatrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new int[this.height][this.width];
    }

    public int randomMatrix() {
        return this.number = (int) ((Math.random() * (this.height - 1)) + 1);
    }

    public void fillMatrix() {
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                this.matrix[i][j] = randomMatrix();
            }
        }

        this.insertNulls(this.height);
    }

    void insertNulls(int nulls) {
        int row = 0;
        int column = 0;
        int countNulls = nulls;

        while (countNulls != 0 && row != 9) {
            column = randomMatrix();
            this.matrix[row][column] = 0;
            --countNulls;
            ++row;
        }
    }

    @Override
    public void setElement(int row, int column, int value) {
        this.matrix[row][column] = value;
    }

    @Override
    public int getElement(int row, int column) {
        return this.matrix[row][column];
    }

    @Override
    public UsualMatrix sum(UsualMatrix x) {
        UsualMatrix tempMatrix = new UsualMatrix(this.height, x.width);

        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                tempMatrix.matrix[i][j] = this.matrix[i][j] + x.matrix[i][j];
            }
        }

        return tempMatrix;
    }

    @Override
    public UsualMatrix product(UsualMatrix x) {
        UsualMatrix tempMatrix = new UsualMatrix(this.height, this.width);

        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < x.width; ++j) {
                for (int k = 0; k < x.height; ++k) {
                    tempMatrix.matrix[i][j] += this.matrix[i][k] * x.matrix[k][j];
                }
            }
        }

        return tempMatrix;
    }

    public String toStringUsualMatrix() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.height; ++i) {
            sb.append("[ ");
            for (int j = 0; j < this.width; ++j) {
                sb.append(this.matrix[i][j] + "\t");
            }
            sb.append("]");
            sb.append('\n');
        }
        String finishedString = String.valueOf(sb);
        return finishedString;
    }
}
