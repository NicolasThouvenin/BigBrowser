package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

@Service
public class CommuneService {

    private final ICommuneRepository communeRepository;

    public CommuneService(ICommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }

    @GraphQLQuery(name = "commune")
    public Commune getCommuneByInsee(@GraphQLArgument(name = "insee") String insee) {
        Commune commune = this.communeRepository.findByInsee(insee);
        return commune;
    }
}
