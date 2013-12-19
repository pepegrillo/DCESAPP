package mypackage;

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
import net.rim.device.api.ui.component.EmailAddressEditField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.BorderFactory;

import com.samples.toolkit.ui.component.BitmapButtonField;

import configurations.Strings;
import estilos.Estilos;

public class registroUser extends Estilos {

	int tFuente;
	Font fLite;
	int tFuente2;
	Font fTitle;
	
//	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt"+i+".png");
	Bitmap bordes = Bitmap.getBitmapResource("bordes_txt.png");
	BasicEditField txtName;
	EmailAddressEditField txtEmails;
	PasswordEditField txtPass;
	PasswordEditField txtRePass;
	
	Bitmap btnAceptarReg;
	Bitmap btnAceptarReg1;

	public registroUser() {

		try {

			tFuente = 30;
			tFuente2 = 40;
			FontFamily ffFont1 = FontFamily.forName("Arial");
			fLite = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente);
			fTitle = ffFont1.getFont(Font.SANS_SERIF_STYLE, tFuente2);
			
			getMainManager().setBackground(BackgroundFactory.createBitmapBackground(Bitmap.getBitmapResource("background.png")));
			
			VerticalFieldManager logoHfm = new VerticalFieldManager(VerticalFieldManager.FIELD_HCENTER);
			logoHfm.setBackground(BackgroundFactory.createLinearGradientBackground(0xe2ab32, 0xe2ab32,0xdc9730, 0xdc9730));
			logoHfm.setMargin(24, 0, 0, 0);

			ColorRichText emailCrt = new ColorRichText(Strings.REGISTRO,0xffffff, RichTextField.FIELD_HCENTER | RichTextField.TEXT_ALIGN_HCENTER);
			emailCrt.setFont(fTitle);
			emailCrt.setMargin(25, 0, 25, 0);

			logoHfm.add(emailCrt);
			add(logoHfm);
			
			VerticalField allContentInicio = new VerticalField(Display.getWidth(),343,VerticalField.VERTICAL_SCROLL | VerticalField.VERTICAL_SCROLLBAR);
						

			// Formulario
			VerticalFieldManager contentForm = new VerticalFieldManager();

			ColorRichText nameCrt = new ColorRichText(Strings.NAME, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			nameCrt.setFont(fLite);
			nameCrt.setMargin(20, 20, 5, 50);
			contentForm.add(nameCrt);

			txtName = new BasicEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtName.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtName.setMargin(0, 50, 0, 50);
			txtName.setPadding(5, 5, 5, 5);
			contentForm.add(txtName);
			
			
			ColorRichText emailsCrt = new ColorRichText(Strings.EMAILS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			emailsCrt.setFont(fLite);
			emailsCrt.setMargin(20, 20, 5, 50);
			contentForm.add(emailsCrt);

			txtEmails = new EmailAddressEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtEmails.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtEmails.setMargin(0, 50, 0, 50);
			txtEmails.setPadding(5, 5, 5, 5);
			contentForm.add(txtEmails);
			
			
			ColorRichText pwCrt = new ColorRichText(Strings.PWDS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			pwCrt.setFont(fLite);
			pwCrt.setMargin(20, 20, 5, 50);
			contentForm.add(pwCrt);

			txtPass = new PasswordEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtPass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtPass.setMargin(0, 50, 0, 50);
			txtPass.setPadding(5, 5, 5, 5);
			contentForm.add(txtPass);
			
			
			ColorRichText rePwCrt = new ColorRichText(Strings.RPWDS, 0x9cbe4f, RichTextField.FIELD_LEFT | RichTextField.TEXT_ALIGN_LEFT);
			rePwCrt.setFont(fLite);
			rePwCrt.setMargin(20, 20, 5, 50);
			contentForm.add(rePwCrt);

			txtRePass = new PasswordEditField("", "", 200, BasicEditField.JUMP_FOCUS_AT_END) {
				public void paint(Graphics g) {
					g.setColor(0xFFF);
					super.paint(g);
				}
			};
			txtRePass.setBorder(BorderFactory.createBitmapBorder(new XYEdges(5,13, 5, 13), bordes));
			txtRePass.setMargin(0, 50, 0, 50);
			txtRePass.setPadding(5, 5, 5, 5);
			contentForm.add(txtRePass);
			
			btnAceptarReg	= Bitmap.getBitmapResource("btnAceptarReg.png");
			btnAceptarReg1 	= Bitmap.getBitmapResource("btnAceptarReg1.png");	
            BitmapButtonField btnAceptarRegUser = new BitmapButtonField(btnAceptarReg,btnAceptarReg1,Field.FIELD_HCENTER);
            btnAceptarRegUser.setChangeListener( new FieldChangeListener( ) {
    			public void fieldChanged( Field field, int context ) {
    				UiApplication.getUiApplication().pushScreen(new MyScreen());
    			}
            });
            btnAceptarRegUser.setMargin(25, 10, 25, 0);
            contentForm.add(btnAceptarRegUser);
			
			
			allContentInicio.add(contentForm);
			add(allContentInicio);
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
