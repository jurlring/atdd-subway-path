package wooteco.subway.dto;

import java.util.List;
import java.util.stream.Collectors;
import wooteco.subway.domain.Station;
import wooteco.subway.domain.path.Path;

public class PathResponse {

    private final List<StationResponse> stations;
    private final double distance;
    private final int fare;


    private PathResponse(List<Station> stations, double distance, int fare) {
        this.stations = convertToStationResponses(stations);
        this.distance = distance;
        this.fare = fare;
    }

    public static PathResponse of(Path path, int fare) {
        return new PathResponse(path.getStations(), path.getDistance(), fare);
    }

    private static List<StationResponse> convertToStationResponses(final List<Station> stations) {
        return stations.stream()
                .map(StationResponse::from)
                .collect(Collectors.toList());
    }

    public List<StationResponse> getStations() {
        return stations;
    }

    public double getDistance() {
        return distance;
    }

    public int getFare() {
        return fare;
    }
}
