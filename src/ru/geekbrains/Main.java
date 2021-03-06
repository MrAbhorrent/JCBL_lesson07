package ru.geekbrains;

import java.util.Random;

public class Main {

    public static final int countCats = 5;
    public static final int countOfPlates = 4;
    public static final String[] nicknames = {"Барсик", "Мурзик", "Котэ", "Рыжик", "Швеллер"};
    private static Cat[] cats;
    private static Plate[] plates;

    public static void main(String[] args) {
	// write your code here
        cats = new Cat[countCats];
        plates = new Plate[countOfPlates];
        createCats(cats, countCats);
        createPlates(plates, countOfPlates);

        for (Cat cat: cats
             ) {
            cat.info();
        }
        System.out.println("===============================");
        for (Plate plate: plates) {
            plate.info();
        }

        // Сейчас добавим еду в тарелки
        int havingFood = 25;
        System.out.println("Рассыпаем еду по тарелкам. Количество - " + havingFood);
        int remainFood = havingFood;
        for (int i = 0; i < countOfPlates; i++) {
            remainFood = plates[i].addFood(remainFood);
            if (remainFood == 0) break;
        }
        System.out.println("Осталось еды = " + remainFood);
        System.out.println("===============================");
        for (Plate plate: plates) {
            plate.info();
        }

        // Берем котов и кормим из тарелок
        for (int i = 0; i < countCats; i++) {
            for (int j = 0; j < countOfPlates; j++) {
                cats[i].eat(plates[j]);
            }
        }

    }

    private static void createCats(Cat[] catsArray, int countOfCats) {

        Random random = new Random();
        for (int i = 0; i < countOfCats; i++ ) {
            int age = random.nextInt(18) + 1;
            int maxAppetite = random.nextInt(5) + 1;
            catsArray[i] = new Cat(nicknames[i], age, maxAppetite);
        }
    }

    private static void createPlates(Plate[] platesArray, int countOfPlates) {

        Random random = new Random();
        for (int i = 0; i < countOfPlates; i++ ) {
            int maxCapacity = random.nextInt(7) + 1;
            platesArray[i] = new Plate(maxCapacity);
        }
    }
}
