package com.mycompany.sistemasapprf;

/**
 *
 * @author mikragor
 */
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class SistemasAppRF {

    public static void main(String[] args) {
        
        String imagen = "imagenes/imagen.png";
        Mat src = Imgcodecs.imread(imagen);

        String xml = "xml/lbpcascade_frontalface_improved.xml";
        CascadeClassifier cc = new CascadeClassifier(xml);

        MatOfRect detectarCara = new MatOfRect();
        cc.detectMultiScale(src, detectarCara);
        System.out.println(String.format("Detectadas caras: %d", detectarCara.toArray().length));

        for (Rect rect : detectarCara.toArray()) {
            Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 3);
        }

        Imgcodecs.imwrite("imagenes/imagen_out.png", src);
        System.out.println("Finalizado");
    }
}
