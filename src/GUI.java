import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private final JFrame window;
    private final JLabel screen;
    private final MatOfByte buf;

    public GUI(/*Slider slider*/) {
        // Создаем окно с заголовком
        window = new JFrame("Выделение контуров");
        // Создаем подложку под изображение
        screen = new JLabel();
        // Метод для завершения программы по нажатию на крестик
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        window.setVisible(true);
        // Создаем байтовую матрицу
        this.buf = new MatOfByte();
    }

    // Метод для перерисовки изображения
    public void setImage(Mat image) {
        // Преобразуем изображение в матрицу байтов, чтобы
        // получить массив байтов (пикселей)
        Imgcodecs.imencode(".png", image, buf);
        // Преобразуем массив пикселей в объект ImageIcon, чтобы
        // отобразить изображение в окне
        ImageIcon ic = new ImageIcon(buf.toArray());
        // Добавляем изображение на подложку
        screen.setIcon(ic);
        // Добавляем подложку в окно
        window.getContentPane().add(screen);
        // Подстраиваем окно под размер изображения
        window.pack();
    }
}