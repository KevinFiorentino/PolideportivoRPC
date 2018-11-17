USE dbodbc;
DELIMITER $$
DROP PROCEDURE IF EXISTS TRAER_CANCHA_POR_IDCANCHA $$
CREATE PROCEDURE TRAER_CANCHA_POR_IDCANCHA(
	_idCancha INT
 )

BEGIN
SELECT Localidad.localidad, Filial.idFilial, TipoCancha.tipoCancha, Cancha.idCancha, Deporte.deporte
FROM Cancha
JOIN TipoCancha ON Cancha.idTipoCancha = TipoCancha.idTipoCancha
JOIN Deporte ON TipoCancha.idDeporte = Deporte.idDeporte
JOIN Filial ON Cancha.idFilial = Filial.idFilial
JOIN Localidad ON Filial.idLocalidad = Localidad.idLocalidad

WHERE cancha.idCancha = _idCancha;

END
$$ 
DELIMITER ;

CALL TRAER_CANCHA_POR_IDCANCHA (1);
