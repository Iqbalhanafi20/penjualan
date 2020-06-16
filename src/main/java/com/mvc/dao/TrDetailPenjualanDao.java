package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvc.entity.TrDetailPenjualan;
import com.mvc.entity.TrDetailPenjualanPK;
import com.mvc.entity.TrHeaderPenjualan;

public interface TrDetailPenjualanDao extends
		JpaRepository<TrDetailPenjualan, TrDetailPenjualanPK> {
	@Query("select a,b,c,d,e from TrDetailPenjualan a, MstBarang b, TrHeaderPenjualan c, MstCustomer d, MstKaryawan e where a.kodeBarang = b.kodeBarang and a.noNota = c.noNota and c.kodeCustomer = d.kodeCustomer and c.kodeKaryawan = e.kodeKaryawan and (a.noNota like %:noNota%)")
	public List<Object[]> listTransaksiDetailByNoNota(@Param("noNota")String noNota);
	
	@Query("select a from TrDetailPenjualan a where "
			+ "(a.noNota like %:noNota%)")
	public List<TrDetailPenjualan> findAllDetailBySearch(@Param("noNota") String noNota);
}
