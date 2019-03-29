package com.graphql.bigbrowser.answer;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

@Service
public class WhereIsBornedService {

    private final IWhereIsBornedRepository whereIsBornedRepository;

    public WhereIsBornedService(IWhereIsBornedRepository whereIsBornedRepository) {
        this.whereIsBornedRepository = whereIsBornedRepository;
    }

    @GraphQLQuery(name = "whereIsBornedByCoordinates")
    public WhereIsBorned checkWhereIsBornedByCoordinates(@GraphQLArgument(name = "easting") Float easting,
                                                   @GraphQLArgument(name = "northing") Float northing) {
        WhereIsBorned whereIsBorned = this.whereIsBornedRepository.checkWhereIsBornedByCoordinates(easting, northing);
        return whereIsBorned;
    }

    @GraphQLQuery(name = "whereIsBornedByGeographicalEntityName")
    public WhereIsBorned checkWhereIsBornedByGeographicalEntityName(@GraphQLArgument(name = "name") String name) {
        WhereIsBorned whereIsBorned = this.whereIsBornedRepository.checkWhereIsBornedByGeographicalEntityName(name);
        return whereIsBorned;
    }
}
