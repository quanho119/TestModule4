package org.website.testmodule4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.website.testmodule4.models.DonHang;
import org.website.testmodule4.models.LoaiSanPham;
import org.website.testmodule4.models.SanPham;
import org.website.testmodule4.services.DonHangService;
import org.website.testmodule4.services.LoaiSanPhamService;
import org.website.testmodule4.services.SanPhamService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/don-hang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;
    public DonHangController(DonHangService donHangService, LoaiSanPhamService loaiSanPhamService, SanPhamService sanPhamService) {
        this.donHangService = donHangService;
        this.loaiSanPhamService = loaiSanPhamService;
        this.sanPhamService = sanPhamService;
    }
    @GetMapping("")
    public String showDonHangPage(Model model) {
        List<DonHang> donHangList = donHangService.getAllDonHang();
        model.addAttribute("donHangList", donHangList);
        return "donHang/list";
    }

//    @GetMapping("/edit/{id}")
//    @ResponseBody
//    public ResponseEntity<DonHang> editOrder(@PathVariable Long id) {
//        DonHang donHang = donHangService.getDonHangById(id);
//        if (donHang == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(donHang);
//    }
    @GetMapping("/edit/{id}")
    public String editDonHang(@PathVariable Long id, Model model) {
        DonHang donHang = donHangService.getDonHangById(id);
        model.addAttribute("donHang", donHang);
        List<LoaiSanPham> loaiSanPhamList = loaiSanPhamService.getAllLoaiSanPham();
        model.addAttribute("loaiSanPhamList", loaiSanPhamList);
        List<SanPham> sanPhamList = sanPhamService.getByLoadSanPham(donHang.getSanPham().getLoaiSanPham());
        model.addAttribute("sanPhamList", sanPhamList);
        return "donHang/edit";
    }

    @PostMapping("/edit")
    public String updateDonHang(@ModelAttribute("donHang")DonHang donHang) {
        donHangService.saveDonHang(donHang);
        return "redirect:/don-hang";
    }

    @GetMapping("/top")
    public String GetTop(Model model) {
        List<DonHang> donHangList = donHangService.getTopDonHang();
        model.addAttribute("donHangList", donHangList);
        return "donHang/list";
    }
}
