package com.aghogho.snoopandroidtask.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()

    /**
     *  overriding equals and hashCode to ensure that Resource instances are compared
     *  using memory references rather than their actual content
     * **/
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Resource<*>

        if (data != other.data) return false
        return message == other.message
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result = 31 * result + (message?.hashCode() ?: 0)
        return result
    }
}
