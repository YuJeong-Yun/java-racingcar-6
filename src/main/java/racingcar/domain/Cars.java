package racingcar.domain;

import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars() {
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public Cars(String userInputCarName) {
        this.cars = new ArrayList<>();

        splitUserInputCarName(userInputCarName);
    }
    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    // 사용자가 입력한 자동차 이름을 쉼표(,)로 구분하여 리스트에 저장
    private void splitUserInputCarName(String userInput) {
        userInput.replaceAll(" ","");
        String[] names = userInput.split(",");
        validateDuplicate(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateDuplicate(String[] names) {
        // 중복된 자동차 이름 있으면 예외 발생
        if(names.length != Arrays.stream(names).distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE);
        }
    }
}