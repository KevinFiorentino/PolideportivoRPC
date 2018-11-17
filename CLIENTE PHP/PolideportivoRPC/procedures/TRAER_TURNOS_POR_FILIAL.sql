USE dbodbc;
DELIMITER $$
DROP PROCEDURE IF EXISTS TRAER_TURNOS_POR_FILIAL $$
CREATE PROCEDURE TRAER_TURNOS_POR_FILIAL(
	_idFilial INT(11)
 )

BEGIN
	SELECT idTurno, turno.fechaHora, vigente, localidad.localidad, deporte.deporte, tipoCancha.tipoCancha, usuario.apellido
FROM turno
JOIN Cancha ON turno.idCancha = cancha.idCancha
JOIN TipoCancha ON cancha.idTipoCancha = TipoCancha.idTipoCancha
JOIN Deporte ON TipoCancha.idDeporte = Deporte.idDeporte
JOIN Filial ON Turno.idFilial = Filial.idFilial
JOIN Localidad ON Filial.idLocalidad = Localidad.idLocalidad
JOIN Usuario ON turno.idUsuario = Usuario.idUsuario

WHERE turno.idFilial = _idFilial;


END
$$ 
DELIMITER ;

CALL TRAER_TURNOS_POR_FILIAL("1");
