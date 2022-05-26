package wooteco.subway.domain.section;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooteco.subway.domain.Station;
import wooteco.subway.domain.secion.Section;
import wooteco.subway.exception.PositiveDigitException;

class SectionTest {

    @DisplayName("거리가 양수가 아닌 경우 예외를 발생시킨다.")
    @Test
    void NotPositiveExtraFareException() {
        assertThatThrownBy(() -> new Section(1L, new Station("강남역"), new Station("서초역"), 0))
                .isInstanceOf(PositiveDigitException.class)
                .hasMessage("구간의 길이는 양수여야 합니다.");
    }

}
