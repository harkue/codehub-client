package org.polaris.codehub.client.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class BaseUser {
    @JSONField(name = "user_name")
    private String userName;

    @JSONField(name = "access_level")
    private AccessLevelEnum accessLevel;
}
