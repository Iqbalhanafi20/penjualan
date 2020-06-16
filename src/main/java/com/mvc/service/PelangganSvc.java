package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstCustomerDto;

public interface PelangganSvc {

	public List<MstCustomerDto> getListCustomer();
	public MstCustomerDto getCustomer(String kodeCustomer);
	
	public void simpanPelanggan(MstCustomerDto customerDto);
	public void ubahPelanggan(MstCustomerDto customerDto);
	public void hapusPelanggan(String kodeCustomer);
}
