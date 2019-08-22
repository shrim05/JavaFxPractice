package kr.or.ddit.util;

import java.io.File;
import java.io.Serializable;

import javafx.scene.image.Image;

public class PicVO  implements Serializable{
	private String picName;
	private Image selectedImg;
	private File picFile;
	
	
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public Image getSelectedImg() {
		return selectedImg;
	}
	public void setSelectedImg(Image selectedImg) {
		this.selectedImg = selectedImg;
	}
	public File getPicFile() {
		return picFile;
	}
	public void setPicFile(File picFile) {
		this.picFile = picFile;
	}
	public PicVO(String picName, Image selectedImg, File picFile) {
		super();
		this.picName = picName;
		this.selectedImg = selectedImg;
		this.picFile = picFile;
	}
	public PicVO() {
		super();
	}
	
}