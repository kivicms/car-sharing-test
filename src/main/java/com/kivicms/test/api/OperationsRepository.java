package com.kivicms.test.api;

import com.kivicms.test.models.Operation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "operations", path = "operations")
public interface OperationsRepository extends PagingAndSortingRepository<Operation, Long> {
}