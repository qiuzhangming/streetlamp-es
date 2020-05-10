package com.zzdz.streetlampes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Document(indexName = "lamp_rtu_settings")
//@Document(indexName = "street_lamp",type = "lamp_rtu_settings")
public class LampRtuSettings implements Serializable {
    @JsonSetter("id")
    private String uuid;

    @Id
    @JsonIgnore
    private String id;

    //private ModemInfo modemInfo;
    private String rtuId;
    private short cmdNo;
    private long cmdReturnTimestamp;
    private long rtuSysTime;//站点系统时钟
    private long rtuSysTimestamp;
    private String longitude;//经纬度
    private String latitude;
    private long lngLatTimestamp;
    private int[] ocTime;//开关灯时间 (oh om 1-8) (ch cm 1-8)
    private long ocTimeTimestamp;
    private boolean[] autoOCRoad;//是否启用晨昏线开关灯 openk1-k8 closek1-k8
    private long autoOCTimestamp;
    private int[] fixOCValue;// 晨昏线开关灯修正值 openk1-k8 closek1-k8
    private long fixOCTimestamp;
    private boolean activeAlarmSwitch;
    private boolean phaseAlarmA;
    private boolean phaseAlarmB;
    private boolean phaseAlarmC;
    private boolean openDoorAlarm;
    private boolean cableBrokenAlarm;//断线报警
    private boolean heartbeat;//心跳
    private long heartbeatInterval;//心跳间隔
    private long alarmInterval;//报警时间间隔
    private boolean[] forceOCRoad;//8路强制开关
    private boolean forceFlag;
    private List<int[]> kCRelationlist;//组态 记录k1-k8分别对应的交流接触器编号。例如k1->1,2 k2->3,4,5
    private List<int[]> kBRelationlist;//断路报警 记录k1-k8分别对应的支路编号。例如k1->1,2,3,4,5 k2->6,7,8
    private List<int[]> weekConList;//周控 记录星期1-7 k1-k8是否启用。例如 星期一 -> k1,k2,k2启用
    private String secondGroupName;//二级分组名字
    private String name;
    private String boxNumber;//箱体编号
}
