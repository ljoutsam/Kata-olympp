package fr.olympp.kata.models;

public class Army {
private String name;
private FootSoldier footSoldiers;

public Army(String name, FootSoldier footSoldiers) {
    this.name = name;
    this.footSoldiers = footSoldiers;
}

public String name() { return name; }
public FootSoldier footSoldiers() { return footSoldiers; }

public int getArmyAttack() {
    return footSoldiers.nbUnits() * footSoldiers.attack();
}

public int getArmyDefense() {
    return footSoldiers.nbUnits() * footSoldiers.defense();
}


}