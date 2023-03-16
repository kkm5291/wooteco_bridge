package bridge.domain;

import static bridge.util.ErrorMessage.INVALID_INPUT_VALUE;
public class User {

    private static final String UP_STAIR = "U";
    private static final String DOWN_STAIR = "D";
    private int step = 0;
    private boolean live = true;

    public void init() {
        this.step = 0;
        this.live = true;
    }

    public void move(Bridge bridge, String input) {
        validateStatus(input);
        if (!bridge.isSafe(step, input)) {
            live = false;
            return;
        }
        step++;
    }

    private void validateStatus(String status) {
        if (isNotStatus(status)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    private boolean isNotStatus(String status) {
        return !UP_STAIR.equals(status) && !DOWN_STAIR.equals(status);
    }

    public int getStep() {
        return this.step;
    }

    public boolean isLive() {
        return this.live;
    }
}
