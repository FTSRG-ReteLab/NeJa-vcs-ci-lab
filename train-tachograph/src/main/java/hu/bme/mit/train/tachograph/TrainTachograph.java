package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import javafx.geometry.Pos;

import java.util.Random;

public class Tachograph {

    private class Position{
        private int x,y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    Table<Long,Position,Double> tacho;

    Tachograph(){
        tacho = HashBasedTable.create();
    }

    public void AddElement(Double speed){
        Random random = new Random();
        tacho.put(System.currentTimeMillis(), new Position(random.nextInt(),random.nextInt()),speed);
    }
}
