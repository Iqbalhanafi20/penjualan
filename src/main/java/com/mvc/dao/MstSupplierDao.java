package com.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.mvc.entity.MstSupplier;
import com.mvc.entity.MstSupplierPK;

public interface MstSupplierDao extends JpaRepository<MstSupplier, MstSupplierPK>{
@Query("select a, b.namaKota from MstSupplier a, MstKota b where a.kodeKota=b.kodeKota")
public List<Object[]> findAllSupplier();


}
