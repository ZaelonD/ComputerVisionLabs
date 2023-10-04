import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Outlining {
    private final Mat inputImage;
    private final GUI gui;
    private final Mat grayImage;
    private final ImageBinarization binarization;

    public Outlining(String path) {
        // Инициализируем библиотеку openCV
        OpenCVLibrary.init();
        // Читаем исходное изображение
        inputImage = Imgcodecs.imread(path);
        grayImage = new Mat();
        binarization = new ImageBinarization();
        // Преобразовываем в полутоновое изображение
        Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        // Создаем графический интерфейс для просмотра изображения
        this.gui = new GUI();
    }

    public void selectOutline() {
        Mat dst = binarization.binarizeWithThreshold(grayImage);
        gui.setImage(dst);
    }
}
