package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstProvinsiDao;
import com.mvc.dto.MstProvinsiDto;
import com.mvc.entity.MstProvinsi;
import com.mvc.entity.MstProvinsiPK;
import com.mvc.service.ProvinsiSvc;

@Transactional
@Service
public class ProvinsiSvcImpl implements ProvinsiSvc {

	@Autowired
	private MstProvinsiDao dao;
	
	@Override
	public List<MstProvinsiDto> getAllProvinsi() {
		List<MstProvinsiDto> dtos = new ArrayList<MstProvinsiDto>();
		List<MstProvinsi> all = dao.findAll();
		
		for (MstProvinsi a : all) {
			MstProvinsiDto dto = new MstProvinsiDto();
			
			dto.setKodeProvinsi(a.getKodeProvinsi());
			dto.setNamaProvinsi(a.getNamaProvinsi());
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public MstProvinsiDto getProvinsi(String kodeProvinsi) {
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(kodeProvinsi);
		MstProvinsi p = dao.findOne(pk);
		
		if (p != null) {
			MstProvinsiDto dto = new MstProvinsiDto();
			
			dto.setKodeProvinsi(p.getKodeProvinsi());
			dto.setNamaProvinsi(p.getNamaProvinsi());
			
			return dto;
		}
		
		return null;
	}

	@Override
	public void simpanProvinsi(MstProvinsiDto provinsiDto) {
		MstProvinsi p = new MstProvinsi();
		
		p.setKodeProvinsi(provinsiDto.getKodeProvinsi());
		p.setNamaProvinsi(provinsiDto.getNamaProvinsi());
		
		dao.save(p);
	}

	@Override
	public void ubahProvinsi(MstProvinsiDto provinsiDto) {
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(provinsiDto.getKodeProvinsi());
		MstProvinsi p = dao.findOne(pk);
		
		if (p != null) {
			p.setNamaProvinsi(provinsiDto.getNamaProvinsi());
			dao.save(p);
		}
	}

	@Override
	public void hapusProvinsi(String kodeProvinsi) {
		MstProvinsiPK pk = new MstProvinsiPK();
		pk.setKodeProvinsi(kodeProvinsi);
		MstProvinsi p = dao.findOne(pk);
		
		dao.delete(p);
	}

}
