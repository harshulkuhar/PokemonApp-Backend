package db.pokemon.service;

import db.pokemon.model.Pokemon;
import db.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon(){
        List<Pokemon> pokemons =  pokemonRepository.findAll();
        Collections.sort(pokemons);
        return pokemons;
    }
    public Pokemon getPokemon(int id) {
        return pokemonRepository.findById(id);
    }

    public String addPokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return pokemon.getName()+" added to the database!";
    }

    public String updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
        return pokemon.getName()+" updated successfully!!";
    }

    public String deletePokemon(int id) {
        String pokemonName = pokemonRepository.findById(id).getName();
        pokemonRepository.deleteById(id);
        return pokemonName+" deleted from the database!";
    }
}
