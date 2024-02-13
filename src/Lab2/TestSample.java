package Lab2;

import java.util.ArrayList;
import java.util.List;

public class TestSample implements Sample {
    private final List<Image> testSample;

    public TestSample() {
        this.testSample = new ArrayList<>();
    }

    public List<Image> getTestSample() {
        return testSample;
    }

    @Override
    public void addImage(Image image) {
        testSample.add(image);
    }
}
