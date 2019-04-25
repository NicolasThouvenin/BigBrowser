package com.graphql.bigbrowser;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GraphQLQuery(name = "users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GraphQLQuery(name = "user")
    public Optional<User> getUserById(@GraphQLArgument(name = "id") Long id) {
        return userRepository.findById(id);
    }

    @GraphQLMutation(name = "saveUser")
    public User saveUser(@GraphQLArgument(name = "user") User user) {
        String passwordCrypted = Authentication.encodePassword(user.getPassword());
        user.setPassword(passwordCrypted);
        return userRepository.save(user);
    }

    @GraphQLMutation(name = "deleteUser")
    public void deleteUser(@GraphQLArgument(name = "id") Long id) {
        userRepository.deleteById(id);
    }
}
