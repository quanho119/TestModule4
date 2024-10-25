package org.website.testmodule4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.website.testmodule4.models.LoaiSanPham;
import org.website.testmodule4.models.SanPham;

public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham,Long> {
}
