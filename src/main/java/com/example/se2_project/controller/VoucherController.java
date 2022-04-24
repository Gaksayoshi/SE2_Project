package com.example.se2_project.controller;

import com.example.se2_project.model.Voucher;
import com.example.se2_project.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class VoucherController {
    @Autowired
    VoucherRepository voucherRepository;

    @PostMapping(value = "/voucher")
    public Voucher addVoucher(@RequestBody Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @PutMapping(value = "/voucher/{id}")
    public void updateVoucher(
            @PathVariable(value = "id") Long id,
            @RequestBody Voucher voucher
    ) {
        if(voucherRepository.existsById(id)) {
            voucher.setId(id);
            voucherRepository.save(voucher);
        }
    }

    @DeleteMapping(value = "/voucher/{id}")
    public void deleteVoucher(
            @PathVariable(value = "id") Long id
    ) {
        if(voucherRepository.existsById(id)) {
            Voucher voucherToDelete = voucherRepository.getById(id);
            voucherRepository.delete(voucherToDelete);
        }
    }
}
