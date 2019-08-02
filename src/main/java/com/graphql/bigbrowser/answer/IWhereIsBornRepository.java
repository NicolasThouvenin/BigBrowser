package com.graphql.bigbrowser.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface IWhereIsBornRepository extends JpaRepository<WhereIsBorn, Long> {

    @Query(value="SELECT * FROM checkWhereIsBornByCoordinates(?1, ?2, ?3)", nativeQuery = true)
    WhereIsBorn checkWhereIsBornByCoordinates(Integer characterId, Float easting, Float northing);

    @Query(value="SELECT * FROM checkWhereIsBornByGeographicalEntityName(?1, ?2)", nativeQuery = true)
    WhereIsBorn checkWhereIsBornByGeographicalEntityName(Integer characterId, String geographicalEntityName);
}
