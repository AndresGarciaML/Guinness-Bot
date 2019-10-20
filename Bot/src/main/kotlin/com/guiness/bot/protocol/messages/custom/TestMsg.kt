package com.guiness.bot.protocol.messages.custom

import com.guiness.bot.protocol.annotations.Message
import com.guiness.bot.protocol.annotations.Delimiter
import com.guiness.bot.protocol.annotations.StreamSource

@Delimiter(":")
data class Item(
    val id: Int,
    val quantity: Int
)

@Delimiter(",")
data class GuildMember(
    val name: String,
    @Delimiter(".")
    val items: Array<Item>
)

@Message(header = "TEST", source = StreamSource.ANYSTREAM, delimiter = """|""")
data class TestMsg(
    val ip: String,
    val port: Int,
    val item: Item,
    @Delimiter("-")
    val intArray: Array<Int>,
    @Delimiter(";")
    val members: Array<GuildMember>
)