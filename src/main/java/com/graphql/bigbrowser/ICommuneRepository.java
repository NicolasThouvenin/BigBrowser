package com.graphql.bigbrowser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
interface ICommuneRepository extends JpaRepository<Commune, Long> {
    @Query(value="SELECT id, insee, nom, statut, population, departement FROM communes WHERE insee = ?1", nativeQuery = true)
    Commune findByInsee(String insee);
}
