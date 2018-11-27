

public class MyMatrix extends Tensor {
    private MyScalar[][] value;
    private int rowCount;
    private int columnCount;

    MyMatrix(int[][] input) {
        value = new MyScalar[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                value[i][j] = new MyScalar(input[i][j]);
            }
        }
        rowCount = input.length;
        columnCount = input[0].length;
    }

    MyMatrix(MyScalar[][] input) {
        value = new MyScalar[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                value[i][j] = input[i][j].clone();
            }
        }

        rowCount = input.length;
        columnCount = input[0].length;
    }

    MyMatrix(MyVector[] input, boolean isRowVector) {
        if(isRowVector) {
            value = new MyScalar[input.length][input[0].getDimension()];

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].getDimension(); j++) {
                    value[i][j] = input[i].getScalarAt(j).clone();
                }
            }

            rowCount = input.length;
            columnCount = input[0].getDimension();
        }
        else {
            value = new MyScalar[input[0].getDimension()][input.length];

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].getDimension(); j++) {
                    value[j][i] = input[i].getScalarAt(j).clone();
                }
            }

            rowCount = input[0].getDimension();
            columnCount = input.length;
        }
    }

    public Tensor add(Tensor t) {
        Tensor toReturn;
        if(t instanceof MyMatrix) {
            MyMatrix matrix = (MyMatrix)t;
            MyVector[] values = new MyVector[rowCount];

            for (int i = 0; i < values.length; i++) {
                values[i] = ((MyVector)this.getRowVectorAt(i).add(matrix.getRowVectorAt(i))).clone();
            }

            toReturn = new MyMatrix(values, true);
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyVector[] values = new MyVector[rowCount];

            for (int i = 0; i < values.length; i++) {
                values[i] = ((MyVector)vector.add(this.getRowVectorAt(i))).clone();
            }

            toReturn = new MyMatrix(values, true);
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            MyScalar[][] values = new MyScalar[rowCount][columnCount];

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] = ((MyScalar)scalar.add(value[i][j])).clone();
                }
            }

            toReturn = new MyMatrix(values);
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
            MyScalar[][] values = new MyScalar[this.rowCount][matrix.columnCount];

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] = ((MyScalar)this.getRowVectorAt(i).multiply(matrix.getColumnVectorAt(j))).clone();
                }
            }

            toReturn = new MyMatrix(values);
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyScalar[] values = new MyScalar[this.getVerticalDimension()];

            for (int i = 0; i < values.length; i++) {
                values[i] = ((MyScalar)this.getRowVectorAt(i).multiply(vector)).clone();
            }

            toReturn = new MyVector(values);
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            MyScalar[][] values = new MyScalar[rowCount][columnCount];

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] = ((MyScalar)scalar.multiply(value[i][j])).clone();
                }
            }

            toReturn = new MyMatrix(values);
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
                toReturn += value[i][j].getValue() + " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    public MyScalar getScalarAt(int v, int h) {
        return value[v][h].clone();
    }

    public MyVector getRowVectorAt(int v) {
        MyScalar[] arr = new MyScalar[columnCount];
        for (int i = 0; i < columnCount; i++) {
            arr[i] = value[v][i].clone();
        }

        return new MyVector(arr);
    }

    public MyVector getColumnVectorAt(int h) {
        MyScalar[] arr = new MyScalar[rowCount];
        for (int i = 0; i < rowCount; i++) {
            arr[i] = value[i][h].clone();
        }
        return new MyVector(arr);
    }

    public int getVerticalDimension() {
        return rowCount;
    }

    public int getHorizontalDimension() {
        return columnCount;
    }
}