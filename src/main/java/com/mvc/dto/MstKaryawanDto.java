package com.mvc.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class MstKaryawanDto {
	@NotEmpty(message = "Silakan isi Kode Karyawan")
	private String kodeKaryawan;
	@NotEmpty(message = "Silakan isi Nama Karyawan")
	private String namaKaryawan;
	@NotEmpty(message = "Silakan isi Password")
	private String password;
	@NotEmpty(message = "Silakan isi Username")
	private String username;
	
	public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
