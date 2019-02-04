package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        trainSensor = new TrainSensorImpl(null, null);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        Assert.assertEquals(10, trainSensor.getSpeedLimit());
    }
}
