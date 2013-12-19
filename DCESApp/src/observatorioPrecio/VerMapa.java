package observatorioPrecio;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.browser.field2.BrowserFieldConfig;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import configurations.Strings;
import estilos.Estilos;

public class VerMapa extends Estilos {
	
	int tFuente2;
	Font fTitle;
	
	private BrowserField browser;
	private String urlImagen;
	
	String tipoConexion = configurations.ConexionController.getConnectionString()[0];
	String getTipo = configurations.ConexionController.getConnectionString()[1];
	
	public VerMapa(String latitudSt, String longitudSt){
		
		float latitudInt  = Float.parseFloat(latitudSt);
		float longitudInt = Float.parseFloat(longitudSt);
		
		urlImagen = "http://maps.googleapis.com/maps/api/staticmap?center="+latitudInt+","+longitudInt+"&zoom=14&size=400x400&maptype=roadmap&sensor=true";
		
		try{ 
			
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.CATEGORIA,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);
			
			VerticalField footerLogoHfm = new VerticalField(Display.getWidth(),20,VerticalFieldManager.FIELD_HCENTER);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			//Lista Categoria
			VerticalField allContentMap = new VerticalField(Display.getWidth(),347,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			if(getTipo.equals("wifi") || getTipo.equals("BIBS")){
				BrowserFieldConfig myBrowserFieldConfig = new BrowserFieldConfig();
				myBrowserFieldConfig.setProperty(BrowserFieldConfig.NAVIGATION_MODE,BrowserFieldConfig.NAVIGATION_MODE_NONE);
				myBrowserFieldConfig.setProperty(BrowserFieldConfig.ALLOW_CS_XHR, Boolean.TRUE);
				myBrowserFieldConfig.setProperty(BrowserFieldConfig.JAVASCRIPT_ENABLED, Boolean.TRUE);
				myBrowserFieldConfig.setProperty(BrowserFieldConfig.ENABLE_COOKIES,Boolean.TRUE);
				browser = new BrowserField(myBrowserFieldConfig);
				browser.displayContent("<img width='100%' src='"+urlImagen+"'/>","http://localhost");	
				allContentMap.add(browser);
				
			}else{
				BitmapField imagenCoo = new BitmapField(
				Bitmap.getBitmapResource("logo.png"), BitmapField.FIELD_HCENTER);
				allContentMap.add(imagenCoo);
			}
			
			
		    /*MapField map = new MapField();
		    MapAction action = map.getAction();
		    action.setCentreAndZoom(new MapPoint(latitudInt, longitudInt), 3);   
		    
		    allContentMap.add(map);*/
		    add(allContentMap);
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
    
	}
}
