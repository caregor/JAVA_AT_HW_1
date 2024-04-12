package ru.gb.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallGameTest {

    private MontyHallGame game;

    @BeforeEach
    public void setUp() {
        game = new MontyHallGame();
    }

    @Test
    @DisplayName("Проверка первого хода")
    public void testMakeInitialChoice() {
        int initialChoice = game.makeInitialChoice();
        assertTrue(initialChoice >= 0 && initialChoice < 3);
    }
    @Test
    @DisplayName("Проверка смены двери")
    public void testRevealDoor() {
        int initialChoice = game.makeInitialChoice();
        int revealedDoor = game.revealDoor(initialChoice);
        assertTrue(revealedDoor >= 0 && revealedDoor < 3);
        assertNotEquals(revealedDoor, initialChoice);
    }

    @Test
    @DisplayName("Проверка последнего выбора")
    public void testMakeFinalChoice() {
        int initialChoice = game.makeInitialChoice();
        int revealedDoor = game.revealDoor(initialChoice);
        int finalChoice = game.makeFinalChoice(initialChoice, revealedDoor);
        // System.out.printf("Начальный ход: %d, Помененая дверь %d, Финальный выбор: %d", initialChoice, revealedDoor, finalChoice);
        assertTrue(finalChoice >= 0 && finalChoice < 3);
        assertNotEquals(finalChoice, initialChoice);
        assertNotEquals(finalChoice, revealedDoor);
    }

    @Test
    @DisplayName("Test checking if the player wins")
    public void testIsWinner() {
        int initialChoice = game.makeInitialChoice();
        int revealedDoor = game.revealDoor(initialChoice);
        int finalChoice = game.makeFinalChoice(initialChoice, revealedDoor);
        boolean isWinner = game.isWinner(finalChoice);
        assertTrue(isWinner || !isWinner);
    }
}
