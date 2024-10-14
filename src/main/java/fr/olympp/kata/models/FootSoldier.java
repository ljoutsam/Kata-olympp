package fr.olympp.kata.models;

public class FootSoldier {
    private int nbUnits;
    private int attack;
    private int defense;
    private int health;

    // Constructeur
    public FootSoldier(int nbUnits, int attack, int defense, int health) {
        this.nbUnits = nbUnits;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    // Getters standard pour la sérialisation avec Jackson
    public int getNbUnits() {
        return nbUnits;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }
}

