package net.example;

public class Probability {

    private static final int MIN_PROBABILITY = 0;
    private static final int MAX_PROBABILITY = 1;

    private float probability;

    public float getProbability() {
        return this.probability;
    }

    public Probability(float probabilityValue) {
        if (isValideProabibityValue(probabilityValue)) {
            this.probability = probabilityValue;
        } else {
            throw new IllegalArgumentException("Probability Value must between 0 and 1");
        }
    }

    public Probability and(Probability probability) {
        return new Probability(this.probability * probability.probability);
    }

    public Probability or(Probability probability) {
        return new Probability(this.probability + probability.probability);
    }

    public Probability opposite() {
        return new Probability(MAX_PROBABILITY - this.probability);
    }

    private boolean isValideProabibityValue(float value) {
        return value >= MIN_PROBABILITY && value <= MAX_PROBABILITY;
    }
}
