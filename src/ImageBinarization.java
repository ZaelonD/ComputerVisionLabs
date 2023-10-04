import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageBinarization {
    private static final double THRESH = 75; // Пороговое значение
    private static final double MAX_BINARY_VALUE = 255; // Максимальное значение яркости пикселя
    private static final int THRESHOLD_TYPE = 0; // Тип порога бинаризации
    private final Mat dst = new Mat(); // Бинаризация изображения

    public Mat binarizeWithThreshold(Mat grayImage) {
        Imgproc.threshold(grayImage, dst, THRESH, MAX_BINARY_VALUE, THRESHOLD_TYPE);
        return dst;
    }

    public Mat getDst() {
        return dst;
    }
}
