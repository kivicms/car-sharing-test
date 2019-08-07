package com.kivicms.test.api;


import com.kivicms.test.models.Vendor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vendors", path = "vendors")
public interface VendorsRepository extends PagingAndSortingRepository<Vendor, Long> {
}