package ntt.crud.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quanlisach")
public class Sach {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "masach")
	private long masach;
	@Column(name = "tensach")
	private String tensach;
	@Column(name = "loaisach")
	private String loaisach;
	@Column(name = "ngaynhap")
	private String ngaynhap;
	@Column(name = "ngayban")
	private String ngayban;
	@Column(name = "gia")
	private String gia;
	public Sach() {
		super();
	}
	public Sach(long masach, String tensach, String loaisach, String ngaynhap, String ngayban, String gia) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.loaisach = loaisach;
		this.ngaynhap = ngaynhap;
		this.ngayban = ngayban;
		this.gia = gia;
	}
	public Sach(String tensach, String loaisach, String ngaynhap, String ngayban, String gia) {
		super();
		this.tensach = tensach;
		this.loaisach = loaisach;
		this.ngaynhap = ngaynhap;
		this.ngayban = ngayban;
		this.gia = gia;
	}
	public long getMasach() {
		return masach;
	}
	public void setMasach(long masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getLoaisach() {
		return loaisach;
	}
	public void setLoaisach(String loaisach) {
		this.loaisach = loaisach;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getNgayban() {
		return ngayban;
	}
	public void setNgayban(String ngayban) {
		this.ngayban = ngayban;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
	
	@Override
	public String toString() {
		return "Sach [masach=" + masach + ", tensach=" + tensach + ", loaisach=" + loaisach + ", ngaynhap=" + ngaynhap
				+ ", ngayban=" + ngayban + ", gia=" + gia + "]";
	}
	
}
