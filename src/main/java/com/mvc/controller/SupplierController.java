package com.mvc.controller;

import helper.RestResponse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.entity.MstKota;
import com.mvc.service.KaryawanSvc;
import com.mvc.service.KotaSvc;
import com.mvc.service.SupplierSvc;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
@Autowired
private SupplierSvc svc;

@Autowired
private KotaSvc svcko;

//list
@RequestMapping("/list")
public String list(Model model, HttpServletRequest request){
	
	HttpSession session = request.getSession();
	if(session.getAttribute("sesilogin") == null){
		return "redirect:/login";
	}
		List<MstSupplierDto> list = svc.getAllSupplier();
		model.addAttribute("data",list);
		return "viewMasterSupplierList";	
	}

//add form
@RequestMapping("/tambah")
public String formadd(Model model, HttpServletRequest request){
	HttpSession session = request.getSession();
	if(session.getAttribute("sesilogin") == null){
		return "redirect:/login";
	}else{
		MstSupplierDto dto = new MstSupplierDto();
		List<MstKotaDto> list = svcko.getListKota();
		
		model.addAttribute("data", dto);
		model.addAttribute("datakota", list);
		return "viewMasterSupplierTambah";	
	}
}

//method save
@RequestMapping(value="/simpan/proses", method = RequestMethod.POST) 
public String save(@Valid @ModelAttribute("data") MstSupplierDto dto,
		 BindingResult result, RedirectAttributes redirectAttrs){
MstSupplierDto isExist = svc.findOne(dto.getKodeSupplier());
	 
	 if(result.hasErrors()){
		 redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
		 return "redirect:/supplier/tambah";
	 }else{
		 
		 if (isExist == null) {
				svc.save(dto);
				redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Simpan", "success"));
				return "redirect:/supplier/list";
			} else {
				redirectAttrs.addFlashAttribute("anotherError", "Kode Supplier sudah terpakai");
				return "redirect:/supplier/tambah";
			}
	 }
}

//method delete
@RequestMapping(value = "/delete/{kodeSupplier}")
public String delete(@PathVariable("kodeSupplier") String kodeSupplier, RedirectAttributes redirectAttrs) {
	try{
		svc.delete(kodeSupplier);
		redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Hapus", "success"));
		return "redirect:/supplier/list";	
	}catch(Exception err){
		redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode supplier tidak ada!!!", "error"));
		return "redirect:/supplier/list";
	}
}

//form update
@RequestMapping(value = "edit/{kodeSupplier}",method = RequestMethod.GET)
public String edit(Model model,@PathVariable("kodeSupplier") String kodeSupplier, HttpServletRequest request, RedirectAttributes redirectAttrs){
HttpSession session = request.getSession();
if(session.getAttribute("sesilogin") == null){
	 return "redirect:/login";
}else{
	 MstSupplierDto s = svc.findOne(kodeSupplier);
	 List<MstKotaDto> list = svcko.getListKota();
      if(s==null){
    	  redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode supplier tidak ada!!!", "error"));
    	  return "redirect:/supplier/list";
      }
      model.addAttribute("data", s);
      model.addAttribute("datakota", list);
      return "viewMasterSupplierEdit"; 
	} 
}


//Method Edit
@RequestMapping(value="/edit/proses",method = RequestMethod.POST)
public String saveedit(@Valid @ModelAttribute("data") MstSupplierDto dto, BindingResult result, RedirectAttributes redirectAttrs){
	try {
		MstSupplierDto isExist = svc.findOne(dto.getKodeSupplier());

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/supplier/list";
		}

		if (isExist != null) {
			svc.update(dto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Update", "success"));
			 return "redirect:/supplier/list";
		} else {
			redirectAttrs.addFlashAttribute("anotherError", "Update gagal di proses!");
			return "redirect:/supplier/edit/" + dto.getKodeSupplier();
		}
	} catch (Exception err) {
		redirectAttrs.addFlashAttribute("anotherError", "Update gagal di proses");
		return "redirect:/karyawan/edit/" + dto.getKodeSupplier();
	}
	}
}
