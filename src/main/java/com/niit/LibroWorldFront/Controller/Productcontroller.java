package com.niit.LibroWorldFront.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.Libroworld.DAO.ICategoryDAO;
import com.niit.Libroworld.DAO.IProductDAO;
import com.niit.Libroworld.Model.Product;

@RequestMapping("/admin")
@Controller
public class Productcontroller {
	@Autowired
	IProductDAO productdao;
	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/product")
	String ProductPage(Model model) {
		model.addAttribute("edit", false);
		model.addAttribute("info", false);
		model.addAttribute("message", "");
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("productobject", new Product());
		model.addAttribute("title", "product");
		model.addAttribute("catlist", categorydao.allCategory());

		return "index";
	}

	@RequestMapping("/addproduct")
	String addProduct(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {

				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In correct Format");
				model.addAttribute("productobject", product);
				System.out.println("Has Error");
			} else {

				if (productdao.addProduct(product)) {
					addImage(product.getPro_Id(), product.getProduct_Images());
					model.addAttribute("info", true);
					model.addAttribute("message", "Added");
					System.out.println("Done");
					model.addAttribute("productobject", product);

				} else {
					model.addAttribute("info", true);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");
					model.addAttribute("productobject", product);
				}
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");
			model.addAttribute("productobject", product);

		}
		model.addAttribute("edit", false);
		model.addAttribute("productpage", true);
		model.addAttribute("productobject", new Product());
		model.addAttribute("title", "product");
		model.addAttribute("catlist", categorydao.allCategory());

		return "index";

	}

	private void addImage(int pro_Id, MultipartFile product_Images) {
		String path = "D:\\LibroWorldFront\\src\\main\\webapp\\resources\\productimages\\";
		try {
			if (product_Images.getSize() != 0) {
				path = path + String.valueOf(pro_Id) + ".jpeg";
				File f = new File(path);
				if (f.exists()) {
					f.delete();
				}

				BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(f));
				bs.write(product_Images.getBytes());
				bs.close();
				Thread.sleep(5000);
			}

		} catch (Exception e) {

		}
	}

	@RequestMapping("/deleteproduct")
	String deleteCategory(@RequestParam("prodid") int prodid, Model model) {
		try {
			// Step 1: fetch the cat object from database
			Product product = productdao.oneProduct(prodid);

			if (productdao.deleteProduct(product)) {

				String path = "D:\\LibroWorldFront\\src\\main\\webapp\\resources\\productimages\\";
				path = path + String.valueOf(prodid) + ".jpeg";
				File f = new File(path);
				if (f.exists()) {
					f.delete();
				}

				model.addAttribute("info", true);
				model.addAttribute("message", "Data Deleted");
			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "Data Not Deleted");
			}

		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "Data Not Deleted");
		}
		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("productobject", new Product());
		model.addAttribute("title", "product");

		return "index";
	}

	@RequestMapping("/getproducttoedit")
	String getProductToEdit(@RequestParam("prodid") int prodid, Model model) {
		model.addAttribute("edit", true);
		model.addAttribute("info", false);
		model.addAttribute("message", "please edit the Data");

		model.addAttribute("productpage", true);
		model.addAttribute("productobject", productdao.oneProduct(prodid));
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("tittle", "product");
		return "index";

	}

	@RequestMapping("/updateproduct")
	String updateProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br, Model model) {
		try {
			if (br.hasErrors()) {
				model.addAttribute("edit", true);
				model.addAttribute("productobject", product);

				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In correct Format");

				System.out.println("Done");

			} else {
				if (productdao.updateProduct(product)) {

					model.addAttribute("edit", false);
					model.addAttribute("productobject", new Product());
					model.addAttribute("info", true);
					model.addAttribute("message", "Updated");
					System.out.println("Done");
				} else {

					model.addAttribute("edit", true);
					model.addAttribute("productobject", product);

					model.addAttribute("info", true);
					model.addAttribute("message", "checkData");
					System.out.println("Failure");

				}
			}
		} catch (Exception e) {

			model.addAttribute("edit", true);
			model.addAttribute("productobject", product);
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");
		}

		model.addAttribute("productpage", true);
		model.addAttribute("productlist", productdao.allProduct());
		model.addAttribute("catlist", categorydao.allCategory());
		model.addAttribute("tittle", "product");
		return "index";
	}

}
