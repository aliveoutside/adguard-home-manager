package ru.toxyxd.adguardhome.domain.model

data class Server(
    val name: String,
    val host: String,
    val port: Int,
    val username: String,
    val password: String
)
