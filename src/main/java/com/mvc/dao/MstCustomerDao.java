package com.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvc.entity.MstCustomer;
import com.mvc.entity.MstCustomerPK;

public interface MstCustomerDao extends JpaRepository<MstCustomer, MstCustomerPK>{

	@Query("select a, b.namaKota from MstCustomer a, MstKota b where a.kodeKota=b.kodeKota")
	public List<Object[]> getListAllCustomer();
}
