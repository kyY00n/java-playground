package vo;

import java.util.Objects;

public class Score {
    private int value;

    public Score(int value) {
        this.value = value;
    }

    public Score minus(int decr) {
        return new Score(value - decr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
