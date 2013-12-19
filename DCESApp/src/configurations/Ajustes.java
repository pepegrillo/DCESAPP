package configurations;

import observatorioPrecio.Producto;

import com.samples.toolkit.ui.component.BitmapButtonField;

import estilos.Estilos;
import estilos.FullWidthChoiceField;
import estilos.Estilos.ColorRichText;
import estilos.Estilos.HorizontalField;
import estilos.Estilos.VerticalField;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.XYEdges;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

public class Ajustes extends Estilos {

	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
	Bitmap btnLogout;
	Bitmap btnLogout1;
	Bitmap btnPuntosMapa;
	Bitmap btnPuntosMapa1;
	Bitmap btnChangePw;
	Bitmap btnChangePw1;
	
	public Ajustes(){
		
		try{
			
			tFuente = 35;
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_RIGHT | HorizontalFieldManager.FIELD_RIGHT);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe68241, 0xe68241,0xd16f2f, 0xd16f2f));
			logoHfm.setMargin(0, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.PRODUCTO,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);
			
			HorizontalField footerLogoHfm = new HorizontalField(Display.getWidth(),60,HorizontalFieldManager.FIELD_RIGHT);
			footerLogoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0x9cbe4f, 0x7a9b3c, 0x7a9b3c, 0x9cbe4f));
			
			HorizontalFieldManager logoutHfm = new HorizontalFieldManager(HorizontalFieldManager.FIELD_RIGHT);			
			btnLogout	= Bitmap.getBitmapResource("btnLogout.png");
			btnLogout1 	= Bitmap.getBitmapResource("btnLogout1.png");
            BitmapButtonField btnSearchUser = new BitmapButtonField(btnLogout,btnLogout1,Field.FIELD_RIGHT);
            btnSearchUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				//UiApplication.getUiApplication().pushScreen(new Producto());
    			}
            });     
            btnSearchUser.setMargin(8, 0, 0, 440);
            logoutHfm.add(btnSearchUser);
            footerLogoHfm.add(logoutHfm);
            
            //logoHfm.add(logoutHfm);
			logoHfm.add(footerLogoHfm);
			
			add(logoHfm);
			
			
			//Lista Categoria
			VerticalField allContentAjustes = new VerticalField(Display.getWidth(),307,HorizontalField.FIELD_HCENTER | VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			
			Bitmap logoList = Bitmap.getBitmapResource("vistaMapa.png");
	        BitmapField logoListaf = new BitmapField(logoList);   
	        allContentAjustes.add(logoListaf);
	        
	        btnPuntosMapa	= Bitmap.getBitmapResource("btnPuntosMapa.png");
			btnPuntosMapa1 	= Bitmap.getBitmapResource("btnPuntosMapa1.png");
            BitmapButtonField btnPuntosMapaUser = new BitmapButtonField(btnPuntosMapa,btnPuntosMapa1,Field.FIELD_HCENTER);
            btnPuntosMapaUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new CambiarPuntosMap());
    			}
            });
            btnPuntosMapaUser.setMargin(20,0,0,0);
            allContentAjustes.add(btnPuntosMapaUser);
            
                        
            btnChangePw	= Bitmap.getBitmapResource("btnChangePw.png");
            btnChangePw1 	= Bitmap.getBitmapResource("btnChangePw1.png");
            BitmapButtonField btnChangePwUser = new BitmapButtonField(btnChangePw,btnChangePw1,Field.FIELD_HCENTER);
            btnChangePwUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				//UiApplication.getUiApplication().pushScreen(new Producto());
    			}
            });
            btnChangePwUser.setMargin(20,0,20,0);
            allContentAjustes.add(btnChangePwUser);
			
            add(allContentAjustes);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			add(new RichTextField(e.getMessage()));
		}
		
	}
	
}
