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

import java.time.LocalDateTime;
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

//    @GetMapping("/san-pham/{id}")
//    @ResponseBody
//    public List<SanPham> getSanPhamByLoai(@PathVariable Long id) {
//        LoaiSanPham loaiSanPham = loaiSanPhamService.getLoaiSanPhamById(id);
//        return sanPhamService.getByLoadSanPham(loaiSanPham);
//    }

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
    @GetMapping("/filter")
    public String filterDonHang(@RequestParam("startDate") String startDateStr,
                                @RequestParam("endDate") String endDateStr,
                                Model model) {
        LocalDateTime startDate = LocalDateTime.parse(startDateStr + "T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse(endDateStr + "T23:59:59");

        List<DonHang> donHangList = donHangService.findByDateRange(startDate, endDate);
        model.addAttribute("donHangList", donHangList);
        return "donHang/list";
    }
}
