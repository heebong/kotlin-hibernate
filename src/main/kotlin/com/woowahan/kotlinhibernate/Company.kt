package com.woowahan.kotlinhibernate

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Company(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        var name: String
) {
        override fun toString() = kotlinToString(properties = toStringProperties)

        override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

        override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)


        companion object {
                private val equalsAndHashCodeProperties = arrayOf(Company::id)
                private val toStringProperties = arrayOf(
                        Company::id,
                        Company::name
                )
        }
}