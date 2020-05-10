package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.AccessLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccessLogRepository extends ElasticsearchRepository<AccessLog, String> {
}
