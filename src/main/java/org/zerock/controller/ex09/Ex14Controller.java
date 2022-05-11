package org.zerock.controller.ex09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.service.ex02.Ex04Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;

	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// 1. request parameter 수집/ 가공
		// 2. bussiness logic 처리
		String name = service.getNameById(id);
		
		// 3. model.addAttribute
		model.addAttribute("name", name);
		// 4. forward/redirect
		
	}
	
	// /ex14/sub02?id=3
	// view에서 Employee의 firstName이 출력 되도록
	
	// controller.method02 완성
	// service에도 메소드 추가
	// mapper에도 메소드 추가
	// jsp 작성
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		String firstName = service.getEmployeeFirstNameById(id);
		
		model.addAttribute("employeeName", firstName);
		
		
	}
	
	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
		
	}
	
	// /ex14/sub04?id=7
	// 직원의 FirstName, LastName이 모두 jsp 출력되도록
	
	// contoller에 새 메소드 작성
	// service에 새 메소드 작성
	// mapper에 새 메소드 작성
	// 새 jsp 파일 작성
	// EmployeeDto 새로 작성
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getEmployeeInfoById(id);
		
		model.addAttribute("employee", dto);
	}
	
	@GetMapping("sub05")
	public void method05() {
		// form 있는 jsp forward
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		// 1.
		System.out.println(customer);
		// 2.
		boolean ok = service.addCustomer(customer);
		// 3.
		if (ok) {
			rttr.addFlashAttribute("message", "등록 완료");
		} else {
			rttr.addFlashAttribute("message", "등록 실패");
		}
		// 4.
		
		return "redirect:/ex14/sub05";
		
	}
}








