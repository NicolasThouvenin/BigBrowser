package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "characters")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Character {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A character's id")
    private Long id;

    @GraphQLQuery(name = "firstname", description = "A character's firstname")
    private String firstname;

    @GraphQLQuery(name = "lastname", description = "A character's lastname")
    private @NonNull String lastname;

    @GraphQLQuery(name = "birthplace", description = "A character's birthplace as insee")
    private String birthplace;

    @GraphQLQuery(name = "birthdate", description = "A character's birthdate")
    private String birthdate;

    @GraphQLQuery(name = "deathplace", description = "A character's deathplace as insee")
    private String deathplace;

    @GraphQLQuery(name = "deathdate", description = "A character's deathdate")
    private String deathdate;

    @GraphQLQuery(name = "fictionnal", description = "If the character is fictionnal")
    private Boolean fictionnal;

    @GraphQLQuery(name = "alias", description = "A character alias list")
    private String[] alias;

    @GraphQLQuery(name = "portrait", description = "A character's portrait")
    private Byte portrait;
}
