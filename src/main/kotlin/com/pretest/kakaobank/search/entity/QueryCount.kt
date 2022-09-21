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
    //FIXME 시간 충분하면 sourceType도 넣어..근데 enum-converter 구현해야할거야..
) {
    @Column(name = "count")
    var count: Int = 0

    fun update() {
        this.count = this.count + 1
    }
}