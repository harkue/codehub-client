package org.polaris.codehub.client.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseUser {
    private int id;
    private String state;
    @JSONField(name = "avatar_url")
    private String avatarUrl;
    private List<String> message;
}
