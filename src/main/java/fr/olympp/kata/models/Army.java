package fr.olympp.kata.models;

public class Army {
private String name;
private FootSoldier footSoldiers;

public Army(String name, FootSoldier footSoldiers) {
    this.name = name;
    this.footSoldiers = footSoldiers;
}

public String name() { return name; }
public FootSoldier getFootSoldiers() { return footSoldiers; }

public int getArmyAttack() {
    return footSoldiers.getNbUnits() * footSoldiers.getAttack();
}

public int getArmyDefense() {
    return footSoldiers.getNbUnits() * footSoldiers.getDefense();
}


}