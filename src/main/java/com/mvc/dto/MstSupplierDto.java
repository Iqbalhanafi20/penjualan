package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstSupplierDto {
	@NotEmpty(message = "Silakan isi Kode Supplier")
	private String kodeSupplier;
	@NotEmpty(message = "Silakan isi Alamat")
	private String alamatSupplier;
	@NotEmpty(message = "Silakan isi Email")
	private String emailSupplier;
	@NotEmpty(message = "Silakan pilih  Kota")
	private String kodeKota;
	@NotEmpty(message = "Silakan isi Nama Supplier")
	private String namaSupplier;
	@NotEmpty(message = "Silakan isi Telpon")
	private String telpSupplier;
	
	
	public String getKodeSupplier() {
		return kodeSupplier;
	}
	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}
	public String getAlamatSupplier() {
		return alamatSupplier;
	}
	public void setAlamatSupplier(String alamatSupplier) {
		this.alamatSupplier = alamatSupplier;
	}
	public String getEmailSupplier() {
		return emailSupplier;
	}
	public void setEmailSupplier(String emailSupplier) {
		this.emailSupplier = emailSupplier;
	}
	public String getKodeKota() {
		return kodeKota;
	}
	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}
	public String getNamaSupplier() {
		return namaSupplier;
	}
	public void setNamaSupplier(String namaSupplier) {
		this.namaSupplier = namaSupplier;
	}
	public String getTelpSupplier() {
		return telpSupplier;
	}
	public void setTelpSupplier(String telpSupplier) {
		this.telpSupplier = telpSupplier;
	}
	
	
	

}
