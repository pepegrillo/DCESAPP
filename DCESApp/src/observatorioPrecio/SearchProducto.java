package observatorioPrecio;

import java.util.Vector;

import pck_WS.CategoriaProductoCx;
import pck_WS.ProductoCx;
import pck_WS.SearchProductoCx;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.DrawStyle;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;
import com.samples.toolkit.ui.component.ListStyleButtonField;

import configurations.Strings;
import estilos.Estilos;
import estilos.Estilos.ORichTextField;

public class SearchProducto extends Estilos implements FieldChangeListener {
	
	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap arrow = Bitmap.getBitmapResource( "arrow.png" );
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txtsearch.png");
	
	BasicEditField txtSearch;
	
	Bitmap btnSearch;
	Bitmap btnSearch1;
	
	Vector vLista   = new Vector();
	
	int idCategoria;
	String IdProductoMain;
	
	SearchProductoCx searchproducto;
	
	public SearchProducto(int idcategoria, String PalabraFiltro){
		idCategoria = idcategoria;
		
		searchproducto = new SearchProductoCx(idcategoria, PalabraFiltro);
		
		try{
			
			tFuente = 35;
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText("Palabra clave: "+PalabraFiltro,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);
			
			HorizontalField footerLogoHfm = new HorizontalField(Display.getWidth(),20,HorizontalFieldManager.FIELD_HCENTER | VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			
            
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//Lista Producto
			VerticalField allContentListaProducto = new VerticalField(Display.getWidth(),347,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			if (searchproducto.errorCode.equals("0")){
			
				for (int i = 0; i < searchproducto.IdProducto.size(); i++){
	
					
					HorizontalField contentListProducto = new HorizontalField(600, 110, HorizontalField.FIELD_HCENTER);
					//contentListProducto.setBackground((Background) vColores.elementAt(i));
					
					contentListProducto.setBorder(BorderFactory.createBitmapBorder(new XYEdges(0,8,0,8), Bitmap.getBitmapResource("bgProduct.png")));
					contentListProducto.setMargin(15,0,15,13);
					contentListProducto.setPadding(0,0,0,0);
					//contentListProducto.setBorder(BorderFactory.createRoundedBorder(new XYEdges(5,5,5,5)));
	
			        
			        vLista.addElement(new ListStyleButtonField(null,searchproducto.Nombre.elementAt(i).toString() , arrow,DrawStyle.ELLIPSIS){
			            public int getPreferredWidth(){return Display.getWidth()-40;}
			            public int getPreferredHeight(){return 90;}
			            public void layout( int maxWidth, int maxHeight )
			            {
			                super.layout(getPreferredWidth(),getPreferredHeight());
			                setExtent(getPreferredWidth(), getPreferredHeight());
			            }
			            public void paint(Graphics g)
						{
							g.setColor(0xffffff);
							super.paint(g);
						}
		            });
		            
		    	    ((Field) vLista.elementAt(i)).setChangeListener(this);
		    	    ((Field) vLista.elementAt(i)).setMargin(10,0,0,0);
		    	    
		    	    contentListProducto.add(((Field) vLista.elementAt(i)));
		    	    allContentListaProducto.add(contentListProducto);
				}
			}else{
				ORichTextField errorM = new ORichTextField(searchproducto.errorMessage, RichTextField.FIELD_HCENTER | RichTextField.FIELD_VCENTER | RichTextField.TEXT_ALIGN_LEFT);
				errorM.setFont(fTitle);
				//errorM.setMargin(20, 0, 5, 20);
				allContentListaProducto.add(errorM);
			}
	        
	        add(allContentListaProducto);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		
		for(int j=0;j<=vLista.size()-1;j++){
			if( vLista.elementAt(j)== field ){
				IdProductoMain = searchproducto.IdProducto.elementAt(j).toString();
				//pushScreen(new MenuMain());
				UiApplication.getUiApplication().pushScreen(new FiltroBusqueda(idCategoria, IdProductoMain));
			}
		}
		
	}

}
