package org.website.testmodule4.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_loai_sp")
    private Long maLoaiSp;
    @Column(name = "ten_loai_sp")
    private String tenLoaiSp;

    public Long getMaLoaiSp() {
        return maLoaiSp;
    }

    public void setMaLoaiSp(Long maLoaiSp) {
        this.maLoaiSp = maLoaiSp;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }
}
