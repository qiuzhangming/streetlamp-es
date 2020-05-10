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
@Document(indexName = "lamp_gateway_settings")
//@Document(indexName = "street_lamp",type = "lamp_gateway_settings")
public class LampGatewaySettings implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String mcuId;
    private String gatewayId;
    private List<Integer> controllerList;//控制器地址
    private List<Integer> usedControllerList;//启用站点控制器地址
    private List<Integer> stolenControllerList;//防盗设置控制器地址
    private short cmdNo;
    private long cmdReturnTimestamp;
    private long systemTime;
    private long systemTimeTimestamp;
    private boolean alarmSwitch;//报警开关
    private long alarmInterval;//报警间隔
    private long alarmSetTimestamp;
    private boolean postSwitch;//主动上传开关
    private long postInterval;//上传间隔
    private long postSetTimestamp;
    private long scanInterval;//单灯之间扫描时间间隔
    private long scanWaitInterval;//扫描完一圈后的等待时间
    private long scanSetTimestamp;
    int[] scanTime;//开始时、分、结束时、分
    long scanTimeSetTimestamp;
    private boolean controllerUsed;//地址启用标志
    private long usedControllerTimestamp;
    private boolean stolenSwitch;//防盗报警启用状态
    private long stolenSetTimestamp;

    private boolean forceOC;//强制开关
    private double brightness;//亮度
    int[] ocTime;//开时 开分 关时 关分 4个字节
    private int[] brightnessSet;//开始小时 开始分钟 结束小时 结束分钟 亮度值 共计4个时间段 20字节

    private String name;
    private String rtuName;
}
