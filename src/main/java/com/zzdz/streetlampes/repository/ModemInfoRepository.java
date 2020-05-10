package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.ModemInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ModemInfoRepository extends ElasticsearchRepository<ModemInfo,String> {
}
