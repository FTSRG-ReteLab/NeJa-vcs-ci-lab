package hu.bme.mit.train.tachograph;

package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTachograph {

    TrainTachograph t;

    @Before
    public void before() {
        t.fillData();
    }

    @Test
    public void empty(){
        Assert.assertTrue(0 < t.getCount());
    }
}
