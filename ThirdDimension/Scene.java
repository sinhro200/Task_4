package Task_4.ThirdDimension;

import Task_4.Math.Vector3;
import Task_4.ScreenConverter;
import Task_4.ScreenPoint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class Scene {

    public List<IModel> models = new ArrayList<>();
    public BufferedImage drawScene(ScreenConverter sc, Camera c){
        BufferedImage bi = new BufferedImage(
                sc.getsW(),sc.getsH(),BufferedImage.TYPE_INT_RGB
        );

        Graphics2D g = (Graphics2D) bi.getGraphics();

        List<PolyLine3D> lines = new ArrayList<>();
        for (IModel m : models){
            for (PolyLine3D pl: m.getLines()){
                LinkedList<Vector3> cam_pl = new LinkedList<>();
                for(Vector3 v : pl.getPoints()){
                    cam_pl.add(c.m2c(v));
                }
                lines.add(new PolyLine3D(cam_pl,false));
            }
        }
        lines.sort(new Comparator<PolyLine3D>() {
            double getAverageZ(List<Vector3> points) {
                double z = 0;
                for (Vector3 point : points)
                    z += point.getZ();
                if (points.get(0).equals(points.get(points.size() - 1)))
                    return z / (points.size() - 1);
                return z / points.size();
            }

            @Override
            public int compare(PolyLine3D o1, PolyLine3D o2) {
                return (int) Math.signum(getAverageZ(o1.getPoints()) - getAverageZ(o2.getPoints()));
            }
        });

        g.setColor(Color.WHITE);
        g.fillRect(0,0,bi.getWidth(),bi.getHeight());
        g.setColor(Color.BLACK);

        for (PolyLine3D pl: lines){
            if (pl.getPoints().size()<2)
                continue;
            ScreenPoint prevP = sc.r2s(pl.getPoints().get(0));
            for (int i = 1; i < pl.getPoints().size(); i++) {
                ScreenPoint currP = sc.r2s(pl.getPoints().get(i));
                g.drawLine(prevP.getI(),prevP.getJ(),currP.getI(),currP.getJ());
                prevP = currP;
            }
        }


        g.dispose();
        return bi;
    }
}
