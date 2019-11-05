package Task_4.Models;

import Task_4.Math.Vector3;
import Task_4.ThirdDimension.IModel;
import Task_4.ThirdDimension.PolyLine3D;

import java.util.ArrayList;
import java.util.List;

public class Line3D implements IModel {
    Vector3 p1,p2;

    public Line3D(Vector3 pointFrom, Vector3 pointTo) {
        this.p1 = pointFrom;
        this.p2 = pointTo;
    }

    @Override
    public List<PolyLine3D> getLines() {
        List<Vector3> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        PolyLine3D pl = new PolyLine3D(points);

        ArrayList<PolyLine3D> r = new ArrayList<>();
        r.add(pl);
        return r;
//        return new ArrayList<>(new PolyLine3D(points)[]);
    }
}
