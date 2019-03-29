package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
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

}
