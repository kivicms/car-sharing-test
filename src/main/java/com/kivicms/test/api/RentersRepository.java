package com.kivicms.test.api;

import com.kivicms.test.models.Renter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "renters", path = "renters")
public interface RentersRepository extends PagingAndSortingRepository<Renter, Long> {
}