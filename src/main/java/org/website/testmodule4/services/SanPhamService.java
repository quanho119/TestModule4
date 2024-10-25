package org.website.testmodule4.services;

import org.springframework.stereotype.Service;
import org.website.testmodule4.models.LoaiSanPham;
import org.website.testmodule4.models.SanPham;
import org.website.testmodule4.repositories.SanPhamRepository;

import java.util.List;

@Service
public class SanPhamService {
    private final SanPhamRepository sanPhamRepository;

    public SanPhamService(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    public SanPham getSanPhamById(Long id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    public SanPham saveSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    public void deleteSanPham(Long id) {
        sanPhamRepository.deleteById(id);
    }
    public List<SanPham> getByLoadSanPham(LoaiSanPham loaiSanPham) {
        return sanPhamRepository.findSanPhamByLoaiSanPham(loaiSanPham);
    }
}
