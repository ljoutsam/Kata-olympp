package fr.olympp.kata.services;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.repository.ClanRepository;
import fr.olympp.kata.repository.InMemoryClanRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClanServiceImpl implements ClanService{

    private final InMemoryClanRepository clanRepository;

    public ClanServiceImpl(InMemoryClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }
    private final List<Clan> clans = new ArrayList<>();

    @Override
    public void addClan(Clan clan) {
        System.out.println("Ajout du clan : " + clan);
        clanRepository.addClan(clan);
    }
    @Override
    public Clan getClan(String clanName) {
        return clanRepository.getClan(clanName);
    }

    @Override
    public List<Clan> getClans() {
        return clanRepository.getClans();
    }

    @Override
    public void addArmy(String clanName, Army army) {
        Clan clan = clanRepository.getClan(clanName);
        if (clan == null) {
            System.out.println("Clan not found: " + clanName);
            throw new ClanNotFoundException("Clan not found with name: " + clanName);
        }

        // Créez une nouvelle liste d'armées en ajoutant la nouvelle armée
        List<Army> updatedArmies = new ArrayList<>(clan.getArmies());
        updatedArmies.add(army);

        // Créez un nouveau clan avec les armées mises à jour
        Clan updatedClan = new Clan(clan.getName(), updatedArmies);
        clanRepository.updateClan(updatedClan);
    }


    @Override
    public void removeArmy(String clanName, String armyName) {
        Clan clan = clanRepository.getClan(clanName);
        clan.getArmies().removeIf(army -> army.name().equals(armyName));
        clanRepository.updateClan(clan);
    }
}
