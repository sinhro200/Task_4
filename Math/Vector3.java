package Task_4.Math;

public class Vector3 {
    public double values[];

    public Vector3(double x, double y,double z) {
        values = new double[]{x,y,z};
    }


    public Vector3 add(Vector3 other){
        return new Vector3(
                this.getX()+other.getX(),this.getY()+other.getY(),this.getZ()+other.getZ()
        );
    }

    public Vector3(Vector4 v) {
        if (Math.abs(v.getW()) < 1e-12)
            this.values = new double[]{
                    v.getX(),v.getY(),v.getZ()
            };
        else
            this.values = new double[]{
                    v.getX()/v.getW(),
                    v.getY()/v.getW(),
                    v.getZ()/v.getW()
            };
    }


    public Vector3 mul(double n){
        return new Vector3(
                    getX()*n,
                getY()*n,
                getZ()*n
                );
    }

    public Vector3 normalized(){
        double len = Math.sqrt(getX()*getX()+getY()*getY()+getZ()*getZ());
        if (Math.abs(len) < 1e-15 ){
            return new Vector3(0,0,0);
        }
        return new Vector3(getX()/len,getY()/len,getZ()/len);
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

    public double at (int index){
        return values[index];
    }

    @Override
    public boolean equals(Object obj) {
        Vector3 v = (Vector3)obj;
        return v.getX() == this.getX()&&
                v.getY() == this.getY()&&
                v.getZ() == this.getZ();
    }
}
