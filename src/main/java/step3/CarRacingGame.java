package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CarRacingGame {

    private final List<Car> cars;

    public CarRacingGame(String names) {
        String[] carNames = names.split(",");
        this.cars = toCars(carNames);
    }

    private List<Car> toCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNames)
                .map(String::trim)
                .map(Car::new)
                .forEach(cars::add);
        return cars;
    }

    public void play(int playCount) {
        if (playCount < 1) {
            throw new RuntimeException("최소 한 번이상 시도해야합니다.");
        }

        for (int i = 0; i < playCount; i++) {
            go();
            printDisplay();
        }
    }

    public void notifyWinners() {
        List<String> winners = getWinners();
        if (winners.isEmpty()) {
            return;
        }
        System.out.println(getWinnerAnnouncement(winners));
    }

    private StringBuilder getWinnerAnnouncement(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if (i != winners.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("가 최종 우승했습니다.");
        return sb;
    }

    private List<String> getWinners() {
        int maxDistance = cars.stream().map(Car::getLocation).max(Comparator.comparingInt(o -> o)).orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printDisplay() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()).append(": ").append("-".repeat(car.getLocation())).append("\n");
        }
        System.out.println(sb);
    }

    private void go() {
        cars.forEach(Car::go);
    }
}
