package com.graphql.bigbrowser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ICharacterRepository extends JpaRepository<User, Long> {
}
