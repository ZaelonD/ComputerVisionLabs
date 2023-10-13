package Lab1;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.*;

public class Outlining {
    private Mat inputImage;
    private Mat imageWithContours;
    private final GUI gui;
    private Mat grayImage;
    private List<MatOfPoint> externalContoursList;

    static {
        // Инициализируем библиотеку openCV
        OpenCVLibrary.init();
    }

    public Outlining(String path, String title) {
        // Читаем исходное изображение
        this.inputImage = Imgcodecs.imread(path);
        // Инициализируем переменную под полутоновое изображение
        this.grayImage = new Mat();
        // Копируем исходное изображение
        this.imageWithContours = inputImage.clone();
        // Инициализируем список контуров
        this.externalContoursList = new ArrayList<>();
        // Создаем графический интерфейс для просмотра изображения
        this.gui = new GUI(title);
    }

    public Outlining(String title) {
        // Создаем графический интерфейс для просмотра изображения
        this.gui = new GUI(title);
    }

    public void selectOutline() {
        // Преобразовываем исходное изображение в полутоновое
        Imgproc.cvtColor(inputImage, grayImage, Imgproc.COLOR_BGR2GRAY);
        // Создаем объект класса Lab1.ImageBinarization
        ImageBinarization binarization = new ImageBinarization();
        // Преобразуем полутоновое изображение в бинарное
        Mat binarizedImage = binarization.binarizeWithThresholdCustom(grayImage);
        // Поиск контуров на изображении
        findExternalContours(binarizedImage);
        // Рисуем контуры на исходном изображении
        view(drawContours(externalContoursList, imageWithContours, new Scalar(255.0, 0.0, 255.0))); // Отображаем в окне
    }

    public void findExternalContours(Mat binarizedImage) {
        Imgproc.findContours(binarizedImage, externalContoursList, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
    }

    public Mat drawContours(List<MatOfPoint> list, Mat image, Scalar color) {
        Imgproc.drawContours(image, list, -1, color);
        return image;
    }

    public void view(Mat image) {
        gui.setImage(image);
    }

    public List<MatOfPoint> getExternalContoursList() {
        return externalContoursList;
    }

    public Mat getInputImage() {
        return inputImage;
    }
}