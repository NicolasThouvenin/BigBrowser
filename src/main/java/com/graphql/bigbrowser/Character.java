package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import java.util.List;



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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "birthplace", referencedColumnName="insee")
    private Commune birthplace;

    @GraphQLQuery(name = "birthdate", description = "A character's birthdate")
    private Date birthdate;

    @GraphQLQuery(name = "deathplace", description = "A character's deathplace as insee")
    private String deathplace;

    @GraphQLQuery(name = "deathdate", description = "A character's deathdate")
    private Date deathdate;

    @GraphQLQuery(name = "fictionnal", description = "If the character is fictionnal")
    private Boolean fictionnal;

    @ElementCollection(targetClass=String.class)
    @GraphQLQuery(name = "alias", description = "A character alias list")
    private List<String> alias;

    @GraphQLQuery(name = "portrait", description = "A character's portrait")
    private Byte portrait;
}
