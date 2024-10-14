package fr.olympp.kata.repository;

import fr.olympp.kata.models.Clan;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryClanRepository implements ClanRepository {

    private final Map<String, Clan> clans = new HashMap<>();

    public InMemoryClanRepository() {
        // Initialisation des clans
        clans.put("grec", new Clan("grec", Collections.emptyList()));
        clans.put("trojan", new Clan("trojan", Collections.emptyList()));
    }

    @Override
    public void addClan(Clan clan) {
        clans.put(clan.getName(), clan);
    }

    @Override
    public Clan updateClan(Clan clan) {
        if (!clans.containsKey(clan.getName())) {
            throw new IllegalArgumentException("Le clan n'existe pas.");
        }
        clans.put(clan.getName(), clan);
        return clan;
    }

    @Override
    public Clan getClan(String name) {
        return clans.get(name);
    }

    @Override
    public List<Clan> getClans() {
        System.out.println("les clans"+clans.values());
        return new ArrayList<>(clans.values());
    }


}
