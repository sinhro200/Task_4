package Task_4.ThirdDimension;

import Task_4.Math.Matrix4;
import Task_4.Math.Vector3;
import Task_4.Math.Vector4;

public class Camera {
    public Matrix4 translate,rotate,scale,projection;

    public Camera() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
    }

    //model to camera
    public Vector3 m2c(Vector3 point){
        return new Vector3(
                projection.mul(
                        translate.mul(
                                scale.mul(
                                        rotate.mul(
                                                new Vector4(point,1)
                                        )
                                )
                        )
                )
        );
    }
}
