package eti.mecka.franciszek.project.organization.initialize;

import eti.mecka.franciszek.project.organization.entity.Organization;
import eti.mecka.franciszek.project.organization.service.api.OrganizationService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final OrganizationService organizationService;

    @Autowired
    public InitializeData(
            OrganizationService organizationService
    ) {
        this.organizationService = organizationService;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Organization team1 = Organization.builder()
                .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                .dateOfEstablishment(LocalDate.of(1950, 2, 2))
                .name("Boston Celtics")
                .build();

        Organization team2 = Organization.builder()
                .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                .dateOfEstablishment(LocalDate.of(1940, 3, 3))
                .name("Los Angeles Lakers")
                .build();

        organizationService.create(team1);
        organizationService.create(team2);
    }
}
