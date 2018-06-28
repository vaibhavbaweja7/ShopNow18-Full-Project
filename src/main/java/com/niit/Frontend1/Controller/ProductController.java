package com.niit.Frontend1.Controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.Backend.dao.ProDao;
import com.niit.Backend.model.Product;

@Controller
public class ProductController {
	@Autowired
	Product product;
	@Autowired
	ProDao prodao;
	
	@RequestMapping(value="AddProduct",method=RequestMethod.POST)
	 public String addProduct(@ModelAttribute("product")Product product,HttpSession httpsession )
	 {
       
		if(product.getProductId()==null)
	 		
	 	{
			

	 		prodao.AddProduct(product);
	 		
          
	 		
	 		System.out.println("product.getid is zero");
			MultipartFile file=product.getFile();
			
			ServletContext con=httpsession.getServletContext();
			String filelocation=con.getRealPath("/resources/images/");
			System.out.println(filelocation);
			String filename=filelocation+"\\"+product.getProductId()+".jpg";
			System.out.println(filename);
			
			try{
				byte b[]=file.getBytes();
				FileOutputStream fos=new FileOutputStream(filename);
				fos.write(b);
				fos.close();
		    	}
			catch(IOException ex){}
			catch(Exception e){}
	 			
		
			
}else
	 	{
	 		prodao.UpdateProduct(product);
	 	}
	 	
	 	return "redirect:/Product";
	 }
	
	@RequestMapping(value="deleteProduct/{productId}",method = RequestMethod.GET)
	 public String deleteProduct(@PathVariable("productId")String productId)
	 {
		
		prodao.DeleteProduct(productId);
		return "redirect:/Product";
	 }
	@RequestMapping(value="editProduct/{productId}",method=RequestMethod.GET)
	public String updateProduct(@PathVariable("productId")String productId,Model model)
	{
	Product pro=prodao.getProduct(productId);
	model.addAttribute("product",pro);
	   return "Product";
	} 
}	

