package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.MstBarang;
import com.mvc.service.BarangSvc;
import com.mvc.service.KaryawanSvc;
import com.mvc.service.KotaSvc;
import com.mvc.service.PelangganSvc;
import com.mvc.service.ProvinsiSvc;
import com.mvc.service.TransaksiSvc;

@Controller
public class HomeController {
	
	@Autowired
	private KaryawanSvc Ksvc;
	@Autowired
	private PelangganSvc Csvc;
	@Autowired
	private BarangSvc Bsvc;
	@Autowired
	private TransaksiSvc Tsvc;
	@Autowired
	private ProvinsiSvc Psvc;
	@Autowired
	private KotaSvc Kosvc;
	

	@RequestMapping("/home")
	public String home(Model model, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sesilogin") == null){
			return "redirect:/login";
		}else{
			List<MstKaryawanDto> listkar = Ksvc.getListAllKaryawan();
			int jmlkar = listkar.size();
			List<MstCustomerDto> listcus = Csvc.getListCustomer();
			int jmlcus = listcus.size();
			List<MstBarangDto> listbar = Bsvc.getListAllBarang();
			int jmlbar = listbar.size();
			List<TrHeaderPenjualanDto> listh = Tsvc.listTransaksiHeader();
			int jmlh = listh.size();
			List<MstProvinsiDto> listpro = Psvc.getAllProvinsi();
			int jmlpr = listpro.size();
			List<MstKotaDto> listko = Kosvc.getListKota();
			int jmlko = listko.size();
			
			
//			untuk karyawan
			model.addAttribute("jmlkar",jmlkar);
//			untuk pelanggan
			model.addAttribute("jmlcus",jmlcus);
//			untuk barang
			model.addAttribute("jmlbar",jmlbar);
//			untuk transaksi
			model.addAttribute("jmlh",jmlh);
//			untuk provinsi
			model.addAttribute("jmlpr",jmlpr);
//			untuk kota
			model.addAttribute("jmlko",jmlko);
			
			return "home";
		}
	}
}
