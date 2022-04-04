public interface IMatrix<T> {
    int getElement(int row, int column);

    void setElement(int row, int column, int value);

    T sum(T x);

    T product(T x);
}
