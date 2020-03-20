package com.lc.ImagesService.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lc.ImagesService.Repository.ImgRepository;
import com.lc.ImagesService.bean.ImageBean;
import com.lc.ImagesService.bean.ResponseBean;
import com.lc.ImagesService.entity.ImagesEntity;

/**
 * @author DELL
 *
 */
@RestController
@RequestMapping(value="/img/v1")
public class Img {
	
	@Autowired
	ImgRepository imgRepository;


	@PostMapping(value="/upload",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(@RequestParam("img") MultipartFile[] img ,@RequestParam("productid") long productid) throws FileSizeLimitExceededException 
	{
		ResponseBean responseBean = null;
		try {
			/*
			 * File rootFolder = new File("../"); if(!rootFolder.exists()) {
			 * rootFolder.mkdir(); System.out.println("36"); }
			 */
	//	File rootNextFolder = new File(rootFolder.getAbsolutePath()+"/"+productid);
			File rootNextFolder = new File(productid+"");
		if(!rootNextFolder.isDirectory()) {
			//rootNextFolder = new File(rootFolder.getAbsolutePath()+"/"+productid);
			rootNextFolder = new File(productid+"");
			rootNextFolder.mkdir();
			System.out.println("40");
		}
		StringBuilder sb=new StringBuilder();
		//System.out.println("fghfhgad");
		List<ImagesEntity> entities = new CopyOnWriteArrayList<ImagesEntity>();
		for(MultipartFile file:img)
		{
			System.out.println("fghfhgad");
			Path filepath =Paths.get(rootNextFolder.toString(),file.getOriginalFilename());
			sb.append(file.getOriginalFilename());
			Files.write(filepath,file.getBytes());
			System.out.println(filepath);
			entities.add(new ImagesEntity(productid,filepath.toString()));
		}	
			imgRepository.saveAll(entities);
			responseBean = new ResponseBean("Success",2000, System.currentTimeMillis());
//			ImagesEntity images=new ImagesEntity(productid,filepath.toString());
//			images=imgRepository.save(images);
		}
		catch(IOException e)
		{
			responseBean = new ResponseBean(e.getMessage(), 4000,System.currentTimeMillis());
			//e.printStackTrace();
		}
		
		return new ResponseEntity<ResponseBean>(responseBean,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getallimg")
	@ResponseBody
	public ResponseEntity<List<ImagesEntity>> getimg()
	{
		List<ImagesEntity> img=(List<ImagesEntity>)imgRepository.findAll();
		return new ResponseEntity<List<ImagesEntity>>(img,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value="/getbyid/{imgid}")
	@ResponseBody
	public ResponseEntity<Optional<ImagesEntity>> getbyid(@PathVariable long imgid)
	{
		Optional<ImagesEntity> img=imgRepository.findById(imgid);
		return new ResponseEntity<Optional<ImagesEntity>>(img,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(value="/getallimg1/{productid}")
	@ResponseBody
	public ResponseEntity<List<ImagesEntity>> getimgByProductid(@PathVariable long productid)
	{
		System.out.println("Hitting....112 Path variable:"+productid);
		List<ImagesEntity> img=(List<ImagesEntity>) imgRepository.find(productid);
		System.out.println(img);
		return new ResponseEntity<List<ImagesEntity>>(img,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/getimgs/{productid}")
			//,	  produces = MediaType.IMAGE_JPEG_VALUE )
	@ResponseBody
	public ResponseEntity<List<ImageBean>> getImageFile(@PathVariable long productid)throws IOException
	{
		List<ImageBean> imgs = new ArrayList<>();
		HttpHeaders headers = new HttpHeaders();
		System.out.println("Hitting....112 Path variable:"+productid);
		List<ImagesEntity> img=(List<ImagesEntity>) imgRepository.find(productid);
		for(ImagesEntity ie: img)
		{
			System.out.println("Hitting....130 Path variable:"+ie.getImgurl());
			InputStream is = new FileInputStream(ie.getImgurl());
			BufferedImage imgee = ImageIO.read(is);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(imgee, "jpg", bos);
			imgs.add(new ImageBean(ie.getImgid(), ie.getProductid(),bos.toByteArray()));
		}
		System.out.println("Size:"+imgs.size()+"-----"+imgs);
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		return new ResponseEntity<List<ImageBean>>(imgs,headers,HttpStatus.ACCEPTED);
	}
}
