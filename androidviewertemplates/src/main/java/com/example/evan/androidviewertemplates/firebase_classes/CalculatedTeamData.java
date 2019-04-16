package com.example.evan.androidviewertemplates.firebase_classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Katherine on 1/12/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatedTeamData extends Object {
    //make sure that all variables are public
    public Integer predictedSeed;
    public Integer lemonLoadSuccess;
    public Integer orangeSuccessAll;
    public Integer orangeSuccessDefended;
    public Integer orangeSuccessUndefended;
    public Integer orangeSuccessL1;
    public Integer orangeSuccessL2;
    public Integer orangeSuccessL3;
    public Integer lemonSuccessAll;
    public Integer lemonSuccessDefended;
    public Integer lemonSuccessUndefended;
    public Integer lemonSuccessL1;
    public Integer lemonSuccessL2;
    public Integer lemonSuccessL3;
    public Integer lemonSuccessFromSide;
    public Integer habLineSuccessL1;
    public Integer habLineSuccessL2;
    public Integer percentIncap;
    public Integer percentNoShow;
    public Integer lfmLemonLoadSuccess;
    public Integer lfmOrangeSuccessAll;
    public Integer lfmOrangeSuccessDefended;
    public Integer lfmOrangeSuccessUndefended;
    public Integer lfmOrangeSuccessL1;
    public Integer lfmOrangeSuccessL2;
    public Integer lfmOrangeSuccessL3;
    public Integer lfmLemonSuccessAll;
    public Integer lfmLemonSuccessDefended;
    public Integer lfmLemonSuccessUndefended;
    public Integer lfmLemonSuccessL1;
    public Integer lfmLemonSuccessL2;
    public Integer lfmLemonSuccessL3;
    public Integer lfmLemonSuccessFromSide;
    public Integer lfmHabLineSuccessL1;
    public Integer lfmHabLineSuccessL2;
    public Integer lfmPercentIncap;
    public Integer lfmPercentNoShow;
    public Integer sdLemonLoadSuccess;
    public Integer sdOrangeSuccessAll;
    public Integer sdOrangeSuccessDefended;
    public Integer sdOrangeSuccessUndefended;
    public Integer sdOrangeSuccessL1;
    public Integer sdOrangeSuccessL2;
    public Integer sdOrnageSuccessL3;
    public Integer sdLemonSuccessAll;
    public Integer sdLemonSuccessDefended;
    public Integer sdLemonSuccessUndefended;
    public Integer sdLemonSuccessL1;
    public Integer sdLemonSuccessL2;
    public Integer sdLemonSuccessL3;
    public Integer sdLemonSuccessFromSide;
    public Integer sdHabLineSuccessL1;
    public Integer sdHabLineSuccessL2;
    public Integer sdPercentIncap;
    public Integer sdPercentNoShow;
    public Integer p75lemonLoadSuccess;
    public Integer p75orangeSuccessAll;
    public Integer p75orangeSuccessDefended;
    public Integer p75orangeSuccessUndefended;
    public Integer p75orangeSuccessL1;
    public Integer p75orangeSuccessL2;
    public Integer p75orangeSuccessL3;
    public Integer p75lemonSuccessAll;
    public Integer p75lemonSuccessDefended;
    public Integer p75lemonSuccessUndefended;
    public Integer p75lemonSuccessL1;
    public Integer p75lemonSuccessL2;
    public Integer p75lemonSuccessL3;
    public Integer p75lemonSuccesssFromSide;
    public Integer p75habLineSuccessL1;
    public Integer p75habLine;
    public Integer p75percentIncapEntireMatch;
    public Integer sdPercentIncapEntireMatch;
    public Integer lfmPercentIncapEntireMatch;
    public Integer climbSuccessL1;
    public Integer climbSuccessL2;
    public Integer climbSuccessL3;
    public Integer orangesScoredL1;
    public Integer percentDysfunctional;
    public Integer failedCyclesCaused;
    public Integer lastMatch;
    public Integer matchesDefended;
    public Integer actualSeed;
    public Integer actualRPs;

    public Float agilityZScore;
    public Float predictedRPs;
    public Float avgOrangesScored;
    public Float avgLemonsScored;
    public Float avgOrangesFouls;
    public Float orangeCycleAll;
    public Float orangeCycleL1;
    public Float orangeCycleL2;
    public Float orangeCycleL3;
    public Float lemonCycleAll;
    public Float lemonCycleL1;
    public Float lemonCycleL2;
    public Float lemonCycleL3;
    public Float avgTimeIncap;
    public Float avgTimeClimbing;
    public Float predictedDedicatedLemonCycles;
    public Float predictedDedicatedOrangeCycles;
    public Float predictedSoloPoints;
    public Float lemonAbility;
    public Float orangeAbility;
    public Float firstPickAbility;
    public Float thirdPickAbility;
    public Float secondPickAbility;
    public Float avgPinningFouls;
    public Float lfmAvgOrangesScored;
    public Float lfmAvgLemonsScored;
    public Float lfmAvgOrangesFouls;
    public Float lfmOrangeCycleAll;
    public Float lfmOrangeCycleL1;
    public Float lfmOrangeCycleL2;
    public Float lfmOrangeCycleL3;
    public Float lfmLemonCycleAll;
    public Float lfmLemonCycleL1;
    public Float lfmLemonCycleL2;
    public Float lfmLemonCycleL3;
    public Float lfmAvgTimeIncap;
    public Float lfmAvgTimeClimbing;
    public Float lfmAvgPinningFouls;
    public Float sdAvgOrangesScored;
    public Float sdAvgLemonsScored;
    public Float sdAvgOrangesFouls;
    public Float sdOrangeCycleAll;
    public Float sdOrangeCycleL1;
    public Float sdOrangeCycleL2;
    public Float sdOrangeCycleL3;
    public Float sdLemonCycleAll;
    public Float sdLemonCycleL1;
    public Float sdLemonCycleL2;
    public Float sdLemonCycleL3;
    public Float sdAvgTimeIncap;
    public Float sdAvgTimeClimbing;
    public Float sdAvgPinningFouls;
    public Float p75avgOrangesScored;
    public Float p75avgLemonsScored;
    public Float p75avgOrangesFouls;
    public Float p75oranceCycleAll;
    public Float p75orangeCycleL1;
    public Float p75orangeCycleL2;
    public Float p75orangeCycleL3;
    public Float p75lemonCycleAll;
    public Float p75lemonCycleL1;
    public Float p75lemonCycleL2;
    public Float p75lemonCycleL3;
    public Float p75avgTimeIncap;
    public Float p75avgTimeClimbing;
    public Float p75AvgPinningFouls;
    public Float speedZScore;
    public Float avgLemonsScoredSandstorm;
    public Float avgOrangesScoredSandstorm;
    public Float driverAbility;
    public Float avgFailedCyclesCaused;
    public Float avgRankDefense;
    public Float avgOrangePointsPrevented;
    public Float avgLemonPointsPrevented;
    public Float avgCounterDefense;
    public Float totalTimeDefending;
    public Float avgTimeDefending;
    public Float failedCyclesCausedPerSecond;
    public Float avgPointsPrevented;

    public Boolean hasOrangeGroundIntake;
    public Boolean hasLemonGroundIntake;
    public Boolean didPreloadOrange;
    public Boolean didPreloadLemon;

    public List<String> notes;

    public String climbAttemptsL1;
    public String climbAttemptsL2;
    public String climbAttemptsL3;
    public String habLineAttemptsL1;
    public String habLineAttemptsL2;
}
