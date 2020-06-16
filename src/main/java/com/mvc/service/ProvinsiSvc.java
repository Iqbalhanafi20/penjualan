package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstProvinsiDto;

public interface ProvinsiSvc {

	public List<MstProvinsiDto> getAllProvinsi();
	public MstProvinsiDto getProvinsi(String kodeProvinsi);
	
	public void simpanProvinsi(MstProvinsiDto provinsiDto);
	public void ubahProvinsi(MstProvinsiDto provinsiDto);
	public void hapusProvinsi(String kodeProvinsi);
}
