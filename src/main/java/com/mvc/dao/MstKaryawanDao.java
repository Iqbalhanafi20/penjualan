package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.MstKaryawan;
import com.mvc.entity.MstKaryawanPK;

public interface MstKaryawanDao extends JpaRepository<MstKaryawan, MstKaryawanPK>{
	@Query("select a from MstKaryawan a where a.username = :username")
	public MstKaryawan loginKaryawan(@Param("username")String username);
}
