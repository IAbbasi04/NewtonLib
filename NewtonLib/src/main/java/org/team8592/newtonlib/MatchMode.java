package org.team8592.newtonlib;

public enum MatchMode {
    DISABLED,
    TELEOP,
    AUTONOMOUS,
    TEST;

    public boolean is(MatchMode mode) {
        return this.equals(mode);
    }

    public boolean isAny(MatchMode ... modes) {
        for (MatchMode mode : modes) {
            if (this.equals(mode)) return true;
        }
        return false;
    }
}
