package com.woowahan.kotlinhibernate

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CompanyTest {

    @Test
    fun `toStringTest`() {
        // given
        val company = Company(id = 1L, name = "heebongpany")

        // expect
        assertEquals(company.toString(), "Company(id=${company.id}, name=${company.name})")
    }

    @Test
    fun `equals - id값이 같으면 같은 객체로 인지 한다`() {
        // given
        val companyId = 1L

        val company1 = Company(id = companyId, name = "heebongpany1")
        val company2 = Company(id = companyId, name = "heebongpany2")

        // expect
        assertEquals(company1, company2)
    }
}
