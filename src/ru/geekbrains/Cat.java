package ru.geekbrains;

public class Cat {
    protected final String nickname;
    protected int age;
    protected boolean satisfaction;
    protected int appetite;
    protected int maxAppetite;

    public Cat(String nickname1, int age, int maxApppetite) {
        this.nickname = nickname1;
        setAge(age);
        setSatisfied(false);
        this.maxAppetite = maxApppetite;
        this.appetite = maxAppetite;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age <=25) {
            this.age = age;
        }
    }

    public boolean isSatisfied() {
        return satisfaction;
    }

    public void setSatisfied(boolean satisfied) {
        this.satisfaction = satisfied;
        this.appetite = 0;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate plate) {

        int currentFood = plate.currentFood();
        // Если кот голоден то он ест
        if (!isSatisfied()) {
            // проверка насколько кот голоден
            int valueEat;
            if (appetite <= currentFood) {
                valueEat = appetite;
                setSatisfied(true);
            } else {
                appetite -= currentFood;
                valueEat = currentFood;
            }
            plate.decreaseFood(valueEat);
        }
    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", satisfaction=" + satisfaction +
                ", appetite=" + appetite +
                ", maxAppetite=" + maxAppetite +
                '}';
    }
}
