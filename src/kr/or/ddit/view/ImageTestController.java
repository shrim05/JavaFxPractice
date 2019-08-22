package kr.or.ddit.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import kr.or.ddit.util.ImgChooser;
import kr.or.ddit.util.ImgOutputUtil;
import kr.or.ddit.util.PicVO;

public class ImageTestController implements Initializable {

	@FXML ImageView imgView;
	@FXML Button btnChooser;
	@FXML Button btnConfirm;
	ImgChooser imgChooser = new ImgChooser();
	ImgOutputUtil imgOutputUtil = new ImgOutputUtil();
	private PicVO pv = new PicVO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnChooser.setOnAction(e->{
			pv = imgChooser.imgPick();
			imgView.setImage(pv.getSelectedImg());
		});
		
		btnConfirm.setOnAction(e->{
			String storedFileName = imgOutputUtil.fileStore(pv.getPicFile());
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("ImageStoring");
			alert.setHeaderText("Info");
			alert.setContentText("Success to store by fileName : "+storedFileName);
			alert.showAndWait();
		});
	}
	
}
