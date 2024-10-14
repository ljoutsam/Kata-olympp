package fr.olympp.kata.controller;

import fr.olympp.kata.models.Army;
import fr.olympp.kata.models.Clan;
import fr.olympp.kata.services.ClanService;
import fr.olympp.kata.services.ClanServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clans")
public class ClanController {
  private final ClanService clanService;

  public ClanController(ClanService clanService) {
    this.clanService = clanService;
  }

  @PostMapping
  public void createClan(@RequestBody Clan clan) {

    this.clanService.addClan(clan);
  }

  @GetMapping
  public List<Clan> getClans() {
    System.out.println("clans"+this.clanService.getClans());
    return this.clanService.getClans();
  }

  @GetMapping("/{clanName}")
  public Clan getClan(@PathVariable String clanName) {
    return this.clanService.getClan(clanName);
  }

  @PostMapping("/{clanName}/armies")
  public void addArmy(@PathVariable String clanName, @RequestBody Army army) {
    this.clanService.addArmy(clanName, army);
  }

  @DeleteMapping("/{clanName}/armies/{armyName}")
  public void removeArmy(@PathVariable String clanName, @PathVariable String armyName) {
    this.clanService.removeArmy(clanName, armyName);
  }
}

