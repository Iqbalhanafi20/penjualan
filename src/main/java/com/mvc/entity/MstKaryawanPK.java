package com.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class MstKaryawanPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="KODE_KARYAWAN")
	private String kodeKaryawan;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((kodeKaryawan == null) ? 0 : kodeKaryawan.hashCode());
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
		MstKaryawanPK other = (MstKaryawanPK) obj;
		if (kodeKaryawan == null) {
			if (other.kodeKaryawan != null)
				return false;
		} else if (!kodeKaryawan.equals(other.kodeKaryawan))
			return false;
		return true;
	}

	public String getKodeKaryawan() {
		return kodeKaryawan;
	}

	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	
	

}
