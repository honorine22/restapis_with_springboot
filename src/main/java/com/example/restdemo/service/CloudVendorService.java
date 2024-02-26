package com.example.restdemo.service;

import com.example.restdemo.model.CloudVendor;

import java.util.ArrayList;
public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(String vendorId, CloudVendor cloudVendor);
    public String deleteCloudVendor(String vendorId);

    public CloudVendor viewCloudVendor(String vendorId);

    public ArrayList<CloudVendor> viewAllCloudVendors();
}
