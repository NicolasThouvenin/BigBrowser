package com.graphql.bigbrowser.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface IWhereIsBornedRepository extends JpaRepository<WhereIsBorned, Long> {

    @Query(value="SELECT id, communeisgood, commune, insee, departementisgood, departement, departementnumber FROM whereisborned LIMIT 1", nativeQuery = true)
    WhereIsBorned checkWhereIsBornedByCoordinates(Float easting, Float northing);

    @Query(value="SELECT id, communeisgood, commune, insee, departementisgood, departement, departementnumber FROM whereisborned LIMIT 1", nativeQuery = true)
    WhereIsBorned checkWhereIsBornedByGeographicalEntityName(String name);
}
