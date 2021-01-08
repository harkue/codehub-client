package org.polaris.codehub.client.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Group {
    private String id;
    private String name;
    @JSONField(name = "web_url")
    private String webUrl;
    private Integer members;
    @JSONField(name = "project_count")
    private Integer projectCount;
    @JSONField(name = "sub_group_count")
    private Integer subGroupCount;
}
