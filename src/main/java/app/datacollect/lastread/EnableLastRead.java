package app.datacollect.lastread;

import app.datacollect.lastread.repository.LastReadRepository;
import app.datacollect.lastread.service.LastReadService;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({LastReadService.class, LastReadRepository.class})
public @interface EnableLastRead {}
