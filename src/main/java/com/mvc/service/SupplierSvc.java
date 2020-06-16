package com.mvc.service;

import java.util.List;
import com.mvc.dto.MstSupplierDto;

public interface SupplierSvc {
	public List<MstSupplierDto> getAllSupplier();
	public void save(MstSupplierDto dto);
	public void update(MstSupplierDto dto);
	public void delete(String kodeSupplier);
	public MstSupplierDto findOne(String kodeSupplier);
}
