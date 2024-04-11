package ru.gb.hw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MontyHallGameTest {

    @Test
    public void testMakeInitialChoice() {
        MontyHallGame game = new MontyHallGame();
        int initialChoice = game.makeInitialChoice();
        assertTrue(initialChoice >= 0 && initialChoice < 3);
    }
    @Test
    public void testRevealDoor() {
        MontyHallGame game = new MontyHallGame();
        int initialChoice = game.makeInitialChoice();
        int revealedDoor = game.revealDoor(initialChoice);
        assertTrue(revealedDoor >= 0 && revealedDoor < 3);
        assertNotEquals(revealedDoor, initialChoice);
    }
}
