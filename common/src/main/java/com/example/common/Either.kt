package com.example.common


import kotlinx.coroutines.CancellationException
import com.example.common.Either.Right
import com.example.common.Either.Left
/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 *
 * @see Left
 * @see Right
 */
sealed class Either<out L, out R> {

    /** * Represents the left side of [Either] class which by convention is a "Failure". */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /** * Represents the right side of [Either] class which by convention is a "Success". */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)
    fun <R> right(b: R) = Right(b)

    fun fold(fnR: (R) -> Any, fnL: (L) -> Any): Any = when (this) {
        is Left -> fnL(a)
        is Right -> fnR(b)
    }
}

inline fun <T, R> T.runCatching(block: T.() -> R): Either<Exception, R> {
    return try {
        Right(block())
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        Left(e)
    }
}

fun <R> Either<Exception, R>.getOrThrow(): R = when (this) {
    is Left -> throw a
    is Right -> b
}