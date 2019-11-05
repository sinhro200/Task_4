package Task_4.AVT;

import Task_4.Math.Matrix4;
import Task_4.Math.Vector3;
import Task_4.Models.Line3D;
import Task_4.ScreenConverter;
import Task_4.ScreenPoint;
import Task_4.ThirdDimension.Camera;
import Task_4.ThirdDimension.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
    private ScreenConverter sc;
    private Camera cam;
    private Scene scene;

    public DrawPanel(){
        super();
        sc = new ScreenConverter(
                -2,2,4,4,500,500
        );
        cam = new Camera();
        scene = new Scene();

        scene.models.add(
                new Line3D(
                        new Vector3(0,0,0),
                        new Vector3(1,0,0)
                )
        );
        scene.models.add(
                new Line3D(
                        new Vector3(0,0,0),
                        new Vector3(0,1,0)
                )
        );
        scene.models.add(
                new Line3D(
                        new Vector3(0,0,0),
                        new Vector3(0,0,1)
                )
        );
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private ScreenPoint last = null;

    @Override
    public void paint(Graphics g) {
        g.drawImage(scene.drawScene(sc,cam),0,0,null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        last = new ScreenPoint(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        last = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ScreenPoint np = new ScreenPoint(e.getX(),e.getY());
        if (last!= null) {
            int dx = np.getI()-last.getI();
            int dy = np.getJ()- last.getJ();

            double ax = dx*Math.PI/180;
            double ay = dy*Math.PI/180;

            cam.rotate = Matrix4.rotate(ay,1)
                    .mul(Matrix4.rotate(ax,0)
                        .mul(cam.rotate)
                     );
        }
        last = np;

        repaint();
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
