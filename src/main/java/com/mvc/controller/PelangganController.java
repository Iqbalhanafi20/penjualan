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

import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKotaDto;
import com.mvc.service.KotaSvc;
import com.mvc.service.PelangganSvc;

@Controller
@RequestMapping("/pelanggan")
public class PelangganController {

	@Autowired
	private PelangganSvc svc;

	@Autowired
	private KotaSvc kotaSvc;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		List<MstCustomerDto> dtos = svc.getListCustomer();

		model.addAttribute("data", dtos);

		return "viewMasterPelangganList";
	}

	@RequestMapping("/tambah")
	public String tambah(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		List<MstKotaDto> kota = kotaSvc.getListKota();
		MstCustomerDto dto = new MstCustomerDto();
		model.addAttribute("pelangganDto", dto);
		model.addAttribute("dataKota", kota);

		return "viewMasterPelangganTambah";
	}

	@RequestMapping(value = "/tambah/proses", method = RequestMethod.POST)
	public String tambah_proses(
			@Valid @ModelAttribute("pelangganDto") MstCustomerDto pelangganDto,
			BindingResult result, ModelMap model, HttpServletRequest request, RedirectAttributes redirectAttrs) {

		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/pelanggan/tambah";
		}

		MstCustomerDto isExist = svc
				.getCustomer(pelangganDto.getKodeCustomer());

		if (isExist == null) {
			svc.simpanPelanggan(pelangganDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil disimpan", "success"));
			return "redirect:/pelanggan/list";
		} else {
			redirectAttrs.addFlashAttribute("anotherError", "kode pelanggan sudah ada!");
			return "redirect:/pelanggan/tambah";
		}
	}

	@RequestMapping("/ubah/{kodeCustomer}")
	public String ubah(Model model, HttpServletRequest request,
			@PathVariable("kodeCustomer") String kodeCustomer, RedirectAttributes redirectAttrs) {

		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		List<MstKotaDto> kota = kotaSvc.getListKota();
		MstCustomerDto dto = svc.getCustomer(kodeCustomer);

		if (dto == null) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode pelanggan tidak ada!!!", "error"));
			return "redirect:/pelanggan/list";
		}

		model.addAttribute("kodeCustomer", dto.getKodeCustomer());
		model.addAttribute("pelangganDto", dto);
		model.addAttribute("dataKota", kota);

		return "viewMasterPelangganEdit";
	}

	@RequestMapping(value = "/ubah/proses/{kodeCustomer}", method = RequestMethod.POST)
	public String ubah_proses(
			@Valid @ModelAttribute("pelangganDto") MstCustomerDto pelangganDto,
			BindingResult result, ModelMap model,
			@PathVariable("kodeCustomer") String kodeCustomer,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {

		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldError());
			return "redirect:/pelanggan/ubah/" + pelangganDto.getKodeCustomer();
		}

		MstCustomerDto isExist = svc
				.getCustomer(pelangganDto.getKodeCustomer());

		if (isExist == null) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "Kode pelanggan tidak ada!!!", "error"));
//			svc.ubahPelanggan(pelangganDto);
			return "redirect:/pelanggan/list";
		} else {
			svc.ubahPelanggan(pelangganDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil diubah", "success"));
			
			return "redirect:/pelanggan/list";
		}
	}
	
	@RequestMapping("/hapus/{kodeCustomer}")
	public String hapus(@PathVariable("kodeCustomer")String kodeCustomer, HttpServletRequest request, Model model, RedirectAttributes redirectAttrs){
		MstCustomerDto isExist = svc.getCustomer(kodeCustomer);
		
		if (isExist != null) {
			svc.hapusPelanggan(kodeCustomer);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil dihapus", "success"));
		}else{
			model.addAttribute("messageAlert", "Kode yang anda ingin hapus tidak ada!");
		}

		return "redirect:/pelanggan/list";
	}

}
