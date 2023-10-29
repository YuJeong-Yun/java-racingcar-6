package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class MoveCnt {
    private int moveCnt;

    public MoveCnt() {
    }

    public MoveCnt(String moveCnt) {
        validateMoveCnt(moveCnt);
        this.moveCnt = Integer.parseInt(moveCnt);
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public void validateMoveCnt(String str) {
        if (str.length() == 0 || str == null) { // null 또는 공백 입력할 경우 예외 발생
            throw new IllegalArgumentException(ErrorMessage.MOVE_CNT_BLANK_ERR_MESSAGE);
        }
        if (isNotNumber(str)) { // 숫자 아니면 예외 발생
            throw new IllegalArgumentException(ErrorMessage.MOVE_CNT_NOT_NUMBER_ERR_MESSAGE);
        }
        if (Integer.parseInt(str) < 0) { // 음수이면 예외 발생
            throw new IllegalArgumentException(ErrorMessage.MOVE_CNT_NEGATIVE_ERR_MESSAGE);
        }
    }

    public boolean isNotNumber(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}