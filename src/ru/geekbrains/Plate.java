package ru.geekbrains;

public class Plate {
    protected int food;  // текущее количество еды
    protected int maxCapacity; // емкость тарелки

    public Plate(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.food = 0;
    }

    public int currentFood() {
        return food;
    }

    public int addFood(int food) {
        int remainSpace = maxCapacity - currentFood();
        if (food > remainSpace) {
            this.food = maxCapacity;
            return food - remainSpace; // остаток еды не поместившийся в тарелку
        } else {
            this.food += food;
            return 0; // вся еда поместилась в тарелку
        }

    }

    public void decreaseFood(int eatFood) {
        if (this.food < eatFood) {
            this.food = 0;
        } else {
            this.food -= eatFood;
        }
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String  toString() {
        return "Plate[" +
                "maxCapacity=" + maxCapacity +
                ", food=" + food +
                ']';
    }
}
