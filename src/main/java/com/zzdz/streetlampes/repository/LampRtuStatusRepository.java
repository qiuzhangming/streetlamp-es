package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampRtuStatus;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LampRtuStatusRepository extends ElasticsearchRepository<LampRtuStatus,String> {
}
