package com.example.restdemo.service.impl;

import com.example.restdemo.model.CloudVendor;
import com.example.restdemo.repository.CloudVendorRepository;
import com.example.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CloudServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

   public CloudServiceImpl(CloudVendorRepository cloudVendorRepository){
       this.cloudVendorRepository = cloudVendorRepository;
   }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
       cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(String vendorId, CloudVendor cloudVendor) {
        Optional<CloudVendor> existingVendorOptional = cloudVendorRepository.findById(vendorId);

        if(existingVendorOptional.isPresent()){
            CloudVendor existingVendor = existingVendorOptional.get();
            existingVendor.setVendorId(cloudVendor.getVendorId());
            existingVendor.setVendorName(cloudVendor.getVendorName());
            existingVendor.setVendorAddress(cloudVendor.getVendorAddress());
            existingVendor.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
            cloudVendorRepository.save(existingVendor);
            return "Success";
        } else {
            return "Cloud Vendor with ID "+vendorId+" not found";
        }
    }

    @Override
    public String deleteCloudVendor(String vendorId) {
        if(cloudVendorRepository.findById(vendorId).isPresent()){
            cloudVendorRepository.deleteById(vendorId);
            return "Success";
        } else {
            return "Cloud Vendor with ID " + vendorId + " not found";
        }
    }

    @Override
    public CloudVendor viewCloudVendor(String vendorId) {
        Optional<CloudVendor> vendor =  cloudVendorRepository.findById(vendorId);
        return vendor.orElse(null);
    }

    @Override
    public ArrayList<CloudVendor> viewAllCloudVendors() {
      return (ArrayList<CloudVendor>) cloudVendorRepository.findAll();
    }
}
