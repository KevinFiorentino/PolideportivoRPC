package odbc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import poli.Turno;
import odbc.DataSource;
import poli.CampoVacio;
import poli.Cancha;
import poli.NoEncontrado;

public class PoliDAO {
	DataSource ds;
	
	public PoliDAO(){
		ds = new DataSource();
	}
	
	public List<Turno> traerTurnosPorFilial(int idFilial){
		List<Turno> turnos = new ArrayList<Turno>();
		String query = String.format("CALL TRAER_TURNOS_POR_FILIAL('%d')", idFilial);
		ResultSet rs = this.ds.execute(query);
                
		try {
			while (rs.next()){
				Turno p = new Turno();
				p.setIdTurno(rs.getInt("idTurno"));
				p.setFechaHora(rs.getString("fechaHora"));
				p.setVigente(rs.getBoolean("vigente"));
				p.setLocalidad(rs.getString("localidad"));
               			p.setDeporte(rs.getString("deporte"));
                                p.setTipoCancha(rs.getString("tipoCancha"));
                                p.setApellido(rs.getString("apellido"));
				turnos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
                      
		}finally{
			this.ds.close();
		}
		
		return turnos;
	}
        
        public Turno traerTurnoPorId(int idTurno){
		Turno p = new Turno ();
		String query = String.format("CALL TRAER_TURNO_POR_IDTURNO('%d')", idTurno);
		ResultSet rs = this.ds.execute(query);

		try {
                            while (rs.next()){
				p.setIdTurno(rs.getInt("idTurno"));
				p.setFechaHora(rs.getString("fechaHora"));
				p.setVigente(rs.getBoolean("vigente"));
				p.setLocalidad(rs.getString("localidad"));
               			p.setDeporte(rs.getString("deporte"));
                                p.setTipoCancha(rs.getString("tipoCancha"));
                                p.setApellido(rs.getString("apellido"));
                            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.ds.close();
		}
		
		return p;
	}
        
         public String traerTelefonoPorUsuario(String nombre, String apellido)throws CampoVacio{
             String telefono = null;
             
           
                
		String query = String.format("CALL TRAER_TELEFONO_POR_USUARIO('%s','%s')", nombre, apellido);
		ResultSet rs = this.ds.execute(query);
                
		try {
                            while (rs.next()){
				telefono=rs.getString("telefono");				
                            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.ds.close();
		}
		
		return telefono;
                
	}
         
         public List<Cancha> traerCanchasPorDeporte(String deporte){
		List<Cancha> canchas = new ArrayList<Cancha>();
		String query = String.format("CALL TRAER_CANCHAS_POR_DEPORTE('%s')", deporte);
		ResultSet rs = this.ds.execute(query);

		try {
			while (rs.next()){
				Cancha p = new Cancha();
				p.setLocalidad(rs.getString("localidad"));
				p.setIdFilial(rs.getInt("idFilial"));
				p.setTipoCancha(rs.getString("tipoCancha"));
				p.setIdCancha(rs.getInt("idCancha"));
               			p.setDeporte(rs.getString("deporte"));
				canchas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.ds.close();
		}
		
		return canchas;
	}
         
         public Cancha traerCanchaPorId(int idCancha){
		Cancha p = new Cancha ();
		String query = String.format("CALL TRAER_CANCHA_POR_IDCANCHA('%d')", idCancha);
		ResultSet rs = this.ds.execute(query);

		try {
                            while (rs.next()){
				p.setLocalidad(rs.getString("localidad"));
				p.setIdFilial(rs.getInt("idFilial"));
				p.setTipoCancha(rs.getString("tipoCancha"));
				p.setIdCancha(rs.getInt("idCancha"));
               			p.setDeporte(rs.getString("deporte"));
                            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.ds.close();
		}
		
		return p;
	}
         
         public String traerLocalidadPorFilial(int idFilial){
             String localidad = null;
		String query = String.format("CALL TRAER_LOCALIDAD_POR_IDFILIAL('%d')", idFilial);
		ResultSet rs = this.ds.execute(query);

		try {
                            while (rs.next()){
				localidad=rs.getString("localidad");				
                            }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.ds.close();
		}
		
		return localidad;
	}
}
