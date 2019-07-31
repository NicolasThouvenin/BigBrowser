package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.Column;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "index_username",  columnList="username", unique = true),
        @Index(name = "index_email",  columnList="email", unique = true)
})
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class User {

    @Id @GeneratedValue
    @GraphQLQuery(name = "id", description = "A user's id")
    private Long id;

    @GraphQLQuery(name = "username", description = "A user's username")
    private @NonNull String username;

    @GraphQLQuery(name = "firstname", description = "A user's firstname")
    private @NonNull String firstname;

    @GraphQLQuery(name = "lastname", description = "A user's lastname")
    private @NonNull String lastname;

    @GraphQLQuery(name = "insee", description = "A user's insee")
    private @NonNull String insee;

    @GraphQLQuery(name = "email", description = "A user's email")
    private @NonNull String email;

    @GraphQLQuery(name = "password", description = "A user's password")
    private @NonNull String password;

    @GraphQLQuery(name = "hasValidEmail", description = "if the user's email is valid")
    @Column(name="hasvalidemail", columnDefinition="Boolean default False")
    private @NonNull boolean hasValidEmail;
}