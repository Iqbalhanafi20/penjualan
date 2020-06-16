package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dto.MstKaryawanDto;
import com.mvc.service.KaryawanSvc;
import com.mvc.service.LoginSvc;

@Controller
public class loginCtl {

	@Autowired
	private LoginSvc svc;
	
	@Autowired
	private KaryawanSvc svckar;
	
//	form loginnya
	@RequestMapping("login")
	public String login(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session.getAttribute("sesilogin") == null){
			MstKaryawanDto dto = new MstKaryawanDto();
			model.addAttribute("logindto", dto);
			return "login";
		}else{
			return "redirect: /home";
			}
	}
	
//	cek loginnya dulu
	@RequestMapping("/ceklogin")
	public String ceklogin(@ModelAttribute("logindto")MstKaryawanDto dto, Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		MstKaryawanDto find = svc.login(dto.getUsername());
		if(find != null){
			if(dto.getPassword().equals(find.getPassword())){
				session.setAttribute("sesilogin", dto.getUsername());
				session.setAttribute("kodeKaryawan", dto.getKodeKaryawan());
				session.setAttribute("sesikaryawan", find);
				
				return "redirect: /home";
			}else{
				model.addAttribute("pesan","Maaf Data yang anda masukkan salah");
				return "login";
			}
		}else{
			model.addAttribute("pesan","Maaf Data yang anda masukkan salah");
			return "login";
		}
	}
	
	@RequestMapping("/logout")
    public String keluar(HttpServletRequest request) {
        request.getSession().invalidate();
         return "redirect:/login";
    }
	
}

