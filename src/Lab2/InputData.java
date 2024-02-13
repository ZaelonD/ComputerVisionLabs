package Lab2;

import java.io.File;
import java.util.*;

public class InputData {

    private final TestSample testSample;
    private final TrainingSample trainingSample;

    public InputData() {
        this.testSample = new TestSample();
        this.trainingSample = new TrainingSample();
        insert();
    }

    private void insert() {
        for (String dirPath : Directory.dirList) {
            File folder = new File(dirPath);
            sortByLists(folder);
        }
    }

    private void sortByLists(File folder) {
        if (folder.isDirectory())
            switch (folder.getName()) {
                case "test_sample":
                    fill(folder, testSample);
                    break;
                case "training_sample":
                    fill(folder, trainingSample);
                    break;
            }
        else
            System.err.println("Введите корректные данные");
    }

    private void fill(File folder, Sample sample) {
        for (File file : Objects.requireNonNull(folder.listFiles()))
            sample.addImage(new Image(file.getPath()));
    }

    public TestSample getTestSample() {
        return testSample;
    }

    public TrainingSample getTrainingSample() {
        return trainingSample;
    }
}