package Lab1;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

import java.util.*;

public class EdgeRecognition {
    private final Outlining outlining;
    private final Outlining outlining1;
    private final Outlining outlining2;

    public EdgeRecognition(Outlining outlining1, Outlining outlining2) {
        this.outlining = new Outlining("Распознавание контуров");
        this.outlining1 = outlining1;
        this.outlining2 = outlining2;
    }

    public void recognize() {
        Mat image = Mat.zeros(outlining1.getInputImage().size(), outlining1.getInputImage().type());
        Scalar color = new Scalar(255.0, 255.0, 0.0);
        for (MatOfPoint contour : outlining2.getExternalContoursList()) {
            draw(contour, image, color);
            color = new Scalar(0.0, 255.0, 255.0);
        }
        outlining.view(image);
    }

    private void draw(MatOfPoint contour, Mat image, Scalar color) {
        outlining.drawContours(new ArrayList<>(Collections.singletonList(outlining1.getExternalContoursList().get(getMinIndex(contour)))), image, color);
    }

    private int getMinIndex(MatOfPoint contour) {
        double value, min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < outlining1.getExternalContoursList().size(); i++) {
            value = Imgproc.matchShapes(outlining1.getExternalContoursList().get(i), contour, Imgproc.CV_CONTOURS_MATCH_I1, 0);
            if (value < min) {
                min = value;
                index = i;
            }
        }
        return index;
    }
}