package kr.or.ddit.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
/**
 * 이미지를 프로젝트 img 소스내에 저장해주는 메서드제공
 * @param 파일객체, 파일저장할 경로
 * @return 파일이름 
 * @author yhkwon
 */
public class ImgOutputUtil  {
	
	
	private String fileName = null; //이미지 파일의 이름
	private BufferedImage bi = null;
	private String extension = null;
	private String path = System.getProperty("user.dir");
	//저장할 파일이름을 결정해주는 메서드(중복체크 포함)
	//이미지로 저장할 파일과, 저정할 폴더 경로를 매개변수로 받는다 
	//폴더경로는 프로젝트 내 img 이름의 소스폴더
	public String fileStore(File file) {
		//매개변수로 받은 파일 이름추출
		fileName = file.getName();
		
		//사진 선택 안했을 시 기본 사진이름으로 저장(모든 기본사진은 basic.확장자)
		//FilenameUtils 객체 사용을 위해선 Apache commons-io 라이브러리 필요. 
		String basicName = FilenameUtils.removeExtension(file.getName());
		if(basicName.equals("basic")) {
			return fileName = "basic." + FilenameUtils.getExtension(fileName);
		}
		
		//확장자 추출
		extension = FilenameUtils.getExtension(fileName);
		//파일이름 중복시 1씩 증가될 카운터
		int count = 0;
		//프로젝트 내 폴더에서 파일이름이 중복되는지 확인  
		File temp = new File(path+"./img/"+fileName);
		while(temp.exists()) {
			String tempName = FilenameUtils.removeExtension(temp.getName());
			fileName = tempName.substring(0, tempName.length()-1) 
					+ ++count +"."+extension;
			temp = new File(path+"./img/"+fileName);
		}
		
		try {
			bi = ImageIO.read(file);
			ImageIO.write(bi, extension, new File(path+"./img/"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//성공적으로 저장되면 파일이름 반환
		//이 이름을 해당되는 vo객체에 담아 db에 저장해 쓰면됨
		return fileName;
	}
	
	public String fileStoreToSpecificFolder(File file, String folderName) {
		//매개변수로 받은 파일 이름추출
		fileName = file.getName();
		
		//사진 선택 안했을 시 기본 사진이름으로 저장(모든 기본사진은 basic.확장자)
		String basicName = FilenameUtils.removeExtension(file.getName());
		if(basicName.equals("basic")) {
			return fileName = "basic." + FilenameUtils.getExtension(fileName);
		}
		
		//확장자 추출
		extension = FilenameUtils.getExtension(fileName);
		//파일이름 중복시 1씩 증가될 카운터
		int count = 0;
		//프로젝트 내 폴더에서 파일이름이 중복되는지 확인  
		File temp = new File(path+"./img/"+folderName+"/"+fileName);
		while(temp.exists()) {
			String tempName = FilenameUtils.removeExtension(temp.getName());
			fileName = tempName.substring(0, tempName.length()-1) 
						+ ++count +"."+extension;
			temp = new File(path+"./img/"+folderName+"/"+fileName);
		}
		
		try {
			bi = ImageIO.read(file);
			ImageIO.write(bi, extension, new File(path+"./img/"+folderName+"/"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//성공적으로 저장되면 파일이름 반환
		//이 이름을 해당되는 vo객체에 담아 db에 저장해 쓰면됨
		return fileName;
	}
}
