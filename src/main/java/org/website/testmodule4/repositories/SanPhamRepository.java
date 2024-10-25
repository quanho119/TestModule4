package org.website.testmodule4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.website.testmodule4.models.LoaiSanPham;
import org.website.testmodule4.models.SanPham;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPham,Long>{
    List<SanPham> findSanPhamByLoaiSanPham(LoaiSanPham loaiSanPham);
}
