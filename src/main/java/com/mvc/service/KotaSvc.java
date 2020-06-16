package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstKotaDto;

public interface KotaSvc {

	public List<MstKotaDto> getListKota();
	public MstKotaDto checkDataKotaByKode(String kodeKota);
	
	public void tambahKota(MstKotaDto dto);
	public void ubahKota(MstKotaDto dto);
	public void hapusKota(String kodeKota);
	
}
