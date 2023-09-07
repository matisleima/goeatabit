package ee.valiit.goeatabit.util;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DELETED("D"),
    MODIFIED("M");

    private final String letter;

    Status(String letter) {
        this.letter = letter;
    }
}
