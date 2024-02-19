package Lab2;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

// Класс изображения
public class Image {
    private final Mat inputImage; // Исходное изображение
    private final Mat grayImage; // Черно-белое изображение
    private final String imagePath; // Название/путь файла с изображением
    private MatOfKeyPoint matOfKeyPoint; // Матрица ключевых точек изображения
    private Mat descriptors; // Матрица дескрипторов
    private ImageClass imageClass; // Класс к которому относится изображение

    public Image(String imagePath, ImageClass imageClass) {
        this.imagePath = imagePath;
        this.inputImage = Imgcodecs.imread(imagePath);
        this.grayImage = new Mat();
        Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        this.imageClass = imageClass;
    }

    public Image(String imagePath) {
        this.imagePath = imagePath;
        this.inputImage = Imgcodecs.imread(imagePath);
        this.grayImage = new Mat();
        Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY);
    }

    public String getImagePath() {
        return imagePath;
    }

    public Mat getInputImage() {
        return inputImage;
    }

    public Mat getGrayImage() {
        return grayImage;
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

    public ImageClass getImageClass() {
        return imageClass;
    }
}