package com.mvc.service;

import java.util.List;

import com.mvc.dto.MstKaryawanDto;

public interface KaryawanSvc {
public List<MstKaryawanDto> getListAllKaryawan();
public void save(MstKaryawanDto dto);
public void update(MstKaryawanDto dto);
public void delete(String kodeKaryawan);
public MstKaryawanDto findOne(String kodeKaryawan);
}
