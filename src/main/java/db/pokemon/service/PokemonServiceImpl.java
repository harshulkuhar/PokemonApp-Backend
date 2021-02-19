package db.pokemon.service;

import db.pokemon.model.Pokemon;
import db.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll();
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
        return pokemon.getName()+" updated successfully!";
    }

    public String deletePokemon(int id) {
        pokemonRepository.deleteById(id);
        return "Pokemon deleted from the database!";
    }
}
