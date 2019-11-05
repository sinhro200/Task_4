package Task_4.Math;

public class Matrix4 {
    private double[] matrix;

    private Matrix4(double[] matrix){
        this.matrix = matrix;
    }

    public Matrix4(double[][] m){
        matrix = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i*4+j] =m[i][j];
            }
        }
    }

    public double getAt(int r,int c){
        return matrix[r*4+c];
    }

    public void setAt(int r, int c, double v){
        matrix[r*4+c] = v;
    }

    public Matrix4 mul(double num){
        double[] values = new double[16];
        for (int i = 0; i < 16; i++) {
            values[i]= this.matrix[i]*num;
        }
        return new Matrix4(values);
    }

    public Matrix4 mul(Matrix4 other){
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    m.setAt(i,j, m.getAt(i,j) +         //m.setAt(i,j, this.getAt(i,j) +
                            this.getAt(i,k)*other.getAt(k,j)
                            );
                }
            }
        }
        return m;
    }

    public Vector4 mul(Vector4 v){
        double[] arr = new double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i]+=getAt(i,j)*v.at(j);

            }
        }
        return new Vector4(arr[0],arr[1],arr[2],arr[3]);
    }

    public static Matrix4 one(){
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++) {
            m.setAt(i,i,1);
        }
        return m;
    }

    public static Matrix4 rotate(double angle, int axis){
        Matrix4 m = Matrix4.one();
        int a1 = (axis+1) % 3;
        int a2 = (axis + 2)%3;

        m.setAt(a1,a1,Math.cos(angle));
        m.setAt(a1,a2,-Math.sin(angle));
        m.setAt(a2,a1,Math.sin(angle));
        m.setAt(a2,a2,Math.cos(angle));

        return m;
    }

    public static Matrix4 zero(){
        return new Matrix4(new double[16]);
    }
}
