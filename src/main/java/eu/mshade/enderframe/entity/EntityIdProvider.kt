package eu.mshade.enderframe.entity

import eu.mshade.mwork.MOptional
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicInteger

object EntityIdProvider {

    private val entitiesId: Queue<Int> = ConcurrentLinkedQueue()
    private val atomicId = AtomicInteger(1)

    fun getFreeId(): Int {
        return MOptional.ofNullable(entitiesId.poll())
            .ifPresent({ id: Int? -> id }, atomicId.incrementAndGet())
    }

    fun flushId(id: Int) {
        entitiesId.add(id)
    }
}