package fr.olympp.kata.models;

import java.util.ArrayList;
import java.util.List;

public class Clan {
    private final String name;
    private List<Army> armies;

    // Constructeur
    public Clan(String name, List<Army> armies) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom du clan ne peut pas être vide.");
        }
        this.name = name;
        this.armies = armies != null ? armies : new ArrayList<>(); // Initialise une liste vide si non fournie
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Army> getArmies() {
        return armies;
    }

    // Méthode pour vérifier si le clan a encore des armées restantes
    public boolean hasRemainingArmies() {
        return armies.stream().anyMatch(army -> army.getFootSoldiers().getNbUnits() > 0);
    }

    // Optionnel : Méthode pour ajouter une armée
    public void addArmy(Army army) {
        if (army != null) {
            armies.add(army);
        }
    }

    // Optionnel : Méthode pour supprimer une armée
    public void removeArmy(Army army) {
        armies.remove(army);
    }
}
