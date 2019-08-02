package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "communes")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Commune  implements Serializable {

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

    @OneToMany(mappedBy="birthplace")
    private Set<Character> characters;
}