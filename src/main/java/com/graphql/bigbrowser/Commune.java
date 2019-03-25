package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "communes")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Commune {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "")
    private Long id;

    @GraphQLQuery(name = "insee", description = "")
    private @NonNull String insee;

    @GraphQLQuery(name = "nom", description = "")
    private @NonNull String nom;

    @GraphQLQuery(name = "statut", description = "")
    private @NonNull String statut;

    @GraphQLQuery(name = "population", description = "")
    private @NonNull Integer population;

    @GraphQLQuery(name = "departement", description = "")
    private @NonNull String departement;
}