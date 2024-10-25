package org.website.testmodule4.services;

import org.springframework.stereotype.Service;
import org.website.testmodule4.models.LoaiSanPham;
import org.website.testmodule4.repositories.LoaiSanPhamRepository;

import java.util.List;

@Service
public class LoaiSanPhamService {
    private final LoaiSanPhamRepository loaiSanPhamRepository;

    public LoaiSanPhamService(LoaiSanPhamRepository loaiSanPhamRepository) {
        this.loaiSanPhamRepository = loaiSanPhamRepository;
    }

    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }

    public LoaiSanPham getLoaiSanPhamById(Long id) {
        return loaiSanPhamRepository.findById(id).orElse(null);
    }

    public LoaiSanPham saveLoaiSanPham(LoaiSanPham loaiSanPham) {
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    public void deleteLoaiSanPham(Long id) {
        loaiSanPhamRepository.deleteById(id);
    }
}
