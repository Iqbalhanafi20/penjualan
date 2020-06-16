package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstSupplierDao;
import com.mvc.dto.MstSupplierDto;
import com.mvc.entity.MstSupplier;
import com.mvc.entity.MstSupplierPK;
import com.mvc.service.SupplierSvc;

@Transactional
@Service
public class SupplierSvcImpl implements SupplierSvc {
	
	@Autowired
	private MstSupplierDao dao;

	@Override
	public List<MstSupplierDto> getAllSupplier() {
		List<MstSupplierDto> dtos = new ArrayList<MstSupplierDto>();
		List<Object[]> get = dao.findAllSupplier();
		for (Object[] ob : get) {
			MstSupplierDto dto = new MstSupplierDto();
			MstSupplier s = (MstSupplier) ob[0];
			dto.setAlamatSupplier(s.getAlamatSupplier());
			dto.setEmailSupplier(s.getEmailSupplier());
			
			dto.setKodeKota((String) ob[1]);
			
			dto.setKodeSupplier(s.getKodeSupplier());
			dto.setNamaSupplier(s.getNamaSupplier());
			dto.setTelpSupplier(s.getTelpSupplier());
			
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public void save(MstSupplierDto dto){
		MstSupplier su = new MstSupplier();
		su.setKodeSupplier(dto.getKodeSupplier());
		su.setNamaSupplier(dto.getNamaSupplier());
		su.setAlamatSupplier(dto.getAlamatSupplier());
		su.setTelpSupplier(dto.getTelpSupplier());
		su.setEmailSupplier(dto.getEmailSupplier());
		su.setKodeKota(dto.getKodeKota());
		dao.save(su);
	}
	
	@Override
	public void update(MstSupplierDto dto){
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(dto.getKodeSupplier());
		MstSupplier su = dao.findOne(pk);
		su.setKodeSupplier(dto.getKodeSupplier());
		su.setNamaSupplier(dto.getNamaSupplier());
		su.setAlamatSupplier(dto.getAlamatSupplier());
		su.setTelpSupplier(dto.getTelpSupplier());
		su.setEmailSupplier(dto.getEmailSupplier());
		su.setKodeKota(dto.getKodeKota());
		dao.save(su);
	}
	
	@Override
	public void delete(String kodeSupplier){
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(kodeSupplier);
		dao.delete(pk);
	}
	
	@Override
	public MstSupplierDto findOne(String kodeSupplier){
		MstSupplierPK pk = new MstSupplierPK();
		pk.setKodeSupplier(kodeSupplier);
		MstSupplier su = dao.findOne(pk);
		
		if(su != null){
			MstSupplierDto dto = new MstSupplierDto();
			dto.setKodeSupplier(su.getKodeSupplier());
			dto.setNamaSupplier(su.getNamaSupplier());
			dto.setAlamatSupplier(su.getAlamatSupplier());
			dto.setTelpSupplier(su.getTelpSupplier());
			dto.setEmailSupplier(su.getEmailSupplier());
			dto.setKodeKota(su.getKodeKota());
			return dto;
		}else{
			return null;
		}
		
	}
	
	
	

}
