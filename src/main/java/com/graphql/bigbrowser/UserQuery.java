package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;

public class UserQuery {

    @Autowired
    private IUserQuery userQuery;

    @GraphQLQuery(name = "communeName", description = "A user's test")
    public String getCommuneName() {
        return userQuery.getCommuneName("84000");
    }
}
