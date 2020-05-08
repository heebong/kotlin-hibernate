package com.woowahan.kotlinhibernate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
internal class CompanyEmployeeRepositoryTest @Autowired constructor(
    val companyJpaRepository: CompanyJpaRepository,
    val employeeJpaRepository: EmployeeJpaRepository
) {

    @Test
    internal fun findById() {
        // when
        val employee = employeeJpaRepository.findByIdOrNull(1L)

        // then
        assertEquals(employee!!.id, 1L)     // break point
        assertEquals(employee.name, "고길동")
    }

    @Test
    internal fun `findById - lazy loading`() {
        // when
        val employee = employeeJpaRepository.findByIdOrNull(1L)

        // then
        log.info("employee 데이터를 조회한 이후")
        assertEquals(employee!!.id, 1L)
        assertEquals(employee.name, "고길동")

        log.info("company 데이터에 접근하기 전")
        assertEquals(employee.company!!.name, "a-company")

        log.info("company 데이터에 접근한 후")
    }

    @Test
    internal fun findAllById() {
        // given
        val employeeIds = listOf(1L, 2L, 3L, 4L)

        // when
        val employees = employeeJpaRepository.findAllById(employeeIds)

        // then
        log.info("result: $employees")
    }

    @Test
    internal fun findByIdCompany() {
        val company = companyJpaRepository.findByIdOrNull(1L)

        assert(company!!.id == 1L)
        assert(company.name == "a-company")
    }

    @Test
    internal fun save() {
        var company = Company(name = "company1")

        company = companyJpaRepository.save(company)

        assert(company.id != null)
        println("${company.id}")
    }

    companion object {
        private val log = LoggerFactory.getLogger(CompanyEmployeeRepositoryTest::class.toString())
    }
}
