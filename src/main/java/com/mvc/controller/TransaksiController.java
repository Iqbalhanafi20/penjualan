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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mvc.dao.TrHeaderPenjualanDao;
import com.mvc.dto.MstBarangDto;
import com.mvc.dto.MstCustomerDto;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.TrDetailPenjualanDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.service.BarangSvc;
import com.mvc.service.KaryawanSvc;
import com.mvc.service.PelangganSvc;
import com.mvc.service.TransaksiSvc;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

	@Autowired
	private TransaksiSvc svc;

	@Autowired
	private BarangSvc bSvc;

	@Autowired
	private PelangganSvc cSvc;

	@Autowired
	private KaryawanSvc kSvc;

	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request) {
		List<TrHeaderPenjualanDto> list = svc.listTransaksiHeader();
		model.addAttribute("data", list);
		return "viewTransaksiList";
	}

	@RequestMapping("/detail/{noNota}")
	public String detail(Model model, HttpServletRequest request,
			@PathVariable("noNota") String noNota) {
		TrHeaderPenjualanDto list = svc.listTransaksiHeader(noNota);
		List<MstCustomerDto> customer = cSvc.getListCustomer();
		TrHeaderPenjualanDto headerDto = svc.listTransaksiHeader(noNota);
		model.addAttribute("headerDto", headerDto);
		model.addAttribute("pelanggan", customer);
		model.addAttribute("data", list);
		return "viewTransaksiDetail";
	}

	@RequestMapping("/detail/hapus/{kodeDetail}")
	public String detail_hapus(Model model, HttpServletRequest request,
			@PathVariable("kodeDetail") String kodeDetail,
			RedirectAttributes redirectAttrs) {
		TrDetailPenjualanDto detail = svc.getDetailByKode(kodeDetail);
		if (detail != null) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Sukses!", "data berhasil dihapus", "success"));
			svc.deleteDetail(kodeDetail);
			updateHargaTotalHeader(detail.getNoNota());
			return "redirect:/transaksi/detail/" + detail.getNoNota();
		} else {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "kode detail tidak ada", "error"));
			return "redirect:/transaksi/list";
		}
	}

	public void updateHargaTotalHeader(String noNota) {
		List<TrDetailPenjualanDto> forUpdateHeader = svc
				.listTransaksiDetailByNoNota(noNota);
		TrHeaderPenjualanDto newme = svc.listTransaksiHeader(noNota);

		int hargaTotal = 0;
		int globaldiskon = newme.getGlobalDiskon();

		for (TrDetailPenjualanDto h : forUpdateHeader) {
			hargaTotal += h.getSubtotal();
		}

		int globalDiskonRP = (hargaTotal * newme.getGlobalDiskon()) / 100;

		newme.setHargaTotal(hargaTotal - globalDiskonRP);

		svc.saveHargaTotalHeader(newme);
	}

	@RequestMapping("/header/ubah/proses/{noNota}")
	public String header_ubah(
			@Valid @ModelAttribute("header") TrHeaderPenjualanDto header,
			BindingResult result, ModelMap model,
			@PathVariable("noNota") String noNota, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		HttpSession session = request.getSession();
		// MstKaryawanDto karyawanSkrg =
		// (MstKaryawanDto)session.getAttribute("sesikaryawan");
		if (result.hasErrors()) {
			return "redirect:/transaksi/list";
		}

		TrHeaderPenjualanDto isExist = svc.listTransaksiHeader(noNota);

		if (isExist == null) {
			return "redirect:/transaksi/list";
		} else {
			// String kodeKaryawan = (String)
			// session.getAttribute("kodeKaryawan");
			// header.setKodeKaryawan(kodeKaryawan);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Sukses!", "berhasil simpan data!", "success"));
			svc.updateHeader(header);
			return "redirect:/transaksi/list";
		}
	}

	@RequestMapping("/detail/tambah/{noNota}")
	public String detail_tambah(Model model, HttpServletRequest request,
			@PathVariable("noNota") String noNota,
			RedirectAttributes redirectAttrs) {
		TrHeaderPenjualanDto isExist = svc.listTransaksiHeader(noNota);

		if (isExist != null) {
			List<MstBarangDto> barang = bSvc.getListAllBarang();
			TrDetailPenjualanDto detail = new TrDetailPenjualanDto();
			model.addAttribute("noNota", noNota);
			model.addAttribute("barangData", barang);
			model.addAttribute("detail", detail);
			return "viewTransaksiDetailTambah";
		} else {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "kode detail tidak ada", "error"));
			return "redirect:/transaksi/list";
		}
	}

	@RequestMapping("/detail/tambah/proses/{noNota}")
	public String detail_tambah_proses(
			@Valid @ModelAttribute("detail") TrDetailPenjualanDto detail,
			BindingResult result, ModelMap model,
			@PathVariable("noNota") String noNota) {

		if (result.hasErrors()) {
			return "redirect:/transaksi/detail/tambah/" + noNota;
		}

		TrHeaderPenjualanDto isExist = svc.listTransaksiHeader(noNota);

		if (isExist == null) {
			return "redirect:/transaksi/list";
		} else {
			svc.saveDetail(detail);
			List<TrDetailPenjualanDto> forUpdateHeader = svc
					.listTransaksiDetailByNoNota(noNota);
			TrHeaderPenjualanDto newme = svc.listTransaksiHeader(noNota);

			int hargaTotal = 0;
			int globaldiskon = newme.getGlobalDiskon();

			for (TrDetailPenjualanDto h : forUpdateHeader) {
				hargaTotal += h.getSubtotal();
			}

			int globalDiskonRP = (hargaTotal * newme.getGlobalDiskon()) / 100;

			newme.setHargaTotal(hargaTotal - globalDiskonRP);

			svc.saveHargaTotalHeader(newme);

			return "redirect:/transaksi/detail/" + detail.getNoNota();
		}
	}

	@RequestMapping("/hapusheader/{noNota}")
	public String delete(@PathVariable("noNota") String noNota,
			RedirectAttributes redirectAttrs) {
		try {

			svc.deleteHeader(noNota);
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Berhasil", "Data Berhasil di Hapus", "success"));
			return "redirect:/transaksi/list";
		} catch (Exception err) {
			redirectAttrs.addFlashAttribute("swalMessage", new RestResponse(
					"Error!", "Kode Karyawan tidak ada!!!", "error"));
			return "redirect:/transaksi/list";
		}
	}

	// form header
	@RequestMapping("/tambah")
	public String addHeader(Model model, HttpServletRequest request) {
		List<MstKaryawanDto> karyawan = kSvc.getListAllKaryawan();
		List<MstCustomerDto> customer = cSvc.getListCustomer();
		TrHeaderPenjualanDto dto = new TrHeaderPenjualanDto();
		model.addAttribute("data", dto);
		model.addAttribute("pelanggan", customer);
		model.addAttribute("karyawan", karyawan);
		return "viewTransaksiHeaderTambah";
	}

	// method simpan header
	@RequestMapping("/simpanheader/proses")
	public String tambahProsesHeader(
			@Valid @ModelAttribute("data") TrHeaderPenjualanDto dto,
			BindingResult result, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("anotherError",
					"No Nota sudah terpakai");
			return "redirect:/transaksi/tambah";
		} else {
			svc.saveHeader(dto);
			return "redirect:/transaksi/detail/tambah/" + dto.getNoNota();
		}
	}

}
