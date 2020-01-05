package app.datacollect.lastread;

import app.datacollect.lastread.repository.LastReadRepository;
import app.datacollect.lastread.service.LastReadService;
import org.springframework.context.annotation.Import;

@Import({LastReadService.class, LastReadRepository.class})
public @interface EnableLastRead {}
