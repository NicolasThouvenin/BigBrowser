package com.graphql.bigbrowser.answer;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

@Service
public class WhereIsBornService {

    private final IWhereIsBornRepository whereIsBornRepository;

    public WhereIsBornService(IWhereIsBornRepository whereIsBornRepository) {
        this.whereIsBornRepository = whereIsBornRepository;
    }

    @GraphQLQuery(name = "whereIsBornByCoordinates")
    public WhereIsBorn checkWhereIsBornByCoordinates(@GraphQLArgument(name = "characterId") Integer characterId,
                                                         @GraphQLArgument(name = "easting") Float easting,
                                                         @GraphQLArgument(name = "northing") Float northing) {
        WhereIsBorn whereIsBorn = this.whereIsBornRepository.checkWhereIsBornByCoordinates(characterId, easting, northing);
        return whereIsBorn;
    }

    @GraphQLQuery(name = "whereIsBornByGeographicalEntityName")
    public WhereIsBorn checkWhereIsBornByGeographicalEntityName(@GraphQLArgument(name = "characterId") Integer characterId,
                                                                    @GraphQLArgument(name = "geographicalEntityName") String geographicalEntityName) {
        WhereIsBorn whereIsBorn = this.whereIsBornRepository.checkWhereIsBornByGeographicalEntityName(characterId, geographicalEntityName);
        return whereIsBorn;
    }
}
