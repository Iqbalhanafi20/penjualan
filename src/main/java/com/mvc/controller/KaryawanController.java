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

import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.service.KaryawanSvc;

@Controller
@RequestMapping("/karyawan")
public class KaryawanController {
@Autowired
private KaryawanSvc svc;

//list
@RequestMapping("/list")
public String list(Model model, HttpServletRequest request){
	
	HttpSession session = request.getSession();
	if(session.getAttribute("sesilogin") == null){
		return "redirect:/login";
	}
		List<MstKaryawanDto> list = svc.getListAllKaryawan();
		model.addAttribute("data",list);
		return "viewMasterKaryawanList";	
	}

//form update
@RequestMapping(value = "edit/{kodekaryawan}",method = RequestMethod.GET)
public String edit(Model model,@PathVariable("kodekaryawan") String kodekaryawan, HttpServletRequest request, RedirectAttributes redirectAttrs){
 HttpSession session = request.getSession();
 if(session.getAttribute("sesilogin") == null){
	 return "redirect:/login";
 }else{
	 MstKaryawanDto k = svc.findOne(kodekaryawan);
        if(k==null){
        	redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode Karyawan tidak ada!!!", "error"));
        	return "redirect:/karyawan/list";
        }else{
        	model.addAttribute("data", k);
        }
        
        return "formEditKaryawan"; 
 }
 
    
}

//Method Edit
@RequestMapping(value="/edit/proses",method = RequestMethod.POST)
public String saveedit(@Valid @ModelAttribute("data") MstKaryawanDto dto, BindingResult result, RedirectAttributes redirectAttrs){
	
	 
	 try {
			MstKaryawanDto isExist = svc.findOne(dto.getKodeKaryawan());

			if (result.hasErrors()) {
				redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
				return "redirect:/karyawan/list";
			}

			if (isExist != null) {
				svc.update(dto);
				redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Update", "success"));
				 return "redirect:/karyawan/list";
			} else {
				redirectAttrs.addFlashAttribute("anotherError", "Update gagal di proses!");
				return "redirect:/karyawan/edit/" + dto.getKodeKaryawan();
			}
		} catch (Exception err) {
			redirectAttrs.addFlashAttribute("anotherError", "Update gagal di proses");
			return "redirect:/karyawan/edit/" + dto.getKodeKaryawan();
		}
   }

//add form
@RequestMapping("/tambah")
public String formadd(Model model, HttpServletRequest request){
	HttpSession session = request.getSession();
	if(session.getAttribute("sesilogin") == null){
		return "redirect:/login";
	}else{
		MstKaryawanDto dto = new MstKaryawanDto();
		model.addAttribute("data", dto);
		return "formTambahKaryawan";	
	}
}

//method save
 @RequestMapping(value="/simpan/proses", method = RequestMethod.POST) 
 public String save(@Valid @ModelAttribute("data") MstKaryawanDto dto,
		 BindingResult result, RedirectAttributes redirectAttrs){
	 
	 MstKaryawanDto isExist = svc.findOne(dto.getKodeKaryawan());
	 
	 if(result.hasErrors()){
		 redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
		 return "redirect:/karyawan/tambah";
	 }else{
		 
		 if (isExist == null) {
				svc.save(dto);
				redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Simpan", "success"));
				return "redirect:/karyawan/list";
			} else {
				redirectAttrs.addFlashAttribute("anotherError", "Kode karyawan sudah terpakai");
				return "redirect:/karyawan/tambah";
			}
	 }
 }

//delete
@RequestMapping(value="/delete/{kodekaryawan}")
public String delete(@PathVariable("kodekaryawan") String kodekaryawan, RedirectAttributes redirectAttrs){
	 try{
			svc.delete(kodekaryawan);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Berhasil", "Data Berhasil di Hapus", "success"));
			return "redirect:/karyawan/list";
		}catch(Exception err){
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode Karyawan tidak ada!!!", "error"));
			return "redirect:/karyawan/list";
		}
}

}
