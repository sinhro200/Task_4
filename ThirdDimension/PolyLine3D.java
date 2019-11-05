package Task_4.ThirdDimension;

import Task_4.Math.Vector3;

import java.util.ArrayList;
import java.util.List;

public class PolyLine3D {
    private List<Vector3> points;

    public PolyLine3D(List<Vector3> points,boolean closed) {
        this.points = new ArrayList<>(points);
        if (closed)
            this.points.add(points.get(0));
    }

    public PolyLine3D(List<Vector3> points) {
        this(points,true);
    }

    public List<Vector3> getPoints() {
        return points;
    }

    double avgZ(List<Vector3> points){
        double sum = 0;
        for (Vector3 point : points)
            sum+=point.getZ();
        if (points.get(0).equals(points.get(points.size()-1)))
            return sum/(points.size()-1);
        return sum/points.size();
    }
}
