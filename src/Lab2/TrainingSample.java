package Lab2;

import java.util.ArrayList;
import java.util.List;

public class TrainingSample implements Sample{
    private final List<Image> trainingSample;

    public TrainingSample() {
        this.trainingSample = new ArrayList<>();
    }

    public List<Image> getTrainingSample() {
        return trainingSample;
    }

    @Override
    public void addImage(Image image) {
        trainingSample.add(image);
    }
}
