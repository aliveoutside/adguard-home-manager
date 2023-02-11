package ru.toxyxd.adguardhome.data.delegate

import android.content.Context
import android.os.Parcelable
import androidx.core.content.edit
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

inline fun <reified T> Context.sharedPrefs(key: String) = object : ReadWriteProperty<Any?, T> {
    val sharedPrefs by lazy {
        this@sharedPrefs.getSharedPreferences(
            "APP_DATA",
            Context.MODE_PRIVATE
        )
    }
    var newData: T = (T::class.java).newInstance()

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return get()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.newData = value
        put(newData)
    }

    fun put(value: T?) {
        sharedPrefs.edit {
            when (value) {
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                is Long -> putLong(key, value)
                is Float -> putFloat(key, value)
                is Parcelable -> putString(key, Json.encodeToString(value.toString()))
                else -> throw Throwable("no such type exist to put data")
            }
        }
    }

    fun get(): T {
        return when (newData) {
            is Int -> sharedPrefs.getInt(key, 0) as T
            is Boolean -> sharedPrefs.getBoolean(key, false) as T
            is String -> sharedPrefs.getString(key, "") as T ?: "" as T
            is Long -> sharedPrefs.getLong(key, 0L) as T
            is Float -> sharedPrefs.getFloat(key, 0.0f) as T
            is Parcelable -> Json.decodeFromString<T>(sharedPrefs.getString(key, "") ?: "")
            else -> throw Throwable("no such type exist to put data")
        } ?: newData
    }
}
