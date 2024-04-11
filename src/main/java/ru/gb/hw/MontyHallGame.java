package ru.gb.hw;

import java.util.Random;

public class MontyHallGame {
    private static final int NUM_DOORS = 3;
    private static final Random random = new Random();
    private int carDoor;

    public MontyHallGame() {
        carDoor = random.nextInt(NUM_DOORS);
    }

    public int makeInitialChoice() {
        return random.nextInt(NUM_DOORS);
    }

    public int revealDoor(int initialChoice) {
        int revealedDoor;
        do {
            revealedDoor = random.nextInt(NUM_DOORS);
        } while (revealedDoor == carDoor || revealedDoor == initialChoice);
        return revealedDoor;
    }

    public int makeFinalChoice(int initialChoice, int revealedDoor) {
        return random.nextBoolean() ? initialChoice : switchChoice(initialChoice, revealedDoor);
    }

    private int switchChoice(int initialChoice, int revealedDoor) {
        int finalChoice;
        do {
            finalChoice = random.nextInt(NUM_DOORS);
        } while (finalChoice == initialChoice || finalChoice == revealedDoor);
        return finalChoice;
    }

    public boolean isWinner(int finalChoice) {
        return finalChoice == carDoor;
    }
}
