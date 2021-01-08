package org.polaris.codehub.client.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Project {
    private String id;
    private String name;
    private String description;
    private String path;
    @JSONField(name = "path_with_namespace")
    private String pathWithNamespace;
    @JSONField(name = "web_url")
    private String webUrl;
    private String archived;
    @JSONField(name = "created_at")
    private String createAt;
}
