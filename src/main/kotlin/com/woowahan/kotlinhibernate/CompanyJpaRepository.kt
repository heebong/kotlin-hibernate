package com.woowahan.kotlinhibernate

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyJpaRepository : JpaRepository<Company, Long> {
}