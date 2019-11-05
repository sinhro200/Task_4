package Task_4;

import Task_4.Math.Vector3;

public class ScreenConverter {
    private double rX,rY,rW,rH;
    private int sW,sH;

    public ScreenPoint r2s(Vector3 p){
        int i = (int) ((p.getX()-rX)*sW/rW);
        int j = (int) ((-p.getY()+rY)*sH/rH);
        return new ScreenPoint(i,j);
    }

    public Vector3 s2r(ScreenPoint sp){
        double x = sp.getI()*rW/sW+rX;
        double y = -sp.getJ()*rH/sH+rY;
        return new Vector3(x,y,1);
        /**
         * ?!?!?
         */

    }

    public ScreenConverter(double rX, double rY, double rW, double rH, int sW, int sH) {
        this.rX = rX;
        this.rY = rY;
        this.rW = rW;
        this.rH = rH;
        this.sW = sW;
        this.sH = sH;
    }

    public ScreenConverter(double rX, double rY, double rW, double rH, double sW, double sH) {
        this(rX,rY,rW,rH,(int)sW,(int)sH);
    }

    public double getrX() {
        return rX;
    }

    public boolean containsRealPoint(Vector3 vector3){
        if (vector3.getX() < rX || vector3.getX() > rX+rW)
            return false;
        if (vector3.getY() > rY || vector3.getY() < rY-rH)
            return false;
        return true;
    }

    public void setrX(double rX) {
        this.rX = rX;
    }

    public double getrY() {
        return rY;
    }

    public void setrY(double rY) {
        this.rY = rY;
    }

    public double getrW() {
        return rW;
    }

    public void setrW(double rW) {
        this.rW = rW;
    }

    public double getrH() {
        return rH;
    }

    public void setrH(double rH) {
        this.rH = rH;
    }

    public int getsW() {
        return sW;
    }

    public void setsW(int sW) {
        this.sW = sW;
    }

    public int getsH() {
        return sH;
    }

    public void setsH(int sH) {
        this.sH = sH;
    }
}
