package db.pokemon.service;

import db.pokemon.model.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getAllPokemon(); //GET

    Pokemon getPokemon(int id); //GET

    String addPokemon(Pokemon pokemon); //POST

    String updatePokemon(Pokemon pokemon); //PUT

    String deletePokemon(int id); //DELETE
}
