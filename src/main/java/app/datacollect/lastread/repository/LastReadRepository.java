package app.datacollect.lastread.repository;

import app.datacollect.time.UTCDateTime;
import java.util.Map;
import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LastReadRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public LastReadRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void saveLastReadId(String name, String id, UTCDateTime time) {
    jdbcTemplate.update(
        "INSERT INTO last_read (name, id, updated_time) VALUES (:name, :id, :updated_time)",
        Map.of("name", name, "id", id, "updated_time", time.iso8601()));
  }

  public void updateLastReadId(String name, UTCDateTime time, String id) {
    jdbcTemplate.update(
        "UPDATE last_read SET id = :id, updated_time = :updated_time WHERE name = :name",
        Map.of("id", id, "updated_time", time.iso8601(), "name", name));
  }

  public Optional<String> getLastReadId(String name) {
    try {
      return Optional.ofNullable(
          jdbcTemplate.queryForObject(
              "SELECT id FROM last_read WHERE name = :name", Map.of("name", name), String.class));
    } catch (EmptyResultDataAccessException ex) {
      return Optional.empty();
    }
  }
}
