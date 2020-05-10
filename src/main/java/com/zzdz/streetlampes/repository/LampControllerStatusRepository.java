package com.zzdz.streetlampes.repository;

import com.zzdz.streetlampes.entity.LampControllerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

public interface LampControllerStatusRepository extends ElasticsearchRepository<LampControllerStatus,String> {

    Page<LampControllerStatus> findByStatusTimestampBetween(@Param("startTime") long startTime,
                                                            @Param("stopTime") long stopTime,
                                                            Pageable pageable);

    Page<LampControllerStatus> findByControllerIdLikeAndStatusTimestampBetween(@Param("projectCode") String projectCode,
                                                                               @Param("startTime") long startTime,
                                                                               @Param("stopTime") long stopTime,
                                                                               Pageable pageable);
}
