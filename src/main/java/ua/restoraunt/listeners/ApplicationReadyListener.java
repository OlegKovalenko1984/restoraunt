package ua.restoraunt.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ua.restoraunt.domain.Menu;
import ua.restoraunt.domain.Restoraunt;
import ua.restoraunt.repositories.Repository;

import java.util.List;

@Slf4j
@Component
public class ApplicationReadyListener {

    private final Repository<Restoraunt> restorauntRepository;
    private final Repository<Menu> menuRepository;

    public ApplicationReadyListener(@Qualifier("restorauntImpl") Repository restorauntRepository,
                                    @Qualifier("menuImpl") Repository<Menu> menuRepository) {
        this.restorauntRepository = restorauntRepository;
        this.menuRepository = menuRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void readyHandler() {
        Restoraunt restoraunt = restorauntRepository.get(1);
        Menu menu = menuRepository.get(3);
        List<Restoraunt> restorauntList = restorauntRepository.getAll();
        List<Menu> menuList = menuRepository.getAll();

        restorauntRepository.create(new Restoraunt(
                "Просто бар",
                true,
                "http://prostobar.com",
                3,
                true,
                false,
                "10.00-24.00"));

        restorauntRepository.update(new Restoraunt(14,
                "бар Фазан",
                true,
                "http://prostobar.com",
                3,
                true,
                false,
                "10.00-24.00"));

        restorauntRepository.delete(14);

        log.info("Info - {}", restoraunt);
        log.info("All Info - {}", restorauntList);


        menuRepository.update(new Menu(3, 1, "Сало", 150.0, 1.0, 10.0));
        menuRepository.create(new Menu(14, "Вискарик", 350.2, 0.5, 1.0));
        menuRepository.delete(3);

        log.info("Menu -> {}", menu);
        log.info("AllMenu -> {}", menuList);


    }
}
