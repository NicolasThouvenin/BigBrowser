package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

@Service
public class DepartementService {

    private final IDepartementRepository departementRepository;

    public DepartementService(IDepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }
}
