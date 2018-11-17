package handler;

import java.util.List;
import org.apache.thrift.TException;
import poli.PoliService.Iface;
import poli.Turno;
import poli.Cancha;
import odbc.dao.PoliDAO;
import poli.CampoVacio;
import poli.NoEncontrado;

public abstract class PoliHandler implements Iface {

	@Override
	public List<Turno> traerTurnosPorFilial(int idFilial) throws TException {
		PoliDAO p = new PoliDAO();
		System.out.println("Solicita traerTurnosPorFilial");
		return p.traerTurnosPorFilial(idFilial);
	}
        
        	@Override
	public Turno traerTurnoPorId(int idTurno) throws TException {
		PoliDAO p = new PoliDAO();
		System.out.println("Solicita traerTurnoPorId");
		return p.traerTurnoPorId(idTurno);
	}
        
            @Override
	public String traerTelefonoPorUsuario(String nombre, String apellido) throws NoEncontrado, CampoVacio, TException {
		PoliDAO p = new PoliDAO();
                String resultado = p.traerTelefonoPorUsuario(nombre, apellido);
		System.out.println("Solicita traerTelefonoPorUsuario");
                if (resultado == null){
                    System.out.println("excepcion NoEncontrado");
                    NoEncontrado noEncontrado = new NoEncontrado ();
                    noEncontrado.setDato("Error NoEncontrado: No pudimos encontrar el usuario solicitado");
                     throw noEncontrado;
                    
                }
                else {
		//DECLARAR LA EXCEPCION ACA Y TOMAR EL CATCH EN EL CLIENTE TOMAR CATCH DEL TIPO NO ENCONTRADO)
                return resultado;
                }
	}
        
        @Override
        public List<Cancha> traerCanchasPorDeporte(String deporte) throws TException {
		PoliDAO p = new PoliDAO();
		System.out.println("Solicita traerCanchasPorDeporte");
		return p.traerCanchasPorDeporte(deporte);
	}
        
        @Override
        public Cancha traerCanchaPorId(int idCancha) throws TException {
		PoliDAO p = new PoliDAO();
		System.out.println("Solicia traerCanchaPorId");
		return p.traerCanchaPorId(idCancha);
	}
        
        @Override
	public String traerLocalidadPorFilial(int idFilial) throws NoEncontrado, CampoVacio, TException {
		PoliDAO p = new PoliDAO();
                System.out.println("Solicia traerLocalidadPorFilial");
                if (idFilial == 0){
                    System.out.println("excepcion CampoVacio");
                    CampoVacio campoVacio = new CampoVacio ();
                    campoVacio.setDato("Error CampoVacio: No se registro un ingreso de Filial");
                     throw campoVacio;
                    
                }
                else {
		//DECLARAR LA EXCEPCION ACA Y TOMAR EL CATCH EN EL CLIENTE TOMAR CATCH DEL TIPO NO ENCONTRADO)
                return p.traerLocalidadPorFilial(idFilial);
                }
	}
}
