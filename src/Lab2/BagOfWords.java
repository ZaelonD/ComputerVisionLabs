package Lab2;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.List;

/**
 * 1. Детектирование ключевых точек на изображении.
 * 2. Построение описания (дескрипторов) локальных окрестностей ключевых точек.
 * 3. Кластеризация дескрипторов ключевых точек, принадлежащих всем
 * объектам обучающей выборки. Это соответствует построению словаря,
 * «словами» в котором являются центроиды построенных кластеров.
 * 4. Построение описания каждого изображения в виде нормированной
 * гистограммы встречаемости «слов». Для каждого кластера вычисляется
 * количество отнесенных к нему ключевых точек, принадлежащих
 * определенному изображению.
 * 5. Построение классификатора, использующего вычисленное на шаге 4
 * признаковое описание изображения.
 */

public class BagOfWords {
    private final TrainingSample trainingSample;
    private final TestSample testSample;

    public BagOfWords(InputData data) {
        this.trainingSample = data.getTrainingSample();
        this.testSample = data.getTestSample();
    }

    public void runAlgorithmForTrainingSample() {
        detectKeyPoints(trainingSample); // Детектирование ключевых точек на изображении
        calculateDescriptors(trainingSample); // Вычисление дескрипторов
    }

    public void runAlgorithmForTestSample() {
        detectKeyPoints(testSample); // Детектирование ключевых точек на изображении
        calculateDescriptors(testSample); // Вычисление дескрипторов
    }

    private void detectKeyPoints(Sample sample) {
        var fd = FeatureDetector.create(FeatureDetector.ORB);
        for (Image image : sample.getSample()) {
            var kp = new MatOfKeyPoint();
            fd.detect(image.getGrayImage(), kp);
            image.setMatOfKeyPoint(kp);
        }
    }

    private void calculateDescriptors(Sample sample) {
        var dExtractor = DescriptorExtractor.create(DescriptorExtractor.ORB);
        for (Image image : sample.getSample()) {
            var descriptors_ORB = new Mat();
            dExtractor.compute(image.getInputImage(), image.getMatOfKeyPoint(), descriptors_ORB);
            image.setDescriptors(descriptors_ORB);
        }
    }
}