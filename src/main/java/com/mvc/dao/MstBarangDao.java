package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.MstBarang;
import com.mvc.entity.MstBarangPK;

public interface MstBarangDao extends JpaRepository<MstBarang, MstBarangPK>{
	@Query("select a, b.namaSupplier from MstBarang a, MstSupplier b where a.kodeSupplier=b.kodeSupplier")
	public List<Object[]> findAllBarang2();
}
