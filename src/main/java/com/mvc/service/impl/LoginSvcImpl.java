package com.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKaryawanDao;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.entity.MstKaryawan;
import com.mvc.service.LoginSvc;

@Transactional
@Service
public class LoginSvcImpl implements LoginSvc {
	
	@Autowired
	private MstKaryawanDao dao;

	@Override
	public MstKaryawanDto login(String username) {
		MstKaryawan findKaryawanUser = dao.loginKaryawan(username);
		MstKaryawanDto findKaryawanDto = new MstKaryawanDto();
		
		findKaryawanDto.setKodeKaryawan(findKaryawanUser.getKodeKaryawan());
		findKaryawanDto.setNamaKaryawan(findKaryawanUser.getNamaKaryawan());
		findKaryawanDto.setPassword(findKaryawanUser.getPassword());
		findKaryawanDto.setUsername(findKaryawanUser.getUsername());
		
		return findKaryawanDto;
	}

}
