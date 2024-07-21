package com.treescrub.spedran.data;

/**
 * Timing type for runs.
 *
 * @see GameRuleset#getRunTimes()
 * @see GameRuleset#getDefaultTime()
 * @see Leaderboard#getTiming()
 */
@SuppressWarnings("unused")
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
    REALTIME_NOLOADS
}
