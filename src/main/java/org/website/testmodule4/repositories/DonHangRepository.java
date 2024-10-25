package org.website.testmodule4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.website.testmodule4.models.DonHang;

import java.time.LocalDateTime;
import java.util.List;

public interface DonHangRepository extends JpaRepository<DonHang,Long> {
    @Query("SELECT d FROM DonHang d ORDER BY (d.sanPham.giaSp * d.soLuong) DESC")
    List<DonHang> findTopDonHangByTongTien();
    @Query("SELECT d FROM DonHang d WHERE d.ngayMua BETWEEN :startDate AND :endDate")
    List<DonHang> findByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
