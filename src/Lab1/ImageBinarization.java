package Lab1;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageBinarization {
    private static final double THRESH = 64.0; // Пороговое значение
    public static final double MAX_BINARY_VALUE = 255.0; // Максимальное значение яркости пикселя

    // Метод пороговой бинаризации изображения
    public Mat binarizeWithThresholdCustom(Mat grayImage) {
        // Матрица для бинарного изображения
        Mat dst = new Mat(grayImage.size(), grayImage.type());
        Imgproc.Canny(grayImage, dst, THRESH, MAX_BINARY_VALUE);
        return dst;
    }
}