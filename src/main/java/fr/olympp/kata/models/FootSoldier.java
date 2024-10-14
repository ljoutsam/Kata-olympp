package fr.olympp.kata.models;
public class FootSoldier {
    private int nbUnits;
    private int attack;
    private int defense;
    private int health;

    public FootSoldier(int nbUnits, int attack, int defense, int health) {
        this.nbUnits = nbUnits;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public int nbUnits() { return nbUnits; }
    public int attack() { return attack; }
    public int defense() { return defense; }
    public int health() { return health; }
}

