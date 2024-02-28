package com.example.restdemo.controller;

import com.example.restdemo.model.CloudVendor;
import com.example.restdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorById(@PathVariable("vendorId") String vendorId) {
       return cloudVendorService.viewCloudVendor(vendorId);
    }

    @GetMapping("")
    public List<CloudVendor> getCloudVendors() {
        return cloudVendorService.viewAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
       return cloudVendorService.createCloudVendor(cloudVendor);
    }

    @PutMapping("/{vendorId}")
    public String updateCloudVendor(@PathVariable String vendorId, @RequestBody CloudVendor cloudVendor) {
      return  cloudVendorService.updateCloudVendor(vendorId, cloudVendor);
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId) {
       return cloudVendorService.deleteCloudVendor(vendorId);
    }
}
