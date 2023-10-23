package Lab2;

import java.io.File;
import java.util.*;

public class InputData {
    private final List<String> listOfFiles;
    private final List<String> testSample;
    private final List<String> trainingSample;

    public InputData() {
        this.listOfFiles = new ArrayList<>();
        this.testSample = new ArrayList<>();
        this.trainingSample = new ArrayList<>();
        insert();
        split();
    }

    private void insert() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите папку с изображениями: ");
        File folder = new File(scanner.nextLine());
        if (folder.isDirectory())
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                listOfFiles.add(file.getName());
            }
        else {
            System.err.println("Введите корректные данные");
        }
    }

    private void split() {
        Collections.shuffle(listOfFiles);
        for (int i = 0; i < listOfFiles.size(); i++) {
            if (i < 5)
                testSample.add(listOfFiles.get(i));
            else
                trainingSample.add(listOfFiles.get(i));
        }
    }

    public List<String> getTestSample() {
        return testSample;
    }

    public List<String> getTrainingSample() {
        return trainingSample;
    }
}