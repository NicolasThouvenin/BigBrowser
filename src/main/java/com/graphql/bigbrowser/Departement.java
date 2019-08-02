package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "departements")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Departement implements Serializable {

    @Id
    @GraphQLQuery(name = "id", description = "id of database entity. it's nt the official id")
    private Long id;

    @GraphQLQuery(name = "number", description = "official number")
    private @NonNull String number;

    @GraphQLQuery(name = "name", description = "name of department")
    private @NonNull String name;

    @GraphQLQuery(name = "regionNumber", description = "region official id")
    private @NonNull String region_number;

    @OneToMany(mappedBy="departement")
    private Set<Commune> communes;
}