package org.polaris.codehub.client.model.user;

public enum AccessLevelEnum {
    Guest(10), Reporter(20), Developer(30), Committer(35), Maintainer(40), Owner(50);

    private final int level;

    AccessLevelEnum(int level) {
        this.level = level;
    }

    public static AccessLevelEnum byOrdinal(int level) {
        for (AccessLevelEnum accessLevelEnum : AccessLevelEnum.values()) {
            if (accessLevelEnum.level == level) {
                return accessLevelEnum;
            }
        }
        return AccessLevelEnum.Guest;
    }
}
