package com.guiness.bot.controllers

import com.guiness.bot.core.BotManager
import com.guiness.bot.netwotk.Proxy
import com.guiness.bot.netwotk.ProxyClientContext
import com.guiness.bot.netwotk.ProxyClientState
import com.guiness.bot.netwotk.shared.HandlerPriority
import com.guiness.bot.netwotk.shared.PipelineOperation
import com.guiness.bot.netwotk.shared.StreamOperation
import com.guiness.bot.netwotk.shared.annotations.Controller
import com.guiness.bot.netwotk.shared.annotations.FromDownstream
import com.guiness.bot.protocol.messages.custom.AuthServerInfoMessage
import com.guiness.bot.protocol.messages.custom.GameServerInfoMessage
import com.guiness.bot.protocol.messages.custom.GameTicketMessage

@Controller
class NativeController {

    @FromDownstream(then = StreamOperation.DISCARD, priority = HandlerPriority.HIGHTEST, pipeline = PipelineOperation.BREAK)
    fun onLoginConnection(ctx: ProxyClientContext, msg: AuthServerInfoMessage) {
        Proxy.connectToUpstream(ctx, msg.ip, msg.port)
    }

    @FromDownstream(then = StreamOperation.DISCARD, priority = HandlerPriority.HIGHTEST, pipeline = PipelineOperation.BREAK)
    fun onGameConnection(ctx: ProxyClientContext, msg: GameServerInfoMessage) {
        Proxy.connectToUpstream(ctx, msg.ip, msg.port)
        ctx.state = ProxyClientState.CHARACTER_LIST
        BotManager.linkBotAndContext(ctx, ticket = msg.ticket)
    }

    @FromDownstream(then = StreamOperation.DISCARD, priority = HandlerPriority.HIGHTEST, pipeline = PipelineOperation.BREAK)
    fun onGameTicket(ctx: ProxyClientContext, msg: GameTicketMessage) {
        ctx.botMightBeNull()?.ticket = msg.ticket /* manual logging with unknown account */
    }
}