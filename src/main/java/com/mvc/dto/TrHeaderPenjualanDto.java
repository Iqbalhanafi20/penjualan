package com.mvc.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TrHeaderPenjualanDto {
	private String noNota;
	private int globalDiskon;
	private int hargaTotal;
	private String displayHargaTotal;
	private String kodeCustomer;
	private String kodeKaryawan;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Silakan isi tanggal transaksi")
	private Date tanggalTransaksi;
	private String namaCustomer;
	private String namaKaryawan;
	private List<TrDetailPenjualanDto> detail;

	public String getDisplayHargaTotal() {
		return displayHargaTotal;
	}

	public void setDisplayHargaTotal(String displayHargaTotal) {
		this.displayHargaTotal = displayHargaTotal;
	}

	public List<TrDetailPenjualanDto> getDetail() {
		return detail;
	}

	public void setDetail(List<TrDetailPenjualanDto> detail) {
		this.detail = detail;
	}

	public String getNoNota() {
		return noNota;
	}

	public void setNoNota(String noNota) {
		this.noNota = noNota;
	}

	public int getGlobalDiskon() {
		return globalDiskon;
	}

	public void setGlobalDiskon(int globalDiskon) {
		this.globalDiskon = globalDiskon;
	}

	public int getHargaTotal() {
		return hargaTotal;
	}

	public void setHargaTotal(int hargaTotal) {
		this.hargaTotal = hargaTotal;
	}

	public String getKodeCustomer() {
		return kodeCustomer;
	}

	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}

	public String getKodeKaryawan() {
		return kodeKaryawan;
	}

	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}

	public Date getTanggalTransaksi() {
		return tanggalTransaksi;
	}

	public void setTanggalTransaksi(Date tanggalTransaksi) {
		this.tanggalTransaksi = tanggalTransaksi;
	}

	public String getNamaCustomer() {
		return namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
}
