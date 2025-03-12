package com.yong.PlabFootball.match;

import com.yong.PlabFootball.match.entiry.Match;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchRepository {
    Match insert(Match match);

    List<Match> findByStartDate(LocalDateTime date);

    void deleteById(Long matchId);
}
