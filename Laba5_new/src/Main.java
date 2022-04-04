/*
Напишите интерфейс IMatrix с несколькими реализациями --- UsualMatrix и расширяющий его SquareMatrix из предыдущих заданий
и SparseMatrix для разреженных матриц. SparseMatrix должен быть реализован с помощью LinkedList
(возможно, вам потребуется создать какие-то еще дополнительные классы, которые должны быть вложенными/внутренними).
Все общие методы должны быть представлены в интерфейсе IMatrix.

Напишите программу, создающую 2 случайные матрицы размером 1000x1000 с 1000 нулевых элементов в каждой двумя способами --- с помощью обычных и разреженных матриц.
Проверьте, что сложение и умножение для разных видов матриц дает одинаковые результаты.
*/

public class Main {
    public static void main(String[] args) {
        SparseMatrix x = new SparseMatrix();
        SparseMatrix y = new SparseMatrix();

        x.fillSparseMatrix();
        y.fillSparseMatrix();
        System.out.println("X matrix toStringMatrix: \n" + x.toStringMatrix());
        System.out.println("Y matrix toStringMatrix: \n" + y.toStringMatrix());

        System.out.println("X matrix toStringList: \n" + x.toStringList());
        System.out.println("y matrix toStringList: \n" + y.toStringList());

        System.out.println("Sum of matrices toStringMatrix: \n" + x.sum(y).toStringMatrix());
        System.out.println("Sum of matrices toStringList: \n" + x.sum(y).toStringList());

        UsualMatrix mat1 = new UsualMatrix(10,10);
        UsualMatrix mat2 = new UsualMatrix(10,10);

        mat1.fillMatrix();
        mat2.fillMatrix();
        System.out.println("Matrix1 toStringUsualMatrix: \n" + mat1.toStringUsualMatrix());
        System.out.println("Matrix2 toStringUsualMatrix: \n" + mat2.toStringUsualMatrix());

        System.out.println("Matrix1 + Matrix2 toStringUsualMatrix: \n" + mat1.sum(mat2).toStringUsualMatrix());
        System.out.println("Matrix1 * Matrix2 toStringUsualMatrix: \n" + mat1.product(mat2).toStringUsualMatrix());

        System.out.println("\n\n\n\n");

        System.out.println(x.product(y).toStringMatrix());
        System.out.println(x.product(y).toStringList());
    }
}
