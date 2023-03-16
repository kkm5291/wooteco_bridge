package bridge.domain;

import static bridge.util.ErrorMessage.INVALID_INPUT_VALUE;
public class Floor {
    private static final String UP_STAIR = "U";
    private static final String DOWN_STAIR = "D";
    private final String status;

    Floor(String status) {
        this.status = status;
    }
    private boolean isNotStatus(String status) {
        return !UP_STAIR.equals(status) && !DOWN_STAIR.equals(status);
    }

    private void validateStatus(String status) {
        if (isNotStatus(status)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE.getMessage());
        }
    }

    public boolean isSafe(String input) {
        validateStatus(input);
        return this.status.equals(input);
    }



}
