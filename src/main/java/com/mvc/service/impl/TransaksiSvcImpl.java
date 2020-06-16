package com.mvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.service.TransaksiSvc;
import com.mvc.dao.TrDetailPenjualanDao;
import com.mvc.dao.TrHeaderPenjualanDao;
import com.mvc.dto.TrDetailPenjualanDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.MstBarang;
import com.mvc.entity.MstCustomer;
import com.mvc.entity.MstKaryawan;
import com.mvc.entity.TrDetailPenjualan;
import com.mvc.entity.TrDetailPenjualanPK;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.entity.TrHeaderPenjualanPK;

import helper.helper;

@Transactional
@Service
public class TransaksiSvcImpl implements TransaksiSvc {

	@Autowired
	private TrDetailPenjualanDao detailDao;
	@Autowired
	private TrHeaderPenjualanDao headerDao;
	
	@Override
	public List<TrDetailPenjualanDto> listTransaksiDetailByNoNota(String noNota) {
		// TODO Auto-generated method stub
		List<Object[]> list = detailDao.listTransaksiDetailByNoNota(noNota);
		List<TrDetailPenjualanDto> transaksiDtos = new ArrayList<>();
		
		for (Object[] l : list) {
			TrDetailPenjualanDto transaksiDto = new TrDetailPenjualanDto();
			TrDetailPenjualan detail = (TrDetailPenjualan)l[0];
			MstBarang barang = (MstBarang)l[1];
			
			transaksiDto.setDiskon(detail.getDiskon());
			transaksiDto.setHargaSatuan(detail.getHargaSatuan());
			transaksiDto.setKodeBarang(detail.getKodeBarang());
			transaksiDto.setKodeDetail(detail.getKodeDetail());
			transaksiDto.setNamaBarang(barang.getNamaBarang());
			transaksiDto.setNoNota(detail.getNoNota());
			transaksiDto.setQty(detail.getQty());
			transaksiDto.setSubtotal(detail.getSubtotal());
			transaksiDto.setStok(barang.getStokBarang());
			
			transaksiDtos.add(transaksiDto);
		}
		
		return transaksiDtos;
	}

	@Override
	public List<TrHeaderPenjualanDto> listTransaksiHeader() {
		List<Object[]> list = headerDao.listTransaksiHeader();
		List<TrHeaderPenjualanDto> transaksiHeaderDtos = new ArrayList<>();
		
		for (Object[] l : list) {
			TrHeaderPenjualanDto transaksiHeaderDto = new TrHeaderPenjualanDto();
			TrHeaderPenjualan header = (TrHeaderPenjualan)l[0];
			MstCustomer customer = (MstCustomer)l[1];
			MstKaryawan karyawan = (MstKaryawan)l[2];
			
			transaksiHeaderDto.setDetail(this.listTransaksiDetailByNoNota(header.getNoNota()));
			transaksiHeaderDto.setGlobalDiskon(header.getGlobalDiskon());
			transaksiHeaderDto.setHargaTotal(header.getHargaTotal());
			transaksiHeaderDto.setDisplayHargaTotal(helper.formatCurrency(header.getHargaTotal()));
			transaksiHeaderDto.setKodeCustomer(customer.getKodeCustomer());
			transaksiHeaderDto.setKodeKaryawan(karyawan.getKodeKaryawan());
			transaksiHeaderDto.setNamaCustomer(customer.getNamaCustomer());
			transaksiHeaderDto.setNamaKaryawan(karyawan.getNamaKaryawan());
			transaksiHeaderDto.setNoNota(header.getNoNota());
			transaksiHeaderDto.setTanggalTransaksi(header.getTanggalTransaksi());
			
			transaksiHeaderDtos.add(transaksiHeaderDto);
			
		}
		
		return transaksiHeaderDtos;
	}
	
