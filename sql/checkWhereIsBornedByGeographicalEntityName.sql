CREATE OR REPLACE FUNCTION public.checkWhereIsBornByGeographicalEntityName(
	character_id integer,
	geographical_entity_name character varying)
    RETURNS SETOF whereisborned 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$
DECLARE
BEGIN	
    RETURN QUERY INSERT INTO whereisborned (communeisgood, commune, insee, departementisgood, departement, departementnumber)
		SELECT communeisgood, commune, insee, departementisgood, departement, departementnumber
		FROM (
			SELECT  0 AS matching_number,
					True AS communeisgood, c.nom AS commune, c.insee AS insee,
					True AS departementisgood, dpt.name AS departement, dpt.number AS departementnumber
			FROM characters AS ch
			INNER JOIN communes AS c
			ON ch.birthplace = c.insee
			INNER JOIN departements AS dpt
			ON dpt.number = c.departement
			WHERE ch.id = character_id AND c.nom like concat('%', geographical_entity_name, '%')
				UNION
			SELECT 1 AS matching_number,
					False AS communeisgood, '' AS commune, '' AS insee,
					True AS departementisgood, dpt.name AS departement, dpt.number AS departementnumber
			FROM characters AS ch
			INNER JOIN communes AS c
			ON ch.birthplace = c.insee
			INNER JOIN departements AS dpt
			ON dpt.number = c.departement
			WHERE ch.id = character_id AND dpt.name like concat('%', geographical_entity_name, '%')
				UNION
			SELECT  3 AS matching_number,
					False AS communeisgood, '' AS commune, '' AS insee, 
					FALSE AS departementisgood, '' AS departement, '' AS departementnumber
		) AS subresearch
		ORDER BY matching_number LIMIT 1 
	RETURNING commune, departement, insee, id, communeisgood, departementisgood, departementnumber;
END;
$BODY$;