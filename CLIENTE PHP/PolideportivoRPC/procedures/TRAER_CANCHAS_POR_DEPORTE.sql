USE dbodbc;
DELIMITER $$
DROP PROCEDURE IF EXISTS TRAER_CANCHAS_POR_DEPORTE $$
CREATE PROCEDURE TRAER_CANCHAS_POR_DEPORTE(
	_deporte VARCHAR(250)
 )

BEGIN
SELECT Localidad.localidad, Filial.idFilial, TipoCancha.tipoCancha, Cancha.idCancha, Deporte.deporte
FROM Cancha
JOIN TipoCancha ON Cancha.idTipoCancha = TipoCancha.idTipoCancha
JOIN Deporte ON TipoCancha.idDeporte = Deporte.idDeporte
JOIN Filial ON Cancha.idFilial = Filial.idFilial
JOIN Localidad ON Filial.idLocalidad = Localidad.idLocalidad

WHERE deporte.deporte = _deporte;

END
$$ 
DELIMITER ;

CALL TRAER_CANCHAS_POR_DEPORTE("Futbol");
