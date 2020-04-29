package com.niit.LibroWorldFront.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Libroworld.DAO.ICategoryDAO;
import com.niit.Libroworld.Model.Category;

@Controller
public class CategoryController {
	@Autowired
	ICategoryDAO categorydao;

	@RequestMapping("/category")
	String CategoryPage(Model model) {
		model.addAttribute("categorypage", true);
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		return "index";
	}

	@RequestMapping("/addcategory")
	String CategoryPage(@ModelAttribute("registerobject") Category category, Model model) {
		try {

			if (categorydao.addCategory(category)) {
				model.addAttribute("info", true);
				model.addAttribute("message", "CategoryAdded");
				System.out.println("Done");

			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "checkData");
				System.out.println("Failure");
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");

		}
		model.addAttribute("categorypage", true);
		model.addAttribute("categoryobject", new Category());
		model.addAttribute("title", "category");
		return "index";
	}
}
