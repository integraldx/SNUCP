
public class MyMatrix extends Tensor {
    int[][] value;
    int rowCount;
    int columnCount;
     MyMatrix(int[][] input) {
        value = input;
        rowCount = input.length;
        columnCount = input[0].length;
    }

    public Tensor add(Tensor t) {
        Tensor toReturn;
        if(t instanceof MyMatrix) {
            MyMatrix matrix = (MyMatrix)t;
            int[][] value = new int[rowCount][columnCount];
            for(int i = 0; i < rowCount; i++) {
                for(int j = 0; j < columnCount; j++) {
                    value[i][j] = this.value[i][j] + matrix.value[i][j];
                }

            }
            toReturn = new MyMatrix(value);
        }
        else if (t instanceof MyVector) {
            toReturn = null;

        }
        else if (t instanceof MyScalar) {
            toReturn = null;

        }
        else {
            toReturn = null;
        }

        return toReturn;
    }

    public Tensor multiply(Tensor t) {
        Tensor toReturn;
        if(t instanceof MyMatrix) {
            MyMatrix matrix = (MyMatrix)t;
            int[][] value = new int[this.rowCount][matrix.columnCount];
            if(this.columnCount != matrix.rowCount) {
                return null;
            }

            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    int mult = 0;
                    for(int k = 0; k < this.columnCount; k++) {
                        mult += value[i][k] * value[k][j];
                    }

                    value[i][j] = mult;
                }
            }

            toReturn = new MyMatrix(value);
        }
        else if (t instanceof MyVector) {
            toReturn = null;
        }
        else if (t instanceof MyScalar) {
            toReturn = null;
        }
        else {
            toReturn = null;
        }

        return toReturn;
    }

    public String toString() {
        String toReturn = "Matrix\n";
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                toReturn += value[i][j] + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}