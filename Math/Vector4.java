package Task_4.Math;

public class Vector4 {
    private double values[];

    public Vector4(double x, double y,double z,double w) {
        values = new double[]{x,y,z,w};
    }

    public Vector4(double x, double y,double z) {
        values = new double[]{x,y,z,0};
    }

    public Vector4(Vector3 v,double w) {
        this(v.getX(),v.getY(),v.getZ(),w);
    }

    public Vector4(Vector3 v) {
        this(v.getX(),v.getY(),v.getZ(),0);
    }




    public Vector4 add(Vector4 other){
        return new Vector4(
                this.getX()+other.getX(),this.getY()+other.getY(),
                this.getZ()+other.getZ(),this.getW() + other.getW()
        );
    }


    public Vector4 normalized(){
        if (Math.abs(getW()) < 1e-12)
            return new Vector4(getX(),getY(),getZ());
        else
            return new Vector4(
                    getX()/getW(),
                    getY()/getW(),
                    getZ()/getW(),
                    1
            );
    }

    public Vector4 mul(double n){
        return new Vector4(
                getX()*n,
                getY()*n,
                getZ()*n,
                getW()*n
        );
    }

    public static Vector4 zero(){
        return new Vector4(0,0,0,0);
    }

    public double getX() {
        return values[0];
    }

    public double getY() {
        return values[1];
    }

    public double getZ() {
        return values[2];
    }

    public double getW() {
        return values[3];
    }



    public double at (int index){
        return values[index];
    }
}
