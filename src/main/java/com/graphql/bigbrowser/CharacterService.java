package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final ICharacterRepository characterRepository;

    public CharacterService(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

}
