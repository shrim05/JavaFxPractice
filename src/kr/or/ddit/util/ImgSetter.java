package kr.or.ddit.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

/**
 * 상품관련 이미지 생성 클래스
 * DB에 저장되어있는 파일이름을 매개변수를 받아
 * imageview에 넣을 수 있는 이미지파일로 반환
 * DB에 이미지파일의 이름만 저장하는 방식을 사용할 때 이용
 * @author yhKwon
 *
 */
public class ImgSetter {
	Image image = null;
	
	
	//이미지 파일을 fx imageView에 연결할 수 있는 형태로 반환
	public Image createImageview(File file) {
	
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedInputStream bis = new BufferedInputStream(fis);
		return image = new Image(bis);
	}
	
	//파일이름을 매개변수로 받아 img 폴더에서 해당 파일 선택
	public Image imageSettingByName (String fileName) {
		File file = new File(System.getProperty("user.dir")+"./img/"+fileName);
		if(file==null) {
			file = new File(System.getProperty("user.dir")+"./img/basic.jpg");
		}
		Image image = createImageview(file);
		return image;
	}
	
	//폴더를 만들어 사용할 경우, 매개변수로 폴더이름과 파일이름을 받아서 저장
	public Image ImageSettingByName (String folder, String fileName) {
		File file = new File(System.getProperty("user.dir")+"./img/"+folder+"/"+fileName);
		if(file==null) {
			file = new File(System.getProperty("user.dir")+"./img/"+folder+"/basic.png");
		}
		Image image = createImageview(file);
		return image;
	}
	
}
