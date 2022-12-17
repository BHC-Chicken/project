package dev.ioexception.project.pharmacy.repository

import dev.ioexception.project.AbstractIntegrationContainerBaseTest
import dev.ioexception.project.pharmacy.entity.Pharmacy
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.testcontainers.spock.Testcontainers

@Slf4j
@Testcontainers
class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    def "PharmacyRepository save"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }
}
