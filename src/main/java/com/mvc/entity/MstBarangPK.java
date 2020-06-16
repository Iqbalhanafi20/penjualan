package com.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class MstBarangPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="KODE_BARANG")
	private String kodeBarang;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeBarang == null) ? 0 : kodeBarang.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstBarangPK other = (MstBarangPK) obj;
		if (kodeBarang == null) {
			if (other.kodeBarang != null)
				return false;
		} else if (!kodeBarang.equals(other.kodeBarang))
			return false;
		return true;
	}

	public String getKodeBarang() {
		return kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	
	

}
