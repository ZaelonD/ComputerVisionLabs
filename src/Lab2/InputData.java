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
        for (String dirPath : Directory.DIR_LIST) {
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
                    sortByClass(folder, trainingSample);
                    break;
            }
        else
            System.err.println("Введите корректные данные");
    }

    private void sortByClass(File folder, Sample sample) {
        for (File classFolder : Objects.requireNonNull(folder.listFiles())) {
            if (classFolder.isDirectory())
                switch (classFolder.getName()) {
                    case "1Class":
                        fill(classFolder, sample, ImageClass.CLASS1);
                        break;
                    case "2Class":
                        fill(classFolder, sample, ImageClass.CLASS2);
                        break;
                }
            else
                System.err.println("Введите корректные данные");
        }
    }

    private void fill(File folder, Sample sample) {
        for (File file : Objects.requireNonNull(folder.listFiles()))
            sample.addImage(new Image(file.getPath()));
    }

    private void fill(File folder, Sample sample, ImageClass imageClass) {
        for (File file : Objects.requireNonNull(folder.listFiles()))
            sample.addImage(new Image(file.getPath(), imageClass));
    }

    public TestSample getTestSample() {
        return testSample;
    }

    public TrainingSample getTrainingSample() {
        return trainingSample;
    }
}