package fr.olympp.kata.services;

import fr.olympp.kata.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleServiceImpl implements BattleService{
    @Override
    public BattleReport battle(Clan clan1, Clan clan2) {
        List<BattleTurn> history = new ArrayList<>();
        List<Army> armies1 = new ArrayList<>(clan1.getArmies());
        List<Army> armies2 = new ArrayList<>(clan2.getArmies());

        while (!armies1.isEmpty() && !armies2.isEmpty()) {
            //On recupere 1 armee par clan pour les opposées
            Army army1 = armies1.get(0);
            Army army2 = armies2.get(0);

            //Dommage de charque armée
            int damageToArmy2 = Math.max(0, army1.getArmyAttack() - army2.getArmyDefense());
            int damageToArmy1 = Math.max(0, army2.getArmyAttack() - army1.getArmyDefense());

            //Nombre de soldats mort sur un tour
            int soldiersLostArmy1 = damageToArmy1 / army1.getFootSoldiers().getHealth();
            int soldiersLostArmy2 = damageToArmy2 / army2.getFootSoldiers().getHealth();

            // Nombre de soldats restant par armée
            int remainingSoldiersArmy1 = army1.getFootSoldiers().getNbUnits() - soldiersLostArmy1;
            int remainingSoldiersArmy2 = army2.getFootSoldiers().getDefense() - soldiersLostArmy2;

            //On enregistre le tour opposant 1 armee de chaque clan dans la liste
            history.add(new BattleTurn(army1.name(), army2.name(), damageToArmy1, damageToArmy2, remainingSoldiersArmy1, remainingSoldiersArmy2));

            // Mettre à jour les soldats restants dans les armées
            if (remainingSoldiersArmy1 <= 0) {
                armies1.remove(0); // Armée décimée
            } else {
                armies1.set(0, new Army(army1.name(), new FootSoldier(remainingSoldiersArmy1, army1.getFootSoldiers().getAttack(), army1.getFootSoldiers().getDefense(), army1.getFootSoldiers().getHealth())));
            }

            if (remainingSoldiersArmy2 <= 0) {
                armies2.remove(0); // Armée décimée
            } else {
                armies2.set(0, new Army(army2.name(), new FootSoldier(remainingSoldiersArmy2, army2.getFootSoldiers().getAttack(), army2.getFootSoldiers().getDefense(), army2.getFootSoldiers().getHealth())));
            }
        }

        String winner = armies1.isEmpty() ? clan2.getName() : armies2.isEmpty() ? clan1.getName() : null;
        String status = winner == null ? "DRAW" : "WIN";
        return new BattleReport(status, winner, List.of(clan1, clan2), history);
    }
}

