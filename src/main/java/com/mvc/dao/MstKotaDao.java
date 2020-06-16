package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.MstKota;
import com.mvc.entity.MstKotaPK;

public interface MstKotaDao extends JpaRepository<MstKota, MstKotaPK>{

	@Query("select a, b.namaProvinsi from MstKota a, MstProvinsi b where a.kodeProvinsi=b.kodeProvinsi")
	public List<Object[]> getListAllKota();
}
