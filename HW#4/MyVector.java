import java.util.Arrays;

public class MyVector extends Tensor {
    private MyScalar[] value;
    private int dimension;


    public MyVector(int[] input) {
        value = new MyScalar[input.length];
        dimension = input.length;
        for(int i = 0; i < dimension; i++) {
            value[i] = new MyScalar(input[i]);
        }
    }

    public MyVector(MyScalar[] input) {
        value = new MyScalar[input.length];
        dimension = input.length;
        for (int i = 0; i < dimension; i++) {
            value[i] = input[i].clone();
        }
    }



    public boolean permuteCompare(MyVector vector) {
        boolean toReturn = true;
        if (vector.dimension != this.dimension) {
            toReturn = false;
        }
        else {
            int[] first = new int[this.getDimension()];
            int[] second = new int[this.getDimension()];
            for(int i = 0; i < this.dimension; i++) {
                first[i] = this.getScalarAt(i).getValue();
                second[i] = vector.getScalarAt(i).getValue();
            }
            Arrays.sort(first);
            Arrays.sort(second);


            for(int i = 0; i < this.dimension; i++) {
                if(first[i] != second[i]) {
                    toReturn = false;
                    break;
                }
            }

        }

        return toReturn;
    }

    public Tensor add(Tensor t) {
        Tensor toReturn;

        if (t instanceof MyMatrix) {
            toReturn = null;
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyScalar[] value = new MyScalar[this.getDimension()];
            
            if(this.getDimension() != vector.getDimension()) {
                toReturn = null;
            }
            else {
                for (int i = 0; i < this.getDimension(); i++) {
                    value[i] = (MyScalar)this.getScalarAt(i).add(vector.getScalarAt(i));
                }

                toReturn = new MyVector(value);
            }
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            MyScalar[] value = new MyScalar[dimension];
            for(int i = 0; i < value.length; i++) {
                value[i] = (MyScalar)this.getScalarAt(i).multiply(scalar);
            }
            toReturn = new MyVector(value);
        }
        else {
            toReturn = null;
        }

        return toReturn;
    }

    public Tensor multiply(Tensor t) {
        Tensor toReturn;

        if (t instanceof MyMatrix) {
            toReturn = null;
        }
        else if (t instanceof MyVector) {
            MyVector vector = (MyVector)t;
            MyScalar value = new MyScalar(0);
            if(this.getDimension() != vector.getDimension()) {
                toReturn = null;
            }
            else {
                for (int i = 0; i < this.getDimension(); i++) {
                    value = (MyScalar)value.add(this.getScalarAt(i).multiply(vector.getScalarAt(i)));
                }

                toReturn = value;
            }
        }
        else if (t instanceof MyScalar) {
            MyScalar scalar = (MyScalar)t;
            MyScalar[] value = new MyScalar[this.getDimension()];

            for(int i = 0; i < value.length; i++) {
                value[i] = (MyScalar)scalar.multiply(this.getScalarAt(i));
            }

            toReturn = new MyVector(value);
        }
        else {
            toReturn = null;
        }

        return toReturn;
    }

    public String toString() {
        String toReturn = "Vector ";
        for (int i = 0; i < dimension; i++) {
            toReturn += value[i].getValue() + " ";
        }

        toReturn += "\n";
        return toReturn;
    }

    public MyScalar getScalarAt(int index) {
        return value[index].clone();
    }

    public MyScalar[] getScalars() {
        return value.clone();
    }

    public int getDimension() {
        return dimension;
    }
}