package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<Floor> floors;

    public Bridge(List<Floor> floors) {
        this.floors = floors;
    }

    private boolean isSafe(int index, String input) {
        Floor floor = floors.get(index);
        return floor.isSafe(input);
    }

    private int size() {
        return floors.size();
    }

}