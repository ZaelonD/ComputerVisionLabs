import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class Outlining {
    private final Mat inputImage;
    private final GUI gui;
    private final Mat grayImage;

    public Outlining(String path) {
        // Инициализируем библиотеку openCV
        OpenCVLibrary.init();
        // Читаем исходное изображение
        this.inputImage = Imgcodecs.imread(path);
        // Инициализируем переменную под полутоновое изображение
        this.grayImage = new Mat();
        // Создаем графический интерфейс для просмотра изображения
        this.gui = new GUI();
    }

    public void selectOutline() {
        // Преобразовываем исходное изображение в полутоновое
        Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        // Создаем объект класса ImageBinarization
        ImageBinarization binarization = new ImageBinarization();
        // Преобразуем полутоновое изображение в бинарное
        Mat dst = binarization.binarizeWithThresholdCustom(grayImage);
        // Ищем и отрисовываем контуры на исходном изображении
        Mat resultImage = findAndDrawContours(dst);
        // Отображаем в окне
        gui.setImage(resultImage);
    }

    public Mat findAndDrawContours(Mat dst) {
        List<MatOfPoint> list = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(dst, list, hierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        Imgproc.drawContours(inputImage, list, -1, new Scalar(255.0, 0.0, 255.0), 1, 8, hierarchy);
        return inputImage;
    }
}
