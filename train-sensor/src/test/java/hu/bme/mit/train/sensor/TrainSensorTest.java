package hu.bme.mit.train.sensor;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainSensorImpl trainSensor;
    TrainControllerImpl trainController;
    TrainUserImpl trainUser;

    @Before
    public void before() {
        trainController = mock(TrainControllerImpl.class);
        trainUser = mock(TrainUserImpl.class);
        trainSensor = new TrainSensorImpl(trainController, trainUser);
    }

    @Test
    public void negativeSpeedLimit_alarm() {
        trainSensor.overrideSpeedLimit(-1);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void humongousSpeedLimit_alarm() {
        trainSensor.overrideSpeedLimit(501);
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void tooBigDeceleration_alarm() {
        when(trainController.getReferenceSpeed()).thenReturn(100);
        trainSensor.overrideSpeedLimit(49);
        verify(trainController, times(1)).getReferenceSpeed();
        verify(trainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void validSpeedLimit_noAlarm() {
        when(trainController.getReferenceSpeed()).thenReturn(100);
        trainSensor.overrideSpeedLimit(51);
        verify(trainController, times(1)).getReferenceSpeed();
        verify(trainUser, times(1)).setAlarmState(false);
    }
}
