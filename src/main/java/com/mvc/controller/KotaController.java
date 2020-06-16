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
import com.mvc.dto.MstKotaDto;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.dto.MstSupplierDto;
import com.mvc.service.KotaSvc;
import com.mvc.service.ProvinsiSvc;

@Controller
@RequestMapping("/kota")
public class KotaController {

	@Autowired
	private KotaSvc svc;

	@Autowired
	private ProvinsiSvc pSvc;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}
		List<MstKotaDto> list = svc.getListKota();
		List<MstProvinsiDto> provinsi = pSvc.getAllProvinsi();
		model.addAttribute("dataProvinsi", provinsi);
		model.addAttribute("data", list);
		return "viewMasterKotaList";
	}

	@RequestMapping("/tambah")
	public String tambah(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}
		MstKotaDto kotaDto = new MstKotaDto();
		List<MstProvinsiDto> provinsi = pSvc.getAllProvinsi();

		model.addAttribute("dataProvinsi", provinsi);
		model.addAttribute("kotaDto", kotaDto);

		return "viewMasterKotaTambah";
	}

	@RequestMapping("/tambah/proses")
	public String proses_tambah(
			@Valid @ModelAttribute("kotaDto") MstKotaDto kotaDto,
			BindingResult result, ModelMap model,
			RedirectAttributes redirectAttrs) {

		MstKotaDto isExist = svc.checkDataKotaByKode(kotaDto.getKodeKota());

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/kota/tambah";
		}

		if (isExist == null) {
			svc.tambahKota(kotaDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil ditambah", "success"));
			return "redirect:/kota/list";
		} else {
			redirectAttrs.addFlashAttribute("anotherError",
					"Kode Kota sudah digunakan");
			return "redirect:/kota/tambah";
		}
	}

	@RequestMapping("/ubah/{kodeKota}")
	public String ubah(Model model, HttpServletRequest request,
			@PathVariable("kodeKota") String kodeKota,
			RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}
		MstKotaDto kotaDto = svc.checkDataKotaByKode(kodeKota);

		if (kotaDto != null) {
			List<MstProvinsiDto> provinsi = pSvc.getAllProvinsi();

			model.addAttribute("dataProvinsi", provinsi);
			model.addAttribute("kotaDto", kotaDto);

			return "viewMasterKotaEdit";
		} else {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "Kode kota tidak ada!!!", "error"));
			return "redirect:/kota/list";
		}
	}

	@RequestMapping(value = "/ubah/proses/{kodeKota}", method = RequestMethod.POST)
	public String ubah_proses(
			@Valid @ModelAttribute("kotaDto") MstKotaDto kotaDto,
			BindingResult result, ModelMap model,
			@PathVariable("kodeKota") String kodeKota,
			RedirectAttributes redirectAttrs) {
		try {
			MstKotaDto kota = svc.checkDataKotaByKode(kodeKota);

			if (result.hasErrors()) {
				redirectAttrs.addFlashAttribute("errors",
						result.getFieldErrors());
				return "redirect:/kota/ubah/" + kodeKota;
			}

			svc.ubahKota(kotaDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil diubah", "success"));
			return "redirect:/kota/list";
		} catch (Exception err) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "Something wrong", "error"));
			return "redirect:/kota/ubah/" + kodeKota;
		}
	}

	@RequestMapping("/hapus/{kodeKota}")
	public String hapus(@PathVariable("kodeKota") String kodeKota, RedirectAttributes redirectAttrs) {
		MstKotaDto kota = svc.checkDataKotaByKode(kodeKota);
		if (kota != null) {
			svc.hapusKota(kodeKota);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil dihapus", "success"));
			return "redirect:/kota/list";
		}else{
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "Kode kota tidak ada!!!", "error"));
			return "redirect:/kota/list";
		}
	}

}
