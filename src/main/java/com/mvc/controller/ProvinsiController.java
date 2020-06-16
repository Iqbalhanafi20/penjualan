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

import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.service.ProvinsiSvc;

@Controller
@RequestMapping("/provinsi")
public class ProvinsiController {

	@Autowired
	private ProvinsiSvc svc;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		List<MstProvinsiDto> list = svc.getAllProvinsi();

		model.addAttribute("data", list);

		return "viewMasterProvinsiList";
	}

	@RequestMapping("/tambah")
	public String tambah(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		MstProvinsiDto provinsiDto = new MstProvinsiDto();

		model.addAttribute("provinsiDto", provinsiDto);

		return "viewMasterProvinsiTambah";
	}

	@RequestMapping("/tambah/proses")
	public String tambah_proses(
			@Valid @ModelAttribute("provinsiDto") MstProvinsiDto provinsiDto,
			BindingResult result, ModelMap model, HttpServletRequest request,
			RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();

		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/provinsi/tambah";
		}

		MstProvinsiDto isExist = svc.getProvinsi(provinsiDto.getKodeProvinsi());

		if (isExist == null) {
			svc.simpanProvinsi(provinsiDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Sukses!", "data berhasil disimpan", "success"));
			return "redirect:/provinsi/list";
		} else {
			redirectAttrs.addFlashAttribute("anotherError",
					"Kode Provinsi sudah ada");
			return "redirect:/provinsi/tambah";
		}
	}

	@RequestMapping("/ubah/{kodeProvinsi}")
	public String ubah(Model model, HttpServletRequest request,
			@PathVariable("kodeProvinsi") String kodeProvinsi, RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		MstProvinsiDto provinsiDto = svc.getProvinsi(kodeProvinsi);

		if (provinsiDto == null) {
			redirectAttrs.addFlashAttribute("swalMessage",
					new RestResponse("Error!", "Kode provinsi tidak ada!!!",
							"error"));
			return "redirect:/provinsi/list";
		}

		model.addAttribute("kodeProvinsi", provinsiDto.getKodeProvinsi());
		model.addAttribute("provinsiDto", provinsiDto);

		return "viewMasterProvinsiEdit";
	}

	@RequestMapping(value = "/ubah/proses/{kodeProvinsi}", method = RequestMethod.POST)
	public String ubah_proses(
			@Valid @ModelAttribute("provinsiDto") MstProvinsiDto provinsiDto,
			BindingResult result, ModelMap model,
			@PathVariable("kodeProvinsi") String kodeProvinsi,
			HttpServletRequest request, RedirectAttributes redirectAttrs) {

		HttpSession session = request.getSession();
		if (session.getAttribute("sesilogin") == null) {
			return "redirect:/login";
		}

		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("errors", result.getFieldErrors());
			return "redirect:/provinsi/ubah/" + provinsiDto.getKodeProvinsi();
		}

		MstProvinsiDto isExist = svc.getProvinsi(provinsiDto.getKodeProvinsi());

		if (isExist != null) {
			svc.ubahProvinsi(provinsiDto);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil diubah", "success"));
			return "redirect:/provinsi/list";
		} else {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "kode provinsi tidak ada", "error"));
			return "redirect:/provinsi/list";
		}
	}

	@RequestMapping("/hapus/{kodeProvinsi}")
	public String hapus(@PathVariable("kodeProvinsi") String kodeProvinsi,
			HttpServletRequest request, Model model, RedirectAttributes redirectAttrs) {
		MstProvinsiDto isExist = svc.getProvinsi(kodeProvinsi);

		if (isExist != null) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Sukses!", "data berhasil dihapus", "success"));
			svc.hapusProvinsi(kodeProvinsi);
		} else {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse("Error!", "kode provinsi tidak ada", "error"));
		}

		return "redirect:/provinsi/list";
	}
}
