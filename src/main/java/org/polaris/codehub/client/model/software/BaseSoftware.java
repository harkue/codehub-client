package org.polaris.codehub.client.model.software;

import lombok.Data;

@Data
public class BaseSoftware {
    private String name;
    private String version;
    private String homepage;
    private String language;
    private String srcUrl;
    private String binUrl;
    private String repoUrl;
    private String repoName;
    private String comment;
}
