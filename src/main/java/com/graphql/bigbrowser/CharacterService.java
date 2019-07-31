package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CharacterService {

    private final ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GraphQLQuery(name = "characters")
    public List<Character> getCharacters() {
        return characterRepository.findAll();
    }

    @GraphQLQuery(name = "randomCharacter")
    public Character getRandomCharacter() {
        return characterRepository.randomCharacter();
    }

    @GraphQLMutation(name = "saveCharacter")
    public Character saveCharacter(@GraphQLArgument(name = "character") Character character) {
        return characterRepository.save(character);
    }

    @GraphQLMutation(name = "deleteCharacter")
    public void deleteCharacter(@GraphQLArgument(name = "id") Long id) {
        characterRepository.deleteById(id);
    }

}