	@Override
	public TrHeaderPenjualanDto listTransaksiHeader(String noNota) {
		List<Object[]> list = headerDao.listTransaksiHeader(noNota);
		TrHeaderPenjualanDto transaksiHeaderDto = new TrHeaderPenjualanDto();
		for (Object[] l : list) {
			TrHeaderPenjualan header = (TrHeaderPenjualan)l[0];
			MstCustomer customer = (MstCustomer)l[1];
			MstKaryawan karyawan = (MstKaryawan)l[2];
			
			transaksiHeaderDto.setDetail(this.listTransaksiDetailByNoNota(header.getNoNota()));
			transaksiHeaderDto.setGlobalDiskon(header.getGlobalDiskon());
			transaksiHeaderDto.setHargaTotal(header.getHargaTotal());
			transaksiHeaderDto.setDisplayHargaTotal(helper.formatCurrency(header.getHargaTotal()));
			transaksiHeaderDto.setKodeCustomer(customer.getKodeCustomer());
			transaksiHeaderDto.setKodeKaryawan(karyawan.getKodeKaryawan());
			transaksiHeaderDto.setNamaCustomer(customer.getNamaCustomer());
			transaksiHeaderDto.setNamaKaryawan(karyawan.getNamaKaryawan());
			transaksiHeaderDto.setNoNota(header.getNoNota());
			transaksiHeaderDto.setTanggalTransaksi(header.getTanggalTransaksi());
			
		}
		
		return transaksiHeaderDto;
	}

	@Override
	public List<TrHeaderPenjualanDto> listTransaksiHeaderSearch(String cari) {
		List<Object[]> list = headerDao.listTransaksiHeaderSearch(cari);
		List<TrHeaderPenjualanDto> transaksiHeaderDtos = new ArrayList<>();
		
		for (Object[] l : list) {
			TrHeaderPenjualanDto transaksiHeaderDto = new TrHeaderPenjualanDto();
			TrHeaderPenjualan header = (TrHeaderPenjualan)l[0];
			MstCustomer customer = (MstCustomer)l[1];
			MstKaryawan karyawan = (MstKaryawan)l[2];
			
			transaksiHeaderDto.setDetail(this.listTransaksiDetailByNoNota(header.getNoNota()));
			transaksiHeaderDto.setGlobalDiskon(header.getGlobalDiskon());
			transaksiHeaderDto.setHargaTotal(header.getHargaTotal());
			transaksiHeaderDto.setKodeCustomer(customer.getKodeCustomer());
			transaksiHeaderDto.setKodeKaryawan(karyawan.getKodeKaryawan());
			transaksiHeaderDto.setNamaCustomer(customer.getNamaCustomer());
			transaksiHeaderDto.setNamaKaryawan(karyawan.getNamaKaryawan());
			transaksiHeaderDto.setNoNota(header.getNoNota());
			transaksiHeaderDto.setTanggalTransaksi(header.getTanggalTransaksi());
			
			transaksiHeaderDtos.add(transaksiHeaderDto);
			
		}
		
		return transaksiHeaderDtos;
	}

	@Override
	public void saveDetail(TrDetailPenjualanDto dto) {
		TrDetailPenjualan trDetail = new TrDetailPenjualan();
		trDetail.setDiskon(dto.getDiskon());
		trDetail.setHargaSatuan(dto.getHargaSatuan());
		trDetail.setKodeBarang(dto.getKodeBarang());
		trDetail.setKodeDetail(dto.getKodeDetail());
		trDetail.setNoNota(dto.getNoNota());
		trDetail.setQty(dto.getQty());
		trDetail.setSubtotal(dto.getSubtotal());
		
		detailDao.save(trDetail);
		
	}

	@Override
	public void updateDetail(TrDetailPenjualanDto dto) {
		TrDetailPenjualanPK trDetailPK = new TrDetailPenjualanPK();
		trDetailPK.setKodeDetail(dto.getKodeDetail());
		TrDetailPenjualan trDetail = detailDao.findOne(trDetailPK);
		
		trDetail.setDiskon(dto.getDiskon());
		trDetail.setHargaSatuan(dto.getHargaSatuan());
		trDetail.setKodeBarang(dto.getKodeBarang());
		trDetail.setKodeDetail(dto.getKodeDetail());
		trDetail.setNoNota(dto.getNoNota());
		trDetail.setQty(dto.getQty());
		trDetail.setSubtotal(dto.getSubtotal());
		
		detailDao.save(trDetail);
		
	}

