package app.datacollect.lastread.service;

import app.datacollect.lastread.repository.LastReadRepository;
import app.datacollect.time.UTCDateTime;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LastReadService {

  private static final Logger logger = LoggerFactory.getLogger(LastReadService.class);

  private final LastReadRepository repository;

  public LastReadService(LastReadRepository repository) {
    this.repository = repository;
  }

  public void saveLastReadId(String name, String id) {
    logger.debug("Saving last read id '{}' for name '{}'", id, name);
    repository.saveLastReadId(name, id, UTCDateTime.now());
    logger.info("Saved last read id '{}' for name '{}'", id, name);
  }

  public void updateLastReadId(String name, String id) {
    logger.debug("Updating last read id '{}' for name '{}'", id, name);
    repository.updateLastReadId(name, UTCDateTime.now(), id);
    logger.info("Updated last read id '{}' for name '{}'", id, name);
  }

  public Optional<String> getLastReadId(String name) {
    return repository.getLastReadId(name);
  }
}
