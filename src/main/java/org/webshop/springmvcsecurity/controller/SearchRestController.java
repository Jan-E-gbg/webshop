package org.webshop.springmvcsecurity.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.webshop.document.search.service.CompanyImgDocService;
import org.webshop.hibernate.service.ProductModelService;
import org.webshop.search.model.CollectionOfModel;
import org.webshop.search.model.Company;
import org.webshop.search.model.CompanyImgAndDoc;
import org.webshop.search.model.ProductModel;
import org.webshop.search.model.ProductName;
import org.webshop.search.model.ScreenSize;
import org.webshop.search.service.SearchService;
import org.webshop.springmvcsecurity.authentication.facade.AuthenticationFacade;
import org.webshop.springmvcsecurity.model.LoginUser;


@RequestMapping(value = "/restmain")
@RestController
@EnableWebMvc

@CrossOrigin(origins = {"http://localhost:4200"})
public class SearchRestController extends BaseController{
	
	@Autowired
	SearchService sourceService;
	
	@Autowired
	ProductModelService productModelService;
	
	
	@Autowired
	private CompanyImgDocService companyImgDocService;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;

	
	
	@RequestMapping(value = "/authentication" , method = RequestMethod.GET)
	public ResponseEntity <List<LoginUser>> getUser(){
		
		List<LoginUser> currentUser = authenticationFacade.getAuthenticationUser();
		
		System.out.println("currentUser " + currentUser.get(0).getUser());
		
		return new ResponseEntity<List<LoginUser>>(currentUser,HttpStatus.OK);
	}

