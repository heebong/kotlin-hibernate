package com.woowahan.kotlinhibernate

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class EmployeeTest {

    @Test
    fun `toString - 연관되어있는 객체는 노출되지 않는다`() {
        // given
        val company = Company(name = "company")

        val employee = Employee(id = 10L, name = "emp", company = company)

        // expect
        assertEquals(employee.toString(), "Employee(id=${employee.id}, name=${employee.name})")
    }

    @Test
    fun `equals - id값이 같으면 같은 객체로 인지 한다`() {
        // given
        val employeeId = 1L

        val employee1 = Employee(employeeId, "emp1", null)
        val employee2 = Employee(employeeId, "emp2", null)

        // expect
        assertEquals(employee1, employee2)
    }

    @Test
    fun `getCompanyName - mock 테스트`() {
        // given
        val companyName = "heebongpany"
        val mockCompany = mock<Company> {
            on { name } doReturn companyName
        }

        // when
        val employee = Employee(name = "heebong", company = mockCompany)

        // expect
        assertEquals(employee.getCompanyName(), companyName)
        verify(mockCompany).name
    }
}
