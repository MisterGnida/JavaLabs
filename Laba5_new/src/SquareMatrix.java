public class SquareMatrix extends UsualMatrix implements IMatrix<UsualMatrix>{
    public UsualMatrix sum(UsualMatrix x){
        UsualMatrix tmpMatrix = new UsualMatrix();

        for (int row = 0; row < this.height; ++row) {
            for (int column = 0; column < this.width; ++column) {
                tmpMatrix.matrix[row][column] = this.matrix[row][column] + x.matrix[row][column];
            }
        }
        return tmpMatrix;
    }
}