	@RequestMapping(value = "/listAllCompanys" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Company>> listAllCompanys() {
        List<Company> companys = sourceService.getListOfCompanys();
        
        companys.add(0,new Company(" ", "Choice"));
        
        System.out.println("all companys");
        
        return new ResponseEntity<List<Company>>(companys , HttpStatus.OK);
    }
	
	@RequestMapping(value = "/listAllScreenSizes" , method = RequestMethod.GET)
	public ResponseEntity<List<ScreenSize>> listAllScreenSizes(){
		List<ScreenSize> screenSizes = sourceService.getListOfSizes();
		
		System.out.println("screenSizes " +  screenSizes.size());
		
		return new ResponseEntity<List<ScreenSize>>(screenSizes , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listAllProductNames" , method = RequestMethod.GET)
	public ResponseEntity<List<ProductName>> listAllProductNames(){
		
		List<ProductName> productNames = sourceService.getListOfProductNames();
		return new ResponseEntity<List<ProductName>>(productNames,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/listCompanyModels/{company_id}" , method = RequestMethod.GET)
	public ResponseEntity<List<CollectionOfModel>> getCompanyModels(@PathVariable("company_id") long company_id){
		
		System.out.println("ld " + company_id );
		
		int size =	productModelService.findAllByCompanyId((int) company_id).size();
		
		List<ProductModel> productModel = productModelService.findAllByCompanyId((int) company_id);
		ProductModel model = productModel.get(0);
		System.out.println(" CompanyName " + model.getCompanyModel().getCompanyName());
		
		//productModel
		
		System.out.println("size of companys " + size);
		List<CollectionOfModel> collectionOfModel = sourceService.getAllModels(company_id);
		
		System.out.println("ld " + company_id + " size " + collectionOfModel.size());
		
		return new ResponseEntity<List<CollectionOfModel>>(collectionOfModel,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/modelItem/{productId}", method = RequestMethod.PUT)
	public ResponseEntity <CollectionOfModel> updateProductModel(@PathVariable("productId") long productId ,@RequestBody @Validated CollectionOfModel collectionOfModel , BindingResult result){
		
		companyImgDocService.updateProcuctModel(collectionOfModel);		
		System.out.println(" Id " + collectionOfModel.getProductId());
		System.out.println("size_id " + collectionOfModel.getModell_size_id());
		System.out.println("pris  " + collectionOfModel.getModellPris());
		System.out.println("companyId   " + collectionOfModel.getCompany_id());
		System.out.println("info   " + collectionOfModel.getModell_info());
		System.out.println("visible " + collectionOfModel.getIsVisible());
		
		System.out.println(" PUT ");
		
		return new ResponseEntity<CollectionOfModel>(collectionOfModel,HttpStatus.OK);	
		
	}
	

	@RequestMapping(value = "/modelItem/{productId}", method = RequestMethod.GET)
	public ResponseEntity<CollectionOfModel> getProductModel(@PathVariable("productId") long productId,HttpServletRequest request){
		
		CollectionOfModel collectionModel = sourceService.getProductModel(productId);
		System.out.println("visible get product " + collectionModel.getIsVisible());
		
		
		
		String rootPath = request.getSession().getServletContext().getRealPath("/");
	       File dir = new File(rootPath + File.separator + "img");
	       if (!dir.exists()) {
	           dir.mkdirs();
	       }
	       
	       File serverFile;
	       
	       List <CompanyImgAndDoc> listOfImages = collectionModel.getListOfImages();
	       
	       for(int index = 0; index < listOfImages.size(); index++ ) {
	    	   
	    	   CompanyImgAndDoc img = listOfImages.get(index);
	    	   
	    	   serverFile = new File(dir.getAbsolutePath() + File.separator + img.getName());
	    	   
	    	   try
		       {
		    	  
		    	   System.out.println(serverFile.getPath() + " byte " + img.getContent().length);
	    		   byte[] bytes = img.getContent();
		           BufferedOutputStream buffStream = 
		                   new BufferedOutputStream(new FileOutputStream(serverFile));
		           buffStream.write(bytes);
		           buffStream.close();
		    	  // file.transferTo(new File(filePath));
		       } catch (IOException e)
		       {
		           e.printStackTrace();
		       }
	    	   
	    	   
	       }
		
		System.out.println(" list of images " + listOfImages.size());
		
		return new ResponseEntity<CollectionOfModel>(collectionModel,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/imgAndDoc/{id}" , method = RequestMethod.GET)
	public  ResponseEntity<CompanyImgAndDoc> getImageAndDoc (@PathVariable("id") long id,HttpServletRequest request) throws IOException{
		CompanyImgAndDoc companyImgAndDoc = companyImgDocService.findById((int) id);
		//System.out.println("PUT " + companyImgAndDoc.getIsVisible());
		return new ResponseEntity<CompanyImgAndDoc>(companyImgAndDoc,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/previewImage" , method = RequestMethod.POST)
	public  ResponseEntity<String> showImage (@RequestParam(value = "file") MultipartFile file , @RequestParam(value = "imgName") String  imgName ,  @RequestParam(value = "productId") int productId , HttpServletRequest request)throws IOException{			
		
		System.out.println(" productId" +  productId);
		System.out.println(" img name" +  imgName);
		System.out.println(" preview " +  file.getOriginalFilename());
		
		String name;
	   String fileName = file.getOriginalFilename();
	   
	   int indexOfDest = fileName.lastIndexOf("\\");
	   
	   String contentType = file.getContentType();
	 
	   System.out.println("contentType " + contentType);
	  
	   int indexOfConttent = contentType.lastIndexOf("/");
	 
	   String MimeType = contentType.substring(0, indexOfConttent);
	 
	   String Extension =  contentType.substring(indexOfConttent+1,contentType.length());
	 
	   System.out.println("MimeType " + MimeType + " Extension " + Extension );
	 
	 
	   if(indexOfDest != -1) {

		 name =  fileName.substring(indexOfDest+1, fileName.length());
		 System.out.println("indexOfDest " + indexOfDest + "length  " + fileName.length());
	   }else{
		
		name =  fileName;
		
	   }
			  
	   System.out.println("Name " + name);
	   
	   
	   String rootPath = request.getSession().getServletContext().getRealPath("/");
       File dir = new File(rootPath + File.separator + "img");
       if (!dir.exists()) {
           dir.mkdirs();
       }
       
       File serverFile;
       
       if(MimeType.equals("image")){
    	   
    	   
    	   serverFile = new File(dir.getAbsolutePath() + File.separator + name);
		  	System.out.println("filePath" + serverFile );
	   			System.out.println(" jsp " + getBaseURL(request));
		  
	       try
	       {
	    	  
	    	   byte[] bytes = file.getBytes();
	           BufferedOutputStream buffStream = 
	                   new BufferedOutputStream(new FileOutputStream(serverFile));
	           buffStream.write(bytes);
	           buffStream.close();
	           writeImage(file, productId, imgName, getBaseURL(request), name);
	    	  // file.transferTo(new File(filePath));
	       } catch (IOException e)
	       {
	           e.printStackTrace();
	       }
    	   
       }
       
       
    	   
       
       
		return new ResponseEntity<String>(fileName, HttpStatus.OK);
	}
	
	 	public void writeImage(MultipartFile file, int productId, String imgName, String jspPath, String name) throws IOException {
	 		
	 		CompanyImgAndDoc document = new  CompanyImgAndDoc();
	        document.setName(name);
	        document.setType(file.getContentType());
	        document.setDescription(imgName);
	        document.setContent(file.getBytes());
	        document.setProductId(productId);
	        document.setPriority(1);
	        document.setIsVisible(1);
	        document.setText(imgName);
	        document.setJspPath(jspPath);
	        //companyDoumentService.save(document);
	        companyImgDocService.save(document);
	        System.out.println(" size" +companyImgDocService.findAllByProductId(productId).size());
	 		
		
	}
	
	
	
}
