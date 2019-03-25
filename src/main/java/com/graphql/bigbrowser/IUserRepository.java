package com.graphql.bigbrowser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IUserRepository extends JpaRepository<User, Long> {
}
