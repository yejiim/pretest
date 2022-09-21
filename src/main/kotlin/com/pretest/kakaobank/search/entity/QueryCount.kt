package com.pretest.kakaobank.search.entity

import javax.persistence.*

@Entity
@Table(name = "query_count")
data class QueryCount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @Column(name = "query")
    val query: String
) {
    @Column(name = "count")
    var count: Int = 0

    fun update() {
        this.count = this.count + 1
    }
}