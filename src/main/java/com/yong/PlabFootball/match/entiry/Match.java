package com.yong.PlabFootball.match.entiry;

import com.yong.PlabFootball.stadium.entity.Field;

import java.time.LocalDateTime;

public class Match {
    private long matchId;
    private final LocalDateTime matchStartDateTime;
    private final LocalDateTime matchEndDateTime;
    private final Field field;

    public Match(LocalDateTime matchStartDateTime, LocalDateTime matchEndDateTime, Field field) {
        this.matchStartDateTime = matchStartDateTime;
        this.matchEndDateTime = matchEndDateTime;
        this.field = field;
    }

    public long getMatchId() {
        return matchId;
    }

    public LocalDateTime getMatchStartDateTime() {
        return matchStartDateTime;
    }

    public LocalDateTime getMatchEndDateTime() {
        return matchEndDateTime;
    }

    public Field getField() {
        return field;
    }
}
