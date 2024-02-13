package Lab2;

import java.util.ArrayList;
import java.util.List;

public class TrainingSample implements Sample {
    private final List<Image> trainingSample;

    public TrainingSample() {
        this.trainingSample = new ArrayList<>();
    }

    @Override
    public void addImage(Image image) {
        trainingSample.add(image);
    }

    @Override
    public List<Image> getSample() {
        return trainingSample;
    }
}
