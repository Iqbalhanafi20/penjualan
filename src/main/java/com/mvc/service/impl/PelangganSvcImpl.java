package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstCustomerDao;
import com.mvc.dto.MstCustomerDto;
import com.mvc.entity.MstCustomer;
import com.mvc.entity.MstCustomerPK;
import com.mvc.service.PelangganSvc;

@Transactional
@Service
public class PelangganSvcImpl implements PelangganSvc {

	@Autowired
	private MstCustomerDao dao;
	
	@Override
	public List<MstCustomerDto> getListCustomer() {
		List<Object[]> list = dao.getListAllCustomer();
		List<MstCustomerDto> dtos = new ArrayList<MstCustomerDto>();
		
		for (Object[] l : list) {
			MstCustomerDto dto = new MstCustomerDto();
			MstCustomer c = (MstCustomer)l[0];
			String namaKota = (String)l[1];
			
			dto.setAlamatCustomer(c.getAlamatCustomer());
			dto.setEmailCustomer(c.getEmailCustomer());
			dto.setJenisKelamin(c.getJenisKelamin());
			dto.setKodeCustomer(c.getKodeCustomer());
			dto.setKodeKota(c.getKodeKota());
			dto.setNamaCustomer(c.getNamaCustomer());
			dto.setNamaKota(namaKota);
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public void simpanPelanggan(MstCustomerDto customerDto) {
		MstCustomer c = new MstCustomer();
		
		c.setAlamatCustomer(customerDto.getAlamatCustomer());
		c.setEmailCustomer(customerDto.getEmailCustomer());
		c.setJenisKelamin(customerDto.getJenisKelamin());
		c.setKodeCustomer(customerDto.getKodeCustomer());
		c.setKodeKota(customerDto.getKodeKota());
		c.setNamaCustomer(customerDto.getNamaCustomer());
		
		dao.save(c);
	}

	@Override
	public void ubahPelanggan(MstCustomerDto customerDto) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(customerDto.getKodeCustomer());
		MstCustomer c = dao.findOne(pk);
		
		if (c != null) {
			c.setAlamatCustomer(customerDto.getAlamatCustomer());
			c.setEmailCustomer(customerDto.getEmailCustomer());
			c.setJenisKelamin(customerDto.getJenisKelamin());
			c.setKodeCustomer(c.getKodeCustomer());
			c.setKodeKota(customerDto.getKodeKota());
			c.setNamaCustomer(customerDto.getNamaCustomer());
			
			dao.save(c);
		}
	}

	@Override
	public void hapusPelanggan(String kodeCustomer) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(kodeCustomer);
		MstCustomer c = dao.findOne(pk);
		dao.delete(c);
	}

	@Override
	public MstCustomerDto getCustomer(String kodeCustomer) {
		MstCustomerPK pk = new MstCustomerPK();
		pk.setKodeCustomer(kodeCustomer);
		MstCustomer c = dao.findOne(pk);
		
		if (c != null) {
			MstCustomerDto dto = new MstCustomerDto();
			dto.setAlamatCustomer(c.getAlamatCustomer());
			dto.setEmailCustomer(c.getEmailCustomer());
			dto.setJenisKelamin(c.getJenisKelamin());
			dto.setKodeCustomer(c.getKodeCustomer());
			dto.setKodeKota(c.getKodeKota());
			dto.setNamaCustomer(c.getNamaCustomer());
			return dto;
		}
		
		return null;
	}

}
