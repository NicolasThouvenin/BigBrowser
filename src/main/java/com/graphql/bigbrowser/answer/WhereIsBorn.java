package com.graphql.bigbrowser.answer;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "whereisborned")
@NoArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
public class WhereIsBorned {

    @Id
    private Long id;

    @GraphQLQuery(name = "communeIsGood", description = "if commune is good")
    private @NonNull Boolean communeisgood;

    @GraphQLQuery(name = "commune", description = "commune's name")
    private @NonNull String commune;

    @GraphQLQuery(name = "insee", description = "commune's insee")
    private @NonNull String insee;

    @GraphQLQuery(name = "departementIsGood", description = "if departement is good")
    private @NonNull Boolean departementisgood;

    @GraphQLQuery(name = "departement", description = "departement's name")
    private @NonNull String departement;

    @GraphQLQuery(name = "departementNumber", description = "departement's number")
    private @NonNull String departementnumber;

}