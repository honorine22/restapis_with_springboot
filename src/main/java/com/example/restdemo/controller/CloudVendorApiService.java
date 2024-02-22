package com.example.restdemo.controller;

import com.example.restdemo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorApiService {
    CloudVendor cloudVendor;
    private final List<CloudVendor> cloudVendorList = new ArrayList<>();

    @GetMapping("")
    public List<CloudVendor> getCloudVendors() {
            return cloudVendorList;
    }

    @GetMapping("/{vendorId}")
    public CloudVendor getCloudVendorById(@PathVariable String vendorId) {
        for (CloudVendor vendor : cloudVendorList){
            if(vendor.getVendorId().equals(vendorId)){
                return vendor;
            }
        }
        return null;
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        cloudVendorList.add(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping("/{vendorId}")
    public String updateCloudVendor(@PathVariable String vendorId, @RequestBody CloudVendor cloudVendor) {
        for (int i = 0; i < cloudVendorList.size(); i++){
            if(cloudVendorList.get(i).getVendorId().equals(vendorId)){
               cloudVendorList.set(i, cloudVendor);
                return "Cloud Vendor Updated Successfully";
            }
        }
        return "Vendor not found";
    }

    @DeleteMapping("/{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId) {
        if(vendorId!= null){
            for (int i = 0; i<cloudVendorList.size();i++){
                CloudVendor deletedVendor = cloudVendorList.get(i);
                if(deletedVendor.getVendorId().equals(vendorId)){
                    cloudVendorList.remove(deletedVendor);
                    return "Cloud Vendor Deleted Successfully";
                }
            }
        }
        return "Vendor not found";
    }
}
