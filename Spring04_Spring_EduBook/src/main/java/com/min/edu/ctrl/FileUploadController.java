package com.min.edu.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
 
//TODO 061
@Controller
@Slf4j
public class FileUploadController {

	@GetMapping(value = "/uploadForm.do")
	public String uploadForm(){
		log.info("FileUploadController  uploadForm.do 파일업로드 화면");
		return "uploadForm";
	}
	
	//TODO 065
	@PostMapping(value = "/upload.do")
	public String fileupload(HttpServletRequest request,Model model, 
							@RequestParam List<MultipartFile> file, String desc) {
		log.info("파일 사이즈 : {}",file.size());
		log.info("전송 form 요소 text : {}",desc);
		
		for (MultipartFile f : file) {
			log.info("파일의 이름 : {}",f.getOriginalFilename() );
			String originFileName = f.getOriginalFilename();
			String saveFileName = UUID.randomUUID().toString().concat(originFileName.substring(originFileName.indexOf(".")));
			log.info("기존 파일명 {}",originFileName);
			log.info("기존 파일명 {}",saveFileName);
			
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			String path = "";
			
			try {
				// 1)파일을 읽는다
				inputStream = f.getInputStream();
				
				//2) 저장 위치를 만든다
				path = WebUtils.getRealPath(request.getSession().getServletContext(),"/storage"); //상대경로
				String path02 = request.getSession().getServletContext().getRealPath("storage");
				log.info("저장경로 path : {}\n path02 : {}",path,path02);
				
				
				// 3) 파일 저장 위치
				File storage = new File(path);
				if (!storage.exists()) {
					storage.mkdirs();
				}
				
				//4) 저장 파일 : 저장할 파일이 없다면 생성하고 있다면 오버라이드함
				File newFile = new File(path+"/"+saveFileName);
				if (!newFile.exists()) {
					newFile.createNewFile();
				}
				
				// 5) 읽은 파일을 써주기  (저장)
				outputStream = new FileOutputStream(newFile);
				
				//6) 파일을 읽어서 대상 파일에 써줌 
				int read = 0;
				byte[] b = new byte[(int)f.getSize()];
				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b,0,read);
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			model.addAttribute("originFileName", originFileName);
			model.addAttribute("saveFileName", saveFileName);
			model.addAttribute("path", path);
		}
		
		return "uploadFile";
	}
	
	//TODO 070
	@PostMapping(value = "/download.do")
	@ResponseBody
	public byte[] download(HttpServletRequest request, //경로찾기
							HttpServletResponse response, //헤더정보 변경
							 String originFileName, //파일을 찾거나 저장파일명
							 String saveFileName) throws IOException{	//파일을 찾을때
		
		// 1) 파일을 다운로드할 파일이 있는 위치(가능하면 db에 저장)
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
		//2) 파일 위치에서 파일을 읽어 file객체로 만듦
		File file = new File(path+"/"+saveFileName);
		
		// 3) 파일명을 인코딩
//		String outputFileName = new String(file.getName().getBytes(),"8859_1"); //한글 이상하면 UTF-8로
		String outputFileName = new String("고라.png".getBytes(),"8859_1");
		
		//4) 파일을 복제하여 byte[] 읽어줌
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		
		// 5) 파일브라우저에 응답해주기
		response.setHeader("Content-Disposition", "attachment; filename=\""+outputFileName+"\"");
		response.setContentLength(bytes.length);
		response.setContentType("application/octect-stream"); //예시 ) ms word로 전송 applicatioin/msword
		
		return bytes;
	}
}

















