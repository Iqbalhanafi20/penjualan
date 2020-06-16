package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstBarangDto;

public interface BarangSvc {
	public List<MstBarangDto> getListAllBarang();
	public MstBarangDto getBarangByKode(String kodeBarang);
//	public List<Object[]> getListAllBarangWithSupplier(); 
	
	public void simpanBarang(MstBarangDto barangDto);
	public void ubahBarang(MstBarangDto barangDto);
	public void hapusBarang(String kodeBarang);
}
