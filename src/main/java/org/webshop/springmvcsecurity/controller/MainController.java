package org.webshop.springmvcsecurity.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.webshop.document.search.service.CompanyImgDocService;
import org.webshop.search.dao.CollectionSearchDAO;
import org.webshop.search.dao.CompanyDAO;
import org.webshop.search.dao.DisplayScreenSizeDAO;
import org.webshop.search.dao.EquipmentTypeDAO;
import org.webshop.search.model.CompanyImgAndDoc;
import org.webshop.search.model.InputSearch;
import org.webshop.search.model.OrderItem;
import org.webshop.search.workspace.dao.ItemDAO;
import org.webshop.springmvcsecurity.authentication.facade.AuthenticationFacade;
import org.webshop.springmvcsecurity.dao.UserInfoDAO;
import org.webshop.springmvcsecurity.model.Customber;

@Controller
public class MainController extends BaseController {
	

	public static final String PARAM_LATESTPHOTO = "LATEST_PHOTO_PARAM";
	public static final String PARAM_BASE_URL = "baseURL";
	
	@Autowired
	private CompanyImgDocService companyImgDocService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AuthenticationFacade authenticationFacade;
	
	@Autowired
	@Qualifier(value="QualiCollectionSearchDAO")
	private CollectionSearchDAO collectionSearchDAO;
	
	@Autowired
	@Qualifier(value="QualiCompanyDAO")
	private CompanyDAO companyDAO;
	
	@Autowired
	@Qualifier(value="QualiDisplayScreenSizeDAO")
	private DisplayScreenSizeDAO displayScreenSizeDAO;
	
	@Autowired
	@Qualifier(value="QualiEquipmentTypeDAO")
	private EquipmentTypeDAO equipmentTypeDAO;
	
	@Autowired
    @Qualifier(value="QualiUserInfoDAO")
    private UserInfoDAO userInfoDAO;
	
	@Autowired
	@Qualifier(value="QualiItemDAO")
	private ItemDAO itemDAO;
	
   @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
   public String welcomePage(Model model) {
       model.addAttribute("title", "Welcome");
       model.addAttribute("message", "This is welcome page!");
       return "welcomePage";
   }
   
   @RequestMapping(value = {"/restmain" }, method = RequestMethod.GET)
   public String main(Model model, HttpServletRequest request )throws IOException { 
	   
	   String rootPath = request.getSession().getServletContext().getRealPath("static");
	   
	   System.out.println(" path " + rootPath);
	   
       return "main";
   }
   
   @RequestMapping(value = {"/restcostomer" }, method = RequestMethod.GET)
   public String costomerPage(Model model, HttpServletRequest request )throws IOException { 
	   
	   String rootPath = request.getSession().getServletContext().getRealPath("static");
	   
	   System.out.println(" path " + rootPath);
	   
       return "costomerPage";
   }
   @RequestMapping(value = {"/restpopup" }, method = RequestMethod.GET)
   public String popupPage(Model model, HttpServletRequest request )throws IOException { 
	   
	   
       return "pupop";
   }
   
   
 
   @RequestMapping(value = "/admin", method = RequestMethod.GET)
   public String adminPage(Model model) {
       return "adminPage";
   }
 
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String loginPage(Model model ) {
      
       return "loginPage";
   }
 
   @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
   public String logoutSuccessfulPage(Model model) {
       model.addAttribute("title", "Logout");
       return "logoutSuccessfulPage";
   }
 
   @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
   public String userInfo(Model model, Principal principal) {
 
       // After user login successfully.
       String userName = principal.getName();
 
       System.out.println("User Name: "+ userName);
 
       return "userInfoPage";
   }
   
