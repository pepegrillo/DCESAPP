package mypackage;

import listaProductos.ListaProductos;
import listaProductos.ProductosCotizar;
import observatorioPrecio.CategoriaProducto;
import observatorioPrecio.CategoriaProductoSearcherDemo;
import observatorioPrecio.CategoriaProductoCopiaWS;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Ajustes;

import estilos.Estilos;
import favoritos.FavoritoProducto;

public class MenuMain extends Estilos {
	
	Bitmap btnObservatorioPrecio;
	Bitmap btnObservatorioPrecio1;
	Bitmap btnListaCompra;
	Bitmap btnListaCompra1;
	Bitmap btnTemporada;
	Bitmap btnTemporada1;
	Bitmap btnFavoritos;
	Bitmap btnFavoritos1;
	Bitmap btnAjustes;
	Bitmap btnAjustes1;
	
	public MenuMain() {

		try {
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background_menu.png")));
			
			VerticalField allContentInicio = new VerticalField(Display.getWidth(),434,VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
			allContentInicio.setMargin(23, 0, 0, 0);
			
			//Menu Options
			VerticalFieldManager contentMenuMain = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER | VerticalFieldManager.FIELD_VCENTER);
			contentMenuMain.setMargin(17, 0, 10, 105);
			
			btnObservatorioPrecio	= Bitmap.getBitmapResource("btnObservatorioPrecio.png");
			btnObservatorioPrecio1 	= Bitmap.getBitmapResource("btnObservatorioPrecio1.png");	
            BitmapButtonField btnObservatorioPrecioUser = new BitmapButtonField(btnObservatorioPrecio,btnObservatorioPrecio1);
            btnObservatorioPrecioUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new CategoriaProducto());
    			}
            });            
            contentMenuMain.add(btnObservatorioPrecioUser);
            
            btnListaCompra	= Bitmap.getBitmapResource("btnListaCompra.png");
            btnListaCompra1 	= Bitmap.getBitmapResource("btnListaCompra1.png");	
            BitmapButtonField btnListaCompraUser = new BitmapButtonField(btnListaCompra,btnListaCompra1);
            btnListaCompraUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new ListaProductos());
    			}
            });            
            contentMenuMain.add(btnListaCompraUser);
            
            btnTemporada	= Bitmap.getBitmapResource("btnTemporada.png");
            btnTemporada1 	= Bitmap.getBitmapResource("btnTemporada1.png");	
            BitmapButtonField btnTemporadaUser = new BitmapButtonField(btnTemporada,btnTemporada1);
            btnTemporadaUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new ProductosCotizar());
    			}
            });            
            contentMenuMain.add(btnTemporadaUser);
            
            btnFavoritos	= Bitmap.getBitmapResource("btnFavoritos.png");
            btnFavoritos1 	= Bitmap.getBitmapResource("btnFavoritos1.png");	
            BitmapButtonField btnFavoritosUser = new BitmapButtonField(btnFavoritos,btnFavoritos1);
            btnFavoritosUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new FavoritoProducto());
    			}
            });            
            contentMenuMain.add(btnFavoritosUser);
            
            btnAjustes	= Bitmap.getBitmapResource("btnAjustes.png");
            btnAjustes1 	= Bitmap.getBitmapResource("btnAjustes1.png");	
            BitmapButtonField btnAjustesUser = new BitmapButtonField(btnAjustes,btnAjustes1);
            btnAjustesUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new Ajustes());
    			}
            });
            contentMenuMain.add(btnAjustesUser);
            
            allContentInicio.add(contentMenuMain);
            add(allContentInicio);
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
