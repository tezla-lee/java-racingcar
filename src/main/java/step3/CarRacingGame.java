package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public void play(int goNum) {
        if (goNum < 1) {
            throw new RuntimeException("최소 한 번이상 시도해야합니다.");
        }

        for (int i = 0; i < goNum; i++) {
            go();
            printDisplay();
        }
    }

    public void setCars(int num) {
        if (num < 1) {
            throw new RuntimeException("자동차 대수는 자연수이어야 합니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i < num + 1; i++) {
            cars.add(new Car(i));
        }
        this.cars = cars;
    }

    private void printDisplay() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getCarNumber()).append(": ");
            sb.append("-".repeat(car.getLocation()));
            sb.append("\n");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    private void go() {
        cars.forEach(Car::goRandomDistance);
    }
}
