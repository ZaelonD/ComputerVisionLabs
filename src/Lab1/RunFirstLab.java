package Lab1;

public class RunFirstLab {
    public static void main(String[] args) {
        Outlining outlining1 = new Outlining("resources/image.png", "Выделение контуров");
        outlining1.selectOutline();
        Outlining outlining2 = new Outlining("resources/template_image.png", "Выделение контуров");
        outlining2.selectOutline();
        EdgeRecognition recognition = new EdgeRecognition(outlining1, outlining2);
        recognition.recognize();
    }
}