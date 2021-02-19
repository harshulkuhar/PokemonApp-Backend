package db.pokemon.controller;

import db.pokemon.model.Pokemon;
import db.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/all")
    public ResponseEntity<List<Pokemon>> getAllPokemon(){
        List<Pokemon> pokemons = pokemonService.getAllPokemon();
        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable int id){
        Pokemon poke = pokemonService.getPokemon(id);
        return new ResponseEntity<>(poke, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPokemon(@RequestBody Pokemon pokemon){
        String addResponse = pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(addResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePokemon(@RequestBody Pokemon pokemon){
        String updateResponse =  pokemonService.updatePokemon(pokemon);
        return new ResponseEntity<>(updateResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable int id){
        String deleteResponse = pokemonService.deletePokemon(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }


}
