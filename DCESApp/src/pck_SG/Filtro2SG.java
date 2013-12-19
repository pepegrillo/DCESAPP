package pck_SG;

import java.util.Vector;

public class Filtro2SG {
	
	Vector IdTipoSondeo = new Vector();
	Vector TipoSondeo   = new Vector();
	
	Vector IdArticulo   = new Vector();
	Vector Presentacion = new Vector();
	
	public Filtro2SG(){
		
	}
	
	public Filtro2SG(Vector IdTipoSondeo, Vector TipoSondeo, Vector IdArticulo, Vector Presentacion){
		
		super();
		this.IdTipoSondeo = IdTipoSondeo;
		this.TipoSondeo   = TipoSondeo;
		
		this.IdArticulo   = IdArticulo;
		this.Presentacion = Presentacion;
		
	}

	public Vector getIdTipoSondeo(){
		return IdTipoSondeo;
	}
	public void setIdTipoSondeo(Vector IdTipoSondeo){
		this.IdTipoSondeo = IdTipoSondeo;
	}	
	public Vector getTipoSondeo(){
		return TipoSondeo;
	}
	public void setTipoSondeo(Vector TipoSondeo){
		this.TipoSondeo = TipoSondeo;
	}
	
	public Vector getIdArticulo(){
		return IdArticulo;
	}
	public void setIdArticulo(Vector IdArticulo){
		this.IdArticulo = IdArticulo;
	}	
	public Vector getPresentacion(){
		return Presentacion;
	}
	public void setPresentacion(Vector Presentacion){
		this.Presentacion = Presentacion;
	}
	
	
}
