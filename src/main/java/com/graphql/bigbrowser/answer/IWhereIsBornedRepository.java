package com.graphql.bigbrowser.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface IWhereIsBornedRepository extends JpaRepository<WhereIsBorned, Long> {

    @Query(value="SELECT * FROM checkwhereisbornedbycoordinates(?1, ?2, ?3)", nativeQuery = true)
    WhereIsBorned checkWhereIsBornedByCoordinates(Integer characterId, Float easting, Float northing);

    @Query(value="SELECT * FROM checkWhereIsBornedByGeographicalEntityName(?1, ?2)", nativeQuery = true)
    WhereIsBorned checkWhereIsBornedByGeographicalEntityName(Integer characterId, String geographicalEntityName);
}
