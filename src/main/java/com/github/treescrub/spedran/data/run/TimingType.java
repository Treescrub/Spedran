package com.github.treescrub.spedran.data.run;

/**
 * Timing type for runs.
 *
 * @see com.github.treescrub.spedran.data.game.GameRuleset#getRunTimes()
 * @see com.github.treescrub.spedran.data.game.GameRuleset#getDefaultTime()
 * @see com.github.treescrub.spedran.data.leaderboard.Leaderboard#getTiming()
 */
public enum TimingType {
    /**
     * The timing type that the leaderboard is sorted by.
     */
    PRIMARY,
    /**
     * The time that the game measures and reports itself.
     */
    INGAME,
    /**
     * The real world time as determined by a clock.
     */
    REALTIME,
    /**
     * The real world time but loads are removed from the total time.
     */
    REALTIME_NOLOADS;
}
