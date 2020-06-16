package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstCustomerDto {
	@NotEmpty(message = "Silahkan isi kode customer")
	private String kodeCustomer;
	@NotEmpty(message = "Silahkan isi alamat customer")
	private String alamatCustomer;
	@NotEmpty(message = "Silahkan isi email customer")
	private String emailCustomer;
	@NotEmpty(message = "Silahkan isi jenis kelamin")
	private String jenisKelamin;
	@NotEmpty(message = "Silahkan isi kota")
	private String kodeKota;
	private String namaCustomer;
	private String namaKota;
	
	public String getNamaKota() {
		return namaKota;
	}
	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}
	public String getKodeCustomer() {
		return kodeCustomer;
	}
	public void setKodeCustomer(String kodeCustomer) {
		this.kodeCustomer = kodeCustomer;
	}
	public String getAlamatCustomer() {
		return alamatCustomer;
	}
	public void setAlamatCustomer(String alamatCustomer) {
		this.alamatCustomer = alamatCustomer;
	}
	public String getEmailCustomer() {
		return emailCustomer;
	}
	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getKodeKota() {
		return kodeKota;
	}
	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}
	public String getNamaCustomer() {
		return namaCustomer;
	}
	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}
	
	
}