   @RequestMapping(value = "/initMultiFile", method = RequestMethod.GET)
   public String startUpLoadFile(Model model) {
       return "uploadMulti";
   }
   
   
@RequestMapping(value = "/multifilesave", method = RequestMethod.POST)
   public String submit(@RequestParam("file") MultipartFile file, @RequestParam("description") String  description, ModelMap modelMap, HttpServletRequest request) throws IOException {
       
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
       File serverTemp;
	  
        
       if(MimeType.equals("image")){
    	   
    	   if(Extension.equals("png")) {
    		   
    		   
    		   System.out.println("Orginalfile " + file.getOriginalFilename());
    		   
    		  
    		   serverTemp = new File("C:\\mytemp" + File.separator + name); 
    		   
    		   
    		   
    		   System.out.println("temp " + serverTemp.getPath());
    		
    		   System.out.println("is png");
    		  // BufferedImage bufferedImag;	
    	        try {
    	          //read image file
    	        	Iterator<ImageReader> iterReader = ImageIO.getImageReadersByFormatName("PNG");
    	        	ImageReader imageReaders = (ImageReader)iterReader.next();
    	        	ImageInputStream iisInput = ImageIO.createImageInputStream(serverTemp);
    	        	imageReaders.setInput(iisInput, false);
    	        	BufferedImage biInput = ImageIO.read(iisInput);
    	        
    	          // create a blank, RGB, same width and height, and a white background
    	        	biInput = new BufferedImage(biInput.getWidth(), 
    	        			biInput.getHeight(), BufferedImage.TYPE_INT_RGB);
    	        	biInput.createGraphics()
    	                .drawImage(biInput, 0, 0, Color.WHITE, null);
    	        	String tempJpg = name.replace("png","jpg");
    	        	name = tempJpg;
    	        	
    	          // write to jpeg file
    	        	serverFile  = new File(dir.getAbsolutePath() + File.separator + name);
    	        	System.out.println(" replace " + serverFile.getPath());
    	        	
    	          ImageIO.write(biInput, "jpg", serverFile);
    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    		   
    	   }else {
    		
    		   		
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
    		    	   
    		    	  // file.transferTo(new File(filePath));
    		       } catch (IOException e)
    		       {
    		           e.printStackTrace();
    		       }
    		   
    	   
    	   }
       }
       
	  
	   
	   modelMap.addAttribute("files",  file);
       modelMap.addAttribute("description", description);
       modelMap.addAttribute("filePath",getBaseURL(request));
       modelMap.addAttribute("fileName",name);
       
       
        CompanyImgAndDoc document = new  CompanyImgAndDoc();
       document.setName(name);
       document.setType(file.getContentType());
       document.setDescription(description);
       document.setContent(file.getBytes());
       document.setProductId(11);
       document.setPriority(1);
       document.setIsVisible(1);
       document.setText("Surface 5");
       document.setJspPath(getBaseURL(request));
       //companyDoumentService.save(document);
       //companyImgDocService.save(document);
      // System.out.println(" size" +companyImgDocService.findAllByProductId(11).size());
       
       
              
       
       return "fileUploadView";
   }
   
   @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
   //@ResponseBody
   
   public String searhPage(Model model,@PathVariable("id") int id,Principal principal, HttpServletRequest request) throws IOException {
	   
	   //@PathVariable("id") int id,
	   	System.out.println(" id " + id);
	   	System.out.println("Companys " + companyDAO.list().size());
	    System.out.println("Size " + displayScreenSizeDAO.getListOfSize().size());
	    System.out.println("Type " + equipmentTypeDAO.getListOfType().size());
	    InputSearch input = new InputSearch();
	    input.setTypeId("3");
	    input.setCompanyId("*");
	    input.setScreenSizeId("*");
	    
	    List <OrderItem> order = collectionSearchDAO.getListOfSearch(input);
	   // After user login successfully.
       String userName = principal.getName();
       System.out.println("Order Size " + order.size());
       itemDAO.dropTable("xxx");
       itemDAO.createWorkTable("xxx");
       itemDAO.insertBatch(order, "xxx");
       
       Customber custt = userInfoDAO.getCostobmerObj(authenticationFacade.getAuthentication().getName());
       
       System.out.println(authenticationFacade.getAuthentication().getName());
       
       System.out.println("User id: "+ custt.getCustId());
       System.out.println("User Name: "+ userName);
       
       String rootPath = request.getSession().getServletContext().getRealPath("static");
       
       System.out.println("static : "+ rootPath);
 
       return "searchPage";
   }
 
   @RequestMapping(value = "/403", method = RequestMethod.GET)
   public String accessDenied(Model model, Principal principal) {
        
       if (principal != null) {
           model.addAttribute("message", "Hi " + principal.getName()
                   + "<br> You do not have permission to access this page!");
       } else {
           model.addAttribute("msg",
                   "You do not have permission to access this page!");
       }
       return "403Page";
   }

}
