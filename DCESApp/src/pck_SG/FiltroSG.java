package pck_SG;

import java.util.Vector;

public class FiltroSG {
	
	Vector IdMunicipio = new Vector();
	Vector Municipio   = new Vector();
	
	public FiltroSG(){
		
	}
	
	public FiltroSG(Vector IdMunicipio, Vector Municipio){
		
		super();
		this.IdMunicipio = IdMunicipio;
		this.Municipio   = Municipio;
		
	}

	public Vector getIdMunicipio(){
		return IdMunicipio;
	}
	public void setIdMunicipio(Vector IdMunicipio){
		this.IdMunicipio = IdMunicipio;
	}
	
	public Vector getMunicipio(){
		return Municipio;
	}
	public void setMunicipio(Vector Municipio){
		this.Municipio = Municipio;
	}
	
	
}
