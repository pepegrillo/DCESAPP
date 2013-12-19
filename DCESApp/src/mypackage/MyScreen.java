package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class MyScreen extends Estilos
{
	
	int tFuente;
	Font fLite;
	
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	EmailAddressEditField txtCorreo;
	PasswordEditField txtPass;
	
	Bitmap btnInicioSesion;
	Bitmap btnInicioSesion1;
	Bitmap btnRegistro;
	Bitmap btnRegistro1;
	Bitmap btnSaltar;
	Bitmap btnSaltar1;
	
    /**
     * Creates a new MyScreen object
     */
    public MyScreen()
    {        
        // Set the displayed title of the screen       
        //setTitle("MyTitle");
    	
    	getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));    	
        
    	HorizontalFieldManager logoHfm = new HorizontalFieldManager(HorizontalFieldManager.FIELD_HCENTER);	
        Bitmap logoBm = Bitmap.getBitmapResource("logo.png");
        BitmapField logoBmf = new BitmapField(logoBm);
        logoHfm.add(logoBmf);
        add(logoHfm);
        
        tFuente = 30;
        
        try{
	        FontFamily ffFont1 = FontFamily.forName("Arial");
		 	fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
		 	
		 	VerticalFieldManager allContentInicio = new VerticalFieldManager();
		 	
		 	ColorRichText emailCrt = new ColorRichText(Strings.EMAIL,0x9cbe4f , RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT );
		 	emailCrt.setFont(fLite);
		 	emailCrt.setMargin(0, 20, 5, 50);
		 	allContentInicio.add(emailCrt);
			
			txtCorreo = new EmailAddressEditField("", "", 200,BasicEditField.JUMP_FOCUS_AT_END){
				public void paint(Graphics g){      
	                g.setColor(0xFFF);
	                super.paint(g);
	            }};
			txtCorreo.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13,5,13), bordes));
            txtCorreo.setMargin(0, 50, 0, 50);
            txtCorreo.setPadding(5,5,5,5);
            allContentInicio.add(txtCorreo);
	        
	        ColorRichText pwCrt = new ColorRichText(Strings.PWD,0x9cbe4f , RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT );
	        pwCrt.setFont(fLite);
	        pwCrt.setMargin(20, 20, 5, 50);
	        allContentInicio.add(pwCrt);
			
			txtPass = new PasswordEditField("", "", 200,BasicEditField.JUMP_FOCUS_AT_END){
				public void paint(Graphics g){      
	                g.setColor(0xFFF);
	                super.paint(g);
	            }};
	        txtPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13,5,13), bordes));
			txtPass.setMargin(0, 50, 0, 50);
            txtPass.setPadding(5,5,5,5);
            allContentInicio.add(txtPass);
                        
            add(allContentInicio);
            
            HorizontalFieldManager botonesHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonesHfc.setMargin(0, 50, 0, 0);
            
            btnInicioSesion 	= Bitmap.getBitmapResource("btnInicioSesion.png");
            btnInicioSesion1 	= Bitmap.getBitmapResource("btnInicioSesion1.png");	
            BitmapButtonField btnInicioSesionUser = new BitmapButtonField(btnInicioSesion,btnInicioSesion1,Field.FIELD_HCENTER);
            btnInicioSesionUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MenuMain());
    			}
            });
            btnInicioSesionUser.setMargin(20, 10, 0, 0);
            
            btnRegistro	    = Bitmap.getBitmapResource("btnRegistro.png");
            btnRegistro1 	= Bitmap.getBitmapResource("btnRegistro1.png");	
            BitmapButtonField btnRegistroUser = new BitmapButtonField(btnRegistro,btnRegistro1,Field.FIELD_HCENTER);
            btnRegistroUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new registroUser());
    			}
            });
            btnRegistroUser.setMargin(20, 10, 0, 0);
            
            botonesHfc.add(btnInicioSesionUser);
            botonesHfc.add(btnRegistroUser);
            add(botonesHfc);
            
            HorizontalFieldManager botonSaltarHfc = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);
            botonSaltarHfc.setMargin(0, 50, 0, 0);
            
            btnSaltar	= Bitmap.getBitmapResource("btnSaltar.png");
            btnSaltar1 	= Bitmap.getBitmapResource("btnSaltar1.png");	
            BitmapButtonField btnSaltarUser = new BitmapButtonField(btnSaltar,btnSaltar1,Field.FIELD_HCENTER);
            btnSaltarUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MenuMain());
    			}
            });
            btnSaltarUser.setMargin(10, 0, 0, 0);
            botonSaltarHfc.add(btnSaltarUser);
            add(botonSaltarHfc);
            
            
		 	
        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());
		}
    }
}
