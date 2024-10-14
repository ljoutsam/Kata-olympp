package fr.olympp.kata.models;

public class BattleTurn {
    private final String nameArmy1;
    private final String nameArmy2;
    private final int damageArmy1;
    private final int damageArmy2;
    private final int nbRemainingSoldiersArmy1;
    private final int nbRemainingSoldiersArmy2;

    // Constructeur
    public BattleTurn(String nameArmy1, String nameArmy2, int damageArmy1, int damageArmy2, int nbRemainingSoldiersArmy1, int nbRemainingSoldiersArmy2) {
        this.nameArmy1 = nameArmy1;
        this.nameArmy2 = nameArmy2;
        this.damageArmy1 = damageArmy1;
        this.damageArmy2 = damageArmy2;
        this.nbRemainingSoldiersArmy1 = nbRemainingSoldiersArmy1;
        this.nbRemainingSoldiersArmy2 = nbRemainingSoldiersArmy2;
    }

    // Getters
    public String getNameArmy1() {
        return nameArmy1;
    }

    public String getNameArmy2() {
        return nameArmy2;
    }

    public int getDamageArmy1() {
        return damageArmy1;
    }

    public int getDamageArmy2() {
        return damageArmy2;
    }

    public int getNbRemainingSoldiersArmy1() {
        return nbRemainingSoldiersArmy1;
    }

    public int getNbRemainingSoldiersArmy2() {
        return nbRemainingSoldiersArmy2;
    }
}
