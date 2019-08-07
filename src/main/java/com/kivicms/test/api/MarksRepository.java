package com.kivicms.test.api;

import com.kivicms.test.models.Mark;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "marks", path = "marks")
public interface MarksRepository extends PagingAndSortingRepository<Mark, Long> {
}