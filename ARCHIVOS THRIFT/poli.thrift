namespace java poli
namespace php poli

struct Turno {
	1: i32 idTurno;
	2: string fechaHora;
	3: bool vigente;
	4: string localidad;
	5: string deporte;
	6: string tipoCancha;
	7: string apellido;
	}

struct Cancha {
	1: string localidad;
	2: i32 idFilial;
	3: string tipoCancha;
	4: i32 idCancha;
	5: string deporte;
	}

exception CampoVacio {
  1: string dato
}

exception NoEncontrado {
  1: string dato
}
	service PoliService
	{
	Turno traerTurnoPorId(1:i32 idTurno),
	list<Turno> traerTurnosPorFilial(1:i32 idFilial),
	string traerTelefonoPorUsuario(1:string apellido, 2:string nombre) throws (1:NoEncontrado noEncontrado),
	Cancha traerCanchaPorId(1:i32 idCancha),
	list<Cancha> traerCanchasPorDeporte(1:string deporte),
	string traerLocalidadPorFilial(1:i32 idFilial) throws (1:CampoVacio campoVacio),	
	}
	