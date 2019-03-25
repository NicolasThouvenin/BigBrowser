package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class User {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A user's id")
    private Long id;

    @GraphQLQuery(name = "username", description = "A user's username")
    private @NonNull String username;

    @GraphQLQuery(name = "insee", description = "A user's insee")
    private @NonNull String insee;

    public void setId(Long id) {
        this.id = id;
    }
}