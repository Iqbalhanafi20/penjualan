package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKaryawanDao;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.entity.MstKaryawan;
import com.mvc.entity.MstKaryawanPK;
import com.mvc.service.KaryawanSvc;
@Transactional
@Service
public class KaryawanSvcImpl implements KaryawanSvc {
	
	@Autowired
	private MstKaryawanDao dao;
	
	@Override
	public List<MstKaryawanDto> getListAllKaryawan() {
		// TODO Auto-generated method stub
		List<MstKaryawan> dtos = dao.findAll();
		List<MstKaryawanDto> getAll =  new ArrayList<MstKaryawanDto>();
		
		for(MstKaryawan list : dtos){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(list.getKodeKaryawan());
			dto.setNamaKaryawan(list.getNamaKaryawan());
			dto.setUsername(list.getUsername());
			dto.setPassword(list.getPassword());
			
			getAll.add(dto);
		}
		return getAll;
	}

	@Override
	public void save(MstKaryawanDto dto) {
		// TODO Auto-generated method stub
		MstKaryawan kr = new MstKaryawan();
		kr.setKodeKaryawan(dto.getKodeKaryawan());
		kr.setNamaKaryawan(dto.getNamaKaryawan());
		kr.setUsername(dto.getUsername());
		kr.setPassword(dto.getPassword());
		dao.save(kr);
	}

	@Override
	public void update(MstKaryawanDto dto) {
		// TODO Auto-generated method stub
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(dto.getKodeKaryawan());
		MstKaryawan kr = dao.findOne(pk);
		kr.setKodeKaryawan(dto.getKodeKaryawan());
		kr.setNamaKaryawan(dto.getNamaKaryawan());
		kr.setUsername(dto.getUsername());
		kr.setPassword(dto.getPassword());
		dao.save(kr);
	}

	@Override
	public void delete(String kodeKaryawan) {
		// TODO Auto-generated method stub
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(kodeKaryawan);
		dao.delete(pk);
	}

	@Override
	public MstKaryawanDto findOne(String kodeKaryawan) {
		// TODO Auto-generated method stub
		MstKaryawanPK pk = new MstKaryawanPK();
		pk.setKodeKaryawan(kodeKaryawan);
		MstKaryawan kr = dao.findOne(pk);
		
		if(kr != null){
			MstKaryawanDto dto = new MstKaryawanDto();
			dto.setKodeKaryawan(kr.getKodeKaryawan());
			dto.setNamaKaryawan(kr.getNamaKaryawan());
			dto.setUsername(kr.getUsername());
			dto.setPassword(kr.getPassword());
			return dto;
		}else{
			return null;
		}
	}

}
