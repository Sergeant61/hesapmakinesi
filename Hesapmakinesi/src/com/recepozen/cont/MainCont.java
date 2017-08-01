package com.recepozen.cont;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainCont extends Application implements Initializable {

	private Stage primaryStage;

	@FXML
	private Button bt_0;
	@FXML
	private Button bt_1;
	@FXML
	private Button bt_2;
	@FXML
	private Button bt_3;
	@FXML
	private Button bt_4;
	@FXML
	private Button bt_5;
	@FXML
	private Button bt_6;
	@FXML
	private Button bt_7;
	@FXML
	private Button bt_8;
	@FXML
	private Button bt_9;
	@FXML
	private Button bt_c;
	@FXML
	private Button bt_ca;
	@FXML
	private Button bt_b;
	@FXML
	private Button bt_t;
	@FXML
	private Button bt_e;
	@FXML
	private Button bt_cý;
	@FXML
	private Label lb;
	@FXML
	private Label lb1;

	private enum HesapMak {
		Cikar, Topla, Bol, Carp
	}

	private HesapMak hesapMak;
	private Double sayi1, sonuc;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Hesap Makinesi");
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/com/recepozen/view/main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("file:icon.png"));
			primaryStage.show();
			this.primaryStage = primaryStage;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void onClick(ActionEvent e) {

		if (e.getSource() == bt_0) {
			lb.setText(lb.getText() + "0");
		}
		if (e.getSource() == bt_1) {
			lb.setText(lb.getText() + "1");
		}
		if (e.getSource() == bt_2) {
			lb.setText(lb.getText() + "2");
		}
		if (e.getSource() == bt_3) {
			lb.setText(lb.getText() + "3");
		}
		if (e.getSource() == bt_4) {
			lb.setText(lb.getText() + "4");
		}
		if (e.getSource() == bt_5) {
			lb.setText(lb.getText() + "5");
		}
		if (e.getSource() == bt_6) {
			lb.setText(lb.getText() + "6");
		}
		if (e.getSource() == bt_7) {
			lb.setText(lb.getText() + "7");
		}
		if (e.getSource() == bt_8) {
			lb.setText(lb.getText() + "8");
		}
		if (e.getSource() == bt_9) {
			lb.setText(lb.getText() + "9");
		}

		if (e.getSource() == bt_c) {
			lb.setText("");
			lb1.setText("");
			sayi1 = 0d;
			sonuc = 0d;
		}
		if (e.getSource() == bt_ca) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Carp;
				lb1.setText(Double.toString(sayi1) + " *");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Carp;
				lb1.setText(lb.getText() + " *");
				lb.setText("");
			}
		}
		if (e.getSource() == bt_b) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Bol;
				lb1.setText(Double.toString(sayi1) + " /");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Bol;
				lb1.setText(lb.getText() + " /");
				lb.setText("");
			}
		}
		if (e.getSource() == bt_t) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Topla;
				lb1.setText(Double.toString(sayi1) + " +");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Topla;
				lb1.setText(lb.getText() + " +");
				lb.setText("");
			}
		}
		if (e.getSource() == bt_cý) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Cikar;
				lb1.setText(Double.toString(sayi1) + " -");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Cikar;
				lb1.setText(lb.getText() + " -");
				lb.setText("");
			}
		}
		if (e.getSource() == bt_t) {

			if (!lb.getText().equals("")) {

				if (hesapMak == HesapMak.Topla) {
					sonuc = sayi1 + Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Cikar) {
					sonuc = sayi1 - Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Bol) {
					sonuc = sayi1 / Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Carp) {
					sonuc = sayi1 * Double.valueOf(lb.getText());
				}

				lb.setText(sonuc.toString());
				lb1.setText("");
			}

		}

	}

	@FXML
	public void onKeyPress(KeyEvent e) {

		if (e.getText().equals("0")) {
			lb.setText(lb.getText() + "0");
		}
		if (e.getText().equals("1")) {
			lb.setText(lb.getText() + "1");
		}
		if (e.getText().equals("2")) {
			lb.setText(lb.getText() + "2");
		}
		if (e.getText().equals("3")) {
			lb.setText(lb.getText() + "3");
		}
		if (e.getText().equals("4")) {
			lb.setText(lb.getText() + "4");
		}
		if (e.getText().equals("5")) {
			lb.setText(lb.getText() + "5");
		}
		if (e.getText().equals("6")) {
			lb.setText(lb.getText() + "6");
		}
		if (e.getText().equals("7")) {
			lb.setText(lb.getText() + "7");
		}
		if (e.getText().equals("8")) {
			lb.setText(lb.getText() + "8");
		}
		if (e.getText().equals("9")) {
			lb.setText(lb.getText() + "9");
		}

		if (e.getCode().equals(KeyCode.DELETE)) {
			lb.setText("");
			lb1.setText("");
			sayi1 = 0d;
			sonuc = 0d;
		}
		if (e.getText().equals("*")) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Carp;
				lb1.setText(Double.toString(sayi1) + " *");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Carp;
				lb1.setText(lb.getText() + " *");
				lb.setText("");
			}
		}
		if (e.getText().equals("/")) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Bol;
				lb1.setText(Double.toString(sayi1) + " /");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Bol;
				lb1.setText(lb.getText() + " /");
				lb.setText("");
			}
		}
		if (e.getText().equals("+")) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Topla;
				lb1.setText(Double.toString(sayi1) + " +");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Topla;
				lb1.setText(lb.getText() + " +");
				lb.setText("");
			}
		}
		if (e.getText().equals("-")) {

			if (!lb1.getText().equals("")) {
				sonucHesapla();
				hesapMak = HesapMak.Cikar;
				lb1.setText(Double.toString(sayi1) + " -");
				lb.setText("");
			} else if (!lb.getText().equals("")) {
				sayi1 = Double.valueOf(lb.getText());
				hesapMak = HesapMak.Cikar;
				lb1.setText(lb.getText() + " -");
				lb.setText("");
			}
		}
		if (e.getCode().equals(KeyCode.ENTER)) {

			if (!lb.getText().equals("")) {

				if (hesapMak == HesapMak.Topla) {
					sonuc = sayi1 + Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Cikar) {
					sonuc = sayi1 - Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Bol) {
					sonuc = sayi1 / Double.valueOf(lb.getText());
				}
				if (hesapMak == HesapMak.Carp) {
					sonuc = sayi1 * Double.valueOf(lb.getText());
				}

				lb.setText(sonuc.toString());
				lb1.setText("");
			}

		}
	}

	private void sonucHesapla() {
		if (hesapMak == HesapMak.Topla) {
			sayi1 = (sayi1 + Double.valueOf(lb.getText()));
		}
		if (hesapMak == HesapMak.Cikar) {
			sayi1 = (sayi1 - Double.valueOf(lb.getText()));
		}
		if (hesapMak == HesapMak.Bol) {
			sayi1 = (sayi1 / Double.valueOf(lb.getText()));
		}
		if (hesapMak == HesapMak.Carp) {
			sayi1 = (sayi1 * Double.valueOf(lb.getText()));
		}
	}

}