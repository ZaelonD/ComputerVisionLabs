import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageBinarization {
    private static final double THRESH = 64.0; // Пороговое значение
    public static final double MAX_BINARY_VALUE = 255.0; // Максимальное значение яркости пикселя
    public static final double MIN_BINARY_VALUE = 0.0; // Максимальное значение яркости пикселя
    public static final int THRESHOLD_TYPE = 0; // Тип порога бинаризации
    private Mat dst; // Матрица для бинарного изображения

    // Метод пороговой бинаризации изображения
    public Mat binarizeWithThresholdCustom(Mat grayImage) {
        dst = new Mat(grayImage.size(), grayImage.type());
//        Imgproc.threshold(grayImage, dst, THRESH, MAX_BINARY_VALUE, THRESHOLD_TYPE);
        for (int y = 0; y < grayImage.rows(); y++) {
            for (int x = 0; x < grayImage.cols(); x++) {
                if (grayImage.get(y, x)[0] >= THRESH)
                    dst.put(y, x, MAX_BINARY_VALUE);
                else
                    dst.put(y, x, MIN_BINARY_VALUE);
            }
        }
        return dst;
    }

    public Mat getDst() {
        return dst;
    }
}