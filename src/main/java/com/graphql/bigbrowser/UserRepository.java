package com.graphql.bigbrowser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="SELECT communes.nom_com FROM users\n" +
            "INNER JOIN communes\n" +
            "ON communes.insee_com = users.commune\n" +
            "where users.id = ?1", nativeQuery = true)
    String getCommuneName(String insee);
}
