package com.woowahan.kotlinhibernate

import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull


@DataJpaTest
internal class CompanyEmployeeTest @Autowired constructor(
        val companyJpaRepository: CompanyJpaRepository,
        val employeeJpaRepository: EmployeeJpaRepository
) {

    @Test
    internal fun findById() {
        val employee = employeeJpaRepository.findByIdOrNull(1L)
        log.info("1")
        assertEquals(employee!!.id, 1L)
        log.info("2")
        assertEquals(employee.name, "희봉")
        log.info("3")
        val company = employee.company
        assertEquals(company!!.name, "heebong-pany")
        log.info("4")

        log.info("employee : $employee")
        log.info("company : $company")

    }


    @Test
    internal fun findByIdCompany() {
        val company = companyJpaRepository.findByIdOrNull(1L)

        assert(company!!.id == 1L)
        assert(company.name == "heebong-pany")
    }

    @Test
    internal fun save() {
        var company = Company(name = "company1")

        company = companyJpaRepository.save(company)

        assert(company.id != null)
        println("${company.id}")
    }

    companion object {
        private val log = LoggerFactory.getLogger(CompanyEmployeeTest::class.toString())
    }
}
