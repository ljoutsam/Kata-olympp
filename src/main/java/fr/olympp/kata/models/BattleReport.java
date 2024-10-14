package fr.olympp.kata.models;

import java.util.List;

public class BattleReport {
    private final String status;
    private final String winner;
    private final List<Clan> initialClans;
    private final List<BattleTurn> history;

    // Constructeur
    public BattleReport(String status, String winner, List<Clan> initialClans, List<BattleTurn> history) {
        this.status = status;
        this.winner = winner;
        this.initialClans = initialClans;
        this.history = history;
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public String getWinner() {
        return winner;
    }

    public List<Clan> getInitialClans() {
        return initialClans;
    }

    public List<BattleTurn> getHistory() {
        return history;
    }
}
