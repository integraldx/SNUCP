
public class MyScalar extends Tensor {
    private int value;

    public MyScalar(int input) {
        value = input;
    }

    public Tensor add(Tensor t) {
        Tensor toReturn;
        if (t instanceof MyMatrix) {
            MyMatrix matrix = (MyMatrix)t;
            MyScalar[][] values = new MyScalar[matrix.getVerticalDimension()][matrix.getHorizontalDimension()];
            
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] = (MyScalar)this.add(matrix.getScalarAt(i, j));
                }
            }

            toReturn = new MyMatrix(values);
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyScalar[] values = new MyScalar[vector.getDimension()];

            for(int i = 0; i < values.length; i++) {
                values[i] = (MyScalar)this.add(vector.getScalarAt(i));
            }

            toReturn = new MyVector(values);
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            toReturn = new MyScalar(this.getValue() + scalar.getValue());
        }
        else {
            toReturn = null;
        }
        return toReturn;
    }

    public Tensor multiply(Tensor t) {
        Tensor toReturn;

        if (t instanceof MyMatrix) {
            MyMatrix matrix = (MyMatrix)t;
            MyScalar[][] values = new MyScalar[matrix.getVerticalDimension()][matrix.getHorizontalDimension()];

            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[0].length; j++) {
                    values[i][j] = (MyScalar)this.multiply(matrix.getScalarAt(i, j));
                }
            }

            toReturn = new MyMatrix(values);
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyScalar[] values = new MyScalar[vector.getDimension()];
            
            for (int i = 0; i < values.length; i++) {
                values[i] = (MyScalar)this.multiply(vector.getScalarAt(i));
            }

            toReturn = new MyVector(values);
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            toReturn = new MyScalar(this.getValue() * scalar.getValue());
        }
        else {
            toReturn = null;
        }

        return toReturn;
    }

    public String toString() {
        return "Scalar " + value + "\n";
    }

    public int getValue() {
        return value;
    }

    public MyScalar clone() {
        return new MyScalar(value);
    }
}