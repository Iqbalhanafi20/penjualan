package com.mvc.service;

import java.util.List;

import com.mvc.dto.TrDetailPenjualanDto;
import com.mvc.dto.TrHeaderPenjualanDto;

public interface TransaksiSvc {
	public List<TrDetailPenjualanDto> listTransaksiDetailByNoNota(String noNota);
	public List<TrHeaderPenjualanDto> listTransaksiHeader();
	public TrHeaderPenjualanDto listTransaksiHeader(String noNota);
	public List<TrHeaderPenjualanDto> listTransaksiHeaderSearch(String cari);
	public TrDetailPenjualanDto getDetailByKode(String kodeDetail);
	
	public void saveDetail(TrDetailPenjualanDto dto);
	public void updateDetail(TrDetailPenjualanDto dto);
	public void deleteDetail(String kodeDetail);
	
	public void saveHeader(TrHeaderPenjualanDto dto);
	public void updateHeader(TrHeaderPenjualanDto dto);
	public void deleteHeader(String noNota);
	
	public void saveHargaTotalHeader(TrHeaderPenjualanDto dto);
}
