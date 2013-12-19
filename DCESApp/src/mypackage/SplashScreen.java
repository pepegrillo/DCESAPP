package mypackage;

import configurations.Ajustes;
import observatorioPrecio.CategoriaProductoCopiaWS;
import observatorioPrecio.FiltroBusqueda;
import estilos.Utils;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class SplashScreen extends MainScreen {
	BitmapField bmp;
	
    public SplashScreen() {
    	
        super(SplashScreen.USE_ALL_HEIGHT | SplashScreen.NO_VERTICAL_SCROLL);
        
        try{
        	
        //setTitle((LabelField)null) ; // hide screen title  
    	if (Display.getWidth() > Display.getHeight())
		{	
        bmp = new BitmapField(Utils.getFitBitmapImage("splash.png",Display.getWidth(), Display.getHeight()),BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);  
        }else if (Display.getWidth() == 360){
        bmp = new BitmapField(Utils.getFitBitmapImage("splash.png",Display.getWidth(), Display.getHeight()),BitmapField.FIELD_HCENTER | BitmapField.FIELD_VCENTER);  
	
        }        
        HorizontalFieldManager rowHolder = new HorizontalFieldManager(NO_HORIZONTAL_SCROLL | NO_VERTICAL_SCROLL| Field.FIELD_HCENTER | USE_ALL_HEIGHT );
        rowHolder.add(bmp);
        add(rowHolder);              
        }catch (Exception e){
        e.printStackTrace();

        }finally{
        	
        	MyApp.homeScreen = new MyScreen();
        	//MyApp.homeScreen = new Ajustes();
        	  
            UiApplication.getUiApplication().invokeLater(new Runnable() {			        	
				public void run() {
					
					UiApplication.getUiApplication().pushScreen(MyApp.homeScreen);
				    UiApplication.getUiApplication().popScreen(MyApp.splashScreen);					    
				}  
		            
		        }, 2000, false);
        }
    }
}
