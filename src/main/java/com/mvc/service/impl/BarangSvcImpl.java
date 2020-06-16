package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstBarangDao;
import com.mvc.dto.MstBarangDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.MstBarangPK;
import com.mvc.service.BarangSvc;

@Transactional
@Service
public class BarangSvcImpl implements BarangSvc{

	@Autowired
	private MstBarangDao dao;
	
	@Override
	public List<MstBarangDto> getListAllBarang() {
		List<MstBarangDto> getAll = new ArrayList<MstBarangDto>();
		List<Object[]> dtos = dao.findAllBarang2();
		
		for (Object[] ob : dtos) {
			MstBarangDto dto = new MstBarangDto();
			MstBarang list = (MstBarang) ob[0];
			
			dto.setKodeBarang(list.getKodeBarang());
			dto.setKodeSupplier((String) ob[1]);
			dto.setNamaBarang(list.getNamaBarang());
			dto.setStokBarang(list.getStokBarang());
			
			getAll.add(dto);
		}
		
		return getAll;
	}

	@Override
	public MstBarangDto getBarangByKode(String kodeBarang) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(kodeBarang);
		MstBarang found = dao.findOne(pk);
		
		if (found != null) {
			MstBarangDto dto = new MstBarangDto();
			
			dto.setKodeBarang(found.getKodeBarang());
			dto.setKodeSupplier(found.getKodeSupplier());
			dto.setNamaBarang(found.getNamaBarang());
			dto.setStokBarang(found.getStokBarang());
			
			return dto;
		}
		
		return null;
	}

	@Override
	public void simpanBarang(MstBarangDto barangDto) {
		MstBarang insertMe = new MstBarang();
		insertMe.setKodeBarang(barangDto.getKodeBarang());
		insertMe.setKodeSupplier(barangDto.getKodeSupplier());
		insertMe.setNamaBarang(barangDto.getNamaBarang());
		insertMe.setStokBarang(barangDto.getStokBarang());
		
		dao.save(insertMe);
	}

	@Override
	public void ubahBarang(MstBarangDto barangDto) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(barangDto.getKodeBarang());
		MstBarang dto = dao.findOne(pk);
		
		dto.setKodeSupplier(barangDto.getKodeSupplier());
		dto.setNamaBarang(barangDto.getNamaBarang());
		dto.setStokBarang(barangDto.getStokBarang());
		
		dao.save(dto);
	}

	@Override
	public void hapusBarang(String kodeBarang) {
		MstBarangPK pk = new MstBarangPK();
		pk.setKodeBarang(kodeBarang);
		MstBarang dto = dao.findOne(pk);
		
		dao.delete(dto);
	}

}
