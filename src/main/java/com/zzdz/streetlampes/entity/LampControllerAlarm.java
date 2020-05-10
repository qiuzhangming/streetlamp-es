package com.zzdz.streetlampes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(indexName = "lamp_controller_alarm")
//@Document(indexName = "street_lamp",type = "lamp_controller_alarm")
public class LampControllerAlarm implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String controllerId;
    private boolean connectFailed;//通讯故障
    private boolean beStolen;//防盗报警
    private boolean voltageAbnormal;//电压测量故障
    private boolean moduleBroken;//模组损坏
    private boolean relayBroken;//继电器损坏
    private boolean electricLeakage;//漏电

    private long alarmTimestamp;
    private long dataPersistenceTimestamp;//记录最后一次数据存盘的时间
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
    //NB增加属性
    private boolean overCurrent;//过流
    private boolean underCurrent;//欠流
    private boolean overVoltage;//过压
    private boolean underVoltage;//欠压
    private boolean controlBroken;//控制损坏报警
    private boolean detectBroken;//检测损坏报警
}
