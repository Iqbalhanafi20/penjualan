package com.mvc.controller;

import helper.RestResponse;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.service.BarangSvc;
import com.mvc.service.SupplierSvc;

@Controller
@RequestMapping("/barang")
public class BarangController {

	@Autowired
	private BarangSvc svc;

	@Autowired
	private SupplierSvc supSvc;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("sesilogin") == null){
			return "redirect:/login";
		}
		List<MstBarangDto> list = svc.getListAllBarang();
		model.addAttribute("data", list);
		return "viewMasterBarangList";
	}

	@RequestMapping("/tambah")
	public String tambah(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("sesilogin") == null){
			return "redirect:/login";
		}
		MstBarangDto barangDto = new MstBarangDto();
		List<MstSupplierDto> listSupplier = supSvc.getAllSupplier();

		model.addAttribute("dataSupplier", listSupplier);
		model.addAttribute("barangDto", barangDto);

		return "viewMasterBarangTambah";
	}

	@RequestMapping("/tambah/proses")
	public String proses_tambah(
			@Valid @ModelAttribute("barangDto") MstBarangDto barangDto,
			BindingResult result, ModelMap model, RedirectAttributes redirectAttrs) {

		MstBarangDto isExist = svc.getBarangByKode(barangDto.getKodeBarang());

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/barang/tambah";
		}

		if (isExist == null) {
			svc.simpanBarang(barangDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil disimpan", "success"));
			return "redirect:/barang/list";
		} else {
			redirectAttrs.addFlashAttribute("anotherError", "Kode barang sudah terpakai");
			return "redirect:/barang/tambah";
		}
	}

	@RequestMapping("/ubah/{kodeBarang}")
	public String ubah(Model model, HttpServletRequest request,
			@PathVariable("kodeBarang") String kodeBarang, RedirectAttributes redirectAttrs) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("sesilogin") == null){
			return "redirect:/login";
		}
		
		MstBarangDto barangDto = svc.getBarangByKode(kodeBarang);
		
		if (barangDto != null) {
			List<MstSupplierDto> listSupplier = supSvc.getAllSupplier();

			model.addAttribute("dataSupplier", listSupplier);
			model.addAttribute("barangDto", barangDto);	
		}else{
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode barang tidak ada!!!", "error"));
			return "redirect:/barang/list";
		}
		
		return "viewMasterBarangEdit";
	}

	@RequestMapping(value = "/ubah/proses/{kodeBarang}", method = RequestMethod.POST)
	public String ubah_proses(
			@Valid @ModelAttribute("penduduk") MstBarangDto barangDto,
			BindingResult result, ModelMap model,
			@PathVariable("kodeBarang") String kodeBarang, RedirectAttributes redirectAttrs) {

		try {
			MstBarangDto isExist = svc.getBarangByKode(kodeBarang);

			if (result.hasErrors()) {
				redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
				return "redirect:/barang/ubah/" + kodeBarang;
			}

			if (isExist != null) {
				svc.ubahBarang(barangDto);
				redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil diubah", "success"));
				return "redirect:/barang/list";
			} else {
				redirectAttrs.addFlashAttribute("anotherError", "kode provinsi sudah ada!");
				return "redirect:/barang/ubah/" + kodeBarang;
			}
		} catch (Exception err) {
			redirectAttrs.addFlashAttribute("anotherError", "something wrong");
			return "redirect:/barang/ubah/" + kodeBarang;
		}
	}
	
	@RequestMapping(value = "/hapus/{kodeBarang}")
	public String delete(@PathVariable("kodeBarang") String kodeBarang, RedirectAttributes redirectAttrs) {
		try{
			svc.hapusBarang(kodeBarang);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil dihapus", "success"));
			return "redirect:/barang/list";	
		}catch(Exception err){
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode barang tidak ada!!!", "error"));
			return "redirect:/barang/list";
		}
	}

}
