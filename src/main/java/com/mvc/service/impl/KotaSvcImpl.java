package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.MstKotaDao;
import com.mvc.dto.MstKotaDto;
import com.mvc.entity.MstKota;
import com.mvc.entity.MstKotaPK;
import com.mvc.service.KotaSvc;

@Transactional
@Service
public class KotaSvcImpl implements KotaSvc {

	@Autowired
	private MstKotaDao dao;

	@Override
	public List<MstKotaDto> getListKota() {
		List<Object[]> obj = dao.getListAllKota();

		List<MstKotaDto> dto = new ArrayList<MstKotaDto>();

		for (Object[] o : obj) {
			MstKotaDto d = new MstKotaDto();
			MstKota kota = (MstKota) o[0];
			String namaProvinsi = (String) o[1];

			d.setKodeKota(kota.getKodeKota());
			d.setKodeProvinsi(kota.getKodeProvinsi());
			d.setNamaKota(kota.getNamaKota());
			d.setNamaProvinsi(namaProvinsi);

			dto.add(d);
		}

		return dto;
	}

	@Override
	public MstKotaDto checkDataKotaByKode(String kodeKota) {
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(kodeKota);
		MstKota kota = dao.findOne(pk);

		if (kota != null) {
			MstKotaDto dto = new MstKotaDto();

			dto.setKodeKota(kota.getKodeKota());
			dto.setKodeProvinsi(kota.getKodeProvinsi());
			dto.setNamaKota(kota.getNamaKota());
			dto.setNamaProvinsi("justfilled");
			
			return dto;
		}

		return null;
	}

	@Override
	public void tambahKota(MstKotaDto dto) {
		MstKota kota = new MstKota();

		kota.setKodeKota(dto.getKodeKota());
		kota.setKodeProvinsi(dto.getKodeProvinsi());
		kota.setNamaKota(dto.getNamaKota());

		dao.save(kota);
	}

	@Override
	public void ubahKota(MstKotaDto dto) {
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(dto.getKodeKota());
		MstKota kota = dao.findOne(pk);

		kota.setKodeProvinsi(dto.getKodeProvinsi());
		kota.setNamaKota(dto.getNamaKota());

		dao.save(kota);
	}

	@Override
	public void hapusKota(String kodeKota) {
		MstKotaPK pk = new MstKotaPK();
		pk.setKodeKota(kodeKota);
		dao.delete(pk);
	}

}
