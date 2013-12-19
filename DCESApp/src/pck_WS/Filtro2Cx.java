package pck_WS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import org.json.me.JSONArray;
import org.json.me.JSONObject;

import pck_SG.Filtro2SG;
import configurations.ConexionController;
import configurations.Strings;

public class Filtro2Cx {

	
	private String connectionURL;
	private HttpConnection conn;
	private InputStream is;
	private ByteArrayOutputStream bos;
	private String response;
	
	String tipoConexion = ConexionController.getConnectionString()[0];
	String getTipo = ConexionController.getConnectionString()[1];
	
	public Vector IdTipoSondeo   = new Vector();
	public Vector TipoSondeo     = new Vector();
	
	public Vector IdArticulo     = new Vector();
	public Vector Presentacion   = new Vector();
	
	Filtro2SG filtro2 = new Filtro2SG();
	
	public Filtro2Cx(String idMunicipio){
		
		
		
		try{
			
			connectionURL = Strings.HTTP_SW+"getFiltrosBusqueda/"+idMunicipio+"/"+tipoConexion;

	        conn = (HttpConnection) Connector.open(connectionURL);
	        conn.setRequestProperty("Content-Type","application/json");
	       // System.out.println("Response code : "+conn.getResponseCode());

	        if(conn.getResponseCode() == HttpConnection.HTTP_OK)
	        {

	            is = conn.openInputStream();
	            int ch=-1;
	            bos = new ByteArrayOutputStream();
	            while((ch = is.read())!=-1)
	            {
	                bos.write(ch);
	            }
	            response = new String(bos.toByteArray(),"UTF-8");
	            
	            JSONObject objeto1 =  new  JSONObject ( response );
	            String resultado1  = objeto1.getString("response");
	            	            	            
	            JSONObject objeto2 =  new  JSONObject ( resultado1 );
	            String resultado2  =  objeto2.getString("msg");
	            
	            JSONObject objeto3 =  new  JSONObject ( resultado2 );
	            
	            JSONArray jsonArrSondeo = objeto3.getJSONArray("tiposSondeos");
			
            	for (int i = 0; i < jsonArrSondeo.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonArrSondeo.getJSONObject(i);
	            	
	            	IdTipoSondeo.addElement(childJSONObject.get("idTipoSondeo"));
	            	TipoSondeo.addElement(childJSONObject.get("tipoSondeo"));
	            
            	}
            	
            	JSONArray jsonArrPresentacion = objeto3.getJSONArray("presentacion");
    			
            	for (int i = 0; i < jsonArrPresentacion.length(); i++) {
	            	
	            	JSONObject childJSONObject = jsonArrPresentacion.getJSONObject(i);
	            	
	            	IdArticulo.addElement(childJSONObject.get("idArticulo"));
	            	Presentacion.addElement(childJSONObject.get("presentacion"));
	            
            	}
	        }
	            
	        }catch (Exception e) {
				// TODO: handle exception
			}finally{
				if(conn != null)
					try {
						conn.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(is != null)
					try {
						is.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            if(bos != null)
					try {
						bos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
			//producto.setIdProducto(IdProducto);
			//producto.setNombre(Nombre);
			filtro2.setIdTipoSondeo(IdTipoSondeo);
			filtro2.setTipoSondeo(IdTipoSondeo);
			
			filtro2.setIdArticulo(IdArticulo);
			filtro2.setPresentacion(Presentacion);
		
	}
	
}
