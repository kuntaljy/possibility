package net.example;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ProbabilityTest {

    @Test
    public void should_get_right_two_independent_events_probability(){
        float anEventProbability = 0.3f;
        float anotherIndependentEventProbability = 0.2f;
        float twoEventProbability = 0.3f * 0.2f;

        Probability anEvent = new Probability(anEventProbability);
        Probability anotherIndependentEvent = new Probability(anotherIndependentEventProbability);
        Probability twoEvent = anEvent.and(anotherIndependentEvent);

        assertEquals(twoEventProbability, twoEvent.getProbability());
    }


    @Test
    public void should_get_right_two_mutual_exclusion_events_probability(){
        float anEventProbability = 0.3f;
        float anotherMutualExclusionEventProbability = 0.2f;
        float twoEventProbability = 0.5f;

        Probability anEvent = new Probability(anEventProbability);
        Probability anotherMutualExlusionEvent = new Probability(anotherMutualExclusionEventProbability);
        Probability towEvent = anEvent.or(anotherMutualExlusionEvent);

        assertEquals(twoEventProbability, towEvent.getProbability());
    }

    @Test
    public void should_get_right_opposite_probablity(){
        float anEventProbability = 0.3f;
        float theOppositeProbability = 0.7f;

        Probability anEvent = new Probability(anEventProbability);
        Probability theOppositeEvent = anEvent.opposite();

        assertEquals(theOppositeProbability, theOppositeEvent.getProbability());
    }
}
