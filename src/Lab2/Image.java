package Lab2;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;

// Класс изображения
public class Image {
    private final String imagePath; // Название/путь файла с изображением
    private MatOfKeyPoint matOfKeyPoint; // Матрица ключевых точек изображения
    private Mat descriptors; // Матрица дескрипторов

    public Image(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public MatOfKeyPoint getMatOfKeyPoint() {
        return matOfKeyPoint;
    }

    public void setMatOfKeyPoint(MatOfKeyPoint matOfKeyPoint) {
        this.matOfKeyPoint = matOfKeyPoint;
    }

    public Mat getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(Mat descriptors) {
        this.descriptors = descriptors;
    }
}
