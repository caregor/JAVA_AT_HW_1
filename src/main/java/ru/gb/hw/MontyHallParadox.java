package ru.gb.hw;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class MontyHallParadox {
    public static void main(String[] args) {
        int totalGames = 1000;
        int switchWins = 0;
        int stayWins = 0;

        for (int i = 0; i < totalGames; i++) {
            MontyHallGame game = new MontyHallGame();
            int initialChoice = game.makeInitialChoice();
            int revealedDoor = game.revealDoor(initialChoice);
            int finalChoice = game.makeFinalChoice(initialChoice, revealedDoor);

            if (game.isWinner(finalChoice)) {
                if (finalChoice == initialChoice) {
                    stayWins++;
                } else {
                    switchWins++;
                }
            }
        }

        System.out.println("Победы при смене выбора: " + switchWins);
        System.out.println("Победы при оставании при своем выборе: " + stayWins);

        // вероятности выигрыша
        double switchWinProbability = (double) switchWins / totalGames * 100;
        double stayWinProbability = (double) stayWins / totalGames * 100;
        System.out.println("Вероятность выигрыша при смене выбора: " + switchWinProbability + "%");
        System.out.println("Вероятность выигрыша при оставании при своем выборе: " + stayWinProbability + "%");

        // среднее значение
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.addValue(switchWins);
        stats.addValue(stayWins);
        System.out.println("Среднее значение: " + stats.getMean());
    }
}
