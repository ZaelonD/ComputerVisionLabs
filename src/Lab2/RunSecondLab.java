package Lab2;

public class RunSecondLab {
    public static void main(String[] args) {
        ImageRecognitionBasedOnSpecialPoints recognition = new ImageRecognitionBasedOnSpecialPoints("resources/lab2/training_sample/b1_word.png", "Поиск особых точек");
        recognition.recognize();
    }
}