	@Override
	public void deleteDetail(String kodeDetail) {
		TrDetailPenjualanPK trDetailPK = new TrDetailPenjualanPK();
		trDetailPK.setKodeDetail(kodeDetail);
		TrDetailPenjualan trDetail = detailDao.findOne(trDetailPK);
		
		detailDao.delete(trDetail);		
	}

	@Override
	public void saveHeader(TrHeaderPenjualanDto dto) {
		TrHeaderPenjualan h = new TrHeaderPenjualan();
		
		h.setNoNota(dto.getNoNota());
		h.setGlobalDiskon(dto.getGlobalDiskon());
		h.setHargaTotal(dto.getHargaTotal());
		h.setKodeCustomer(dto.getKodeCustomer());
		h.setKodeKaryawan(dto.getKodeKaryawan());
		h.setTanggalTransaksi(dto.getTanggalTransaksi());
		
		headerDao.save(h);
	}
	
	public void saveHargaTotalHeader(TrHeaderPenjualanDto dto){
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(dto.getNoNota());

		TrHeaderPenjualan h = headerDao.findOne(pk);
		
//		h.setGlobalDiskon(dto.getGlobalDiskon());
		h.setHargaTotal(dto.getHargaTotal());
//		h.setKodeCustomer(dto.getKodeKaryawan());
//		h.setKodeKaryawan(dto.getKodeKaryawan());
//		h.setTanggalTransaksi(dto.getTanggalTransaksi());
		
		headerDao.save(h);
	}

	@Override
	public void updateHeader(TrHeaderPenjualanDto dto) {
		TrHeaderPenjualanPK pk = new TrHeaderPenjualanPK();
		pk.setNoNota(dto.getNoNota());

		TrHeaderPenjualan h = headerDao.findOne(pk);
		
		h.setGlobalDiskon(dto.getGlobalDiskon());
		h.setHargaTotal(dto.getHargaTotal());
		h.setKodeCustomer(dto.getKodeCustomer());
		h.setKodeKaryawan(dto.getKodeKaryawan());
		h.setTanggalTransaksi(dto.getTanggalTransaksi());
		
		headerDao.save(h);
	}

	@Override
	public void deleteHeader(String noNota) {
		// TODO Auto-generated method stub
		TrHeaderPenjualanPK pkheader = new TrHeaderPenjualanPK();
		pkheader.setNoNota(noNota);
		TrHeaderPenjualan trheader = headerDao.findOne(pkheader);
		
		List<TrDetailPenjualan> trdetail = detailDao.findAllDetailBySearch(noNota);
		
		if (trdetail.isEmpty()){
//			hapus header
			headerDao.delete(trheader);
		}else{
//			hapus detail
			detailDao.delete(trdetail);
//			hapus header
			headerDao.delete(trheader);
		}		

	}


	@Override
	public TrDetailPenjualanDto getDetailByKode(String kodeDetail) {
		TrDetailPenjualanPK pk = new TrDetailPenjualanPK();
		pk.setKodeDetail(kodeDetail);
		TrDetailPenjualan d = detailDao.findOne(pk);
		
		if (d != null) {
			TrDetailPenjualanDto dto = new TrDetailPenjualanDto();
			
			dto.setDiskon(d.getDiskon());
			dto.setHargaSatuan(d.getHargaSatuan());
			dto.setKodeBarang(d.getKodeBarang());
			dto.setKodeDetail(d.getKodeDetail());
			dto.setNoNota(d.getNoNota());
			dto.setQty(d.getQty());
			dto.setSubtotal(d.getSubtotal());
			
			return dto;
		}
		
		return null;
	}

}
