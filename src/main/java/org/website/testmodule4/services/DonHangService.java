package org.website.testmodule4.services;

import org.springframework.stereotype.Service;
import org.website.testmodule4.models.DonHang;
import org.website.testmodule4.repositories.DonHangRepository;

import java.util.List;

@Service
public class DonHangService {
    private final DonHangRepository donHangRepository;
    public DonHangService(DonHangRepository donHangRepository) {
        this.donHangRepository = donHangRepository;
    }
    public List<DonHang> getAllDonHang() {
        return donHangRepository.findAll();
    }
    public DonHang getDonHangById(Long id) {
        return donHangRepository.findById(id).orElse(null);
    }
    public DonHang saveDonHang(DonHang donHang) {
        return donHangRepository.save(donHang);
    }
    public void deleteDonHang(Long id) {
        donHangRepository.deleteById(id);
    }

    public List<DonHang> getTopDonHang() {
        return donHangRepository.findTopDonHangByTongTien();
    }
}
