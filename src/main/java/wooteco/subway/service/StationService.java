package wooteco.subway.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wooteco.subway.dao.StationDao;
import wooteco.subway.domain.Station;
import wooteco.subway.dto.StationRequest;
import wooteco.subway.dto.StationResponse;
import wooteco.subway.exception.duplicatename.StationDuplicateException;

@Service
public class StationService {

    private final StationDao stationDao;

    public StationService(final StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Transactional
    public StationResponse createStation(final StationRequest stationRequest) {
        validateDuplicateName(stationRequest.getName());
        Station station = new Station(stationRequest.getName());
        Station newStation = stationDao.save(station);
        return StationResponse.from(newStation);
    }

    private void validateDuplicateName(final String name) {
        if (stationDao.existByName(name)) {
            throw new StationDuplicateException("이미 등록된 지하철역 이름입니다.");
        }
    }

    public List<StationResponse> findAll() {
        return stationDao.findAll().stream()
                .map(StationResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public int deleteStation(final Long id) {
        Station station = stationDao.findById(id);
        return stationDao.deleteById(station.getId());
    }
}
