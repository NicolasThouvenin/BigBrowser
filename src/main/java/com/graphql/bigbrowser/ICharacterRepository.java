package com.graphql.bigbrowser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface ICharacterRepository extends JpaRepository<Character, Long> {
    @Query(value="SELECT * FROM characters ORDER BY random() LIMIT 1", nativeQuery = true)
    Character randomCharacter();
}
