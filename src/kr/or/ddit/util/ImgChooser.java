package kr.or.ddit.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * @return 사진 저장에 필요한 변수를 갖고 있는 VO 
 * (VO 변수 = > 이미지뷰에 넣을 수 있는 image selectedImg, DB에 저장할 이름 picName, 
 * 프로젝트 내 img 폴더에 저장하기위해 필요한 file picFile  
 * @author yhk
 */
public class ImgChooser {
	private File imgFile = null;
	private Image selectedImg = null;
	private FileChooser fc = null;
	private PicVO ppv = null;
	
	public PicVO imgPick(){
		//로컬저장소에 있는 파일을 선택할 수 있는 filechooser 객체 생성
		fc = new FileChooser();
		fc.setTitle("이미지 선택");
		fc.setInitialDirectory(new File("c:/")); //파일열기 시작지점
		 //파일 타입제한
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg","*.gif","*.png");
		fc.getExtensionFilters().add(imgType);
		//창을 띄우는 위치
		imgFile = fc.showOpenDialog(null);
		//아무파일도 선택 안했을 때
		if(imgFile == null) {
			imgFile = new File(System.getProperty("user.dir")+"./img/basic.jpg");
			//파일 읽기
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(imgFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedInputStream bis = new BufferedInputStream(fis);
			//이미지 생성
			selectedImg = new Image(bis);
			ppv = new PicVO(imgFile.getName(), selectedImg, imgFile);
		}else {
			try {
				FileInputStream fis = new FileInputStream(imgFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				selectedImg = new Image(bis);
				ppv = new PicVO(imgFile.getName(), selectedImg, imgFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return ppv;
	}
	
}
