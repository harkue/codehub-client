package org.polaris.codehub.client.model.software;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Software extends BaseSoftware {
    private String trainName;
    private String code;
    private String versionCode;
    private String productLine;
    private String productLineOwner;
    private String owner;
    private String codehubUrl;
    private String mainBranch;
    private String versionTag;
    private String versionCommitId;
    private String codehubRepoName;
    private String reviewer;
    private String status;
}
