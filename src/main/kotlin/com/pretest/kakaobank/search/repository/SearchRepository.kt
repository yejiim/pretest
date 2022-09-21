package com.pretest.kakaobank.search.repository

import com.pretest.kakaobank.search.entity.QueryCount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchRepository : JpaRepository<QueryCount, Int>, SearchRepositoryCustom {
    fun findByQuery(query: String): QueryCount?
}