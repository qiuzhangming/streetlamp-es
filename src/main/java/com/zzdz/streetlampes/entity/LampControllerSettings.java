package com.zzdz.streetlampes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Document(indexName = "lamp_controller_settings")
//@Document(indexName = "street_lamp",type = "lamp_controller_settings")
public class LampControllerSettings implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String controllerId;
    private short cmdNo;
    private List<Integer> controllerList;//控制器地址
    private long systemTime;
    private long systemTimeTimestamp;

    private int[] ocTime;//开时 开分 关时 关分 4个字节
    private long ocTimeTimestamp;
    private int[] brightnessSet;//开始小时 开始分钟 结束小时 结束分钟 亮度值 共计4个时间段 20字节
    private long brightnessSetTimestamp;
    /**
     * 需要查询数据库
     */
    private String lampGatewayId;
    private String gatewayName;
    private String lamppostId;//灯杆id，方便前端遍历
    private String lamppostName;
    private String lamppostNumber;
    private String name;
    private String longitude;//经度
    private String latitude;//纬度

    //NB单灯增加
    private int systemUploadMsgTime;//系统上传数据时间
    private long systemUploadMsgTimeStamp;
    private LampControllerAlarmSettings controllerAlarmSettings;
}
