package br.com.erudio.data.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UploadFileResponseVO implements Serializable{
	private static final long serialVersionUID = -1664323312319835409L;
	
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
			
	
}
