package step4;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void MoveForward() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
