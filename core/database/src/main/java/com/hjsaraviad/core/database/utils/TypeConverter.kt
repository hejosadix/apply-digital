package com.hjsaraviad.core.database.utils


import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.koin.java.KoinJavaComponent.inject

class TypeConverter {

    companion object {
        private val moshi: Moshi by inject(
            Moshi::class.java
        )

        @JvmStatic
        @TypeConverter
        fun stringToListString(data: String?): List<String>? {
            if (data == null) {
                return null
            }

            val listType = Types.newParameterizedType(List::class.java, String::class.java)
            val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)

            return adapter.fromJson(data)
        }

        @JvmStatic
        @TypeConverter
        fun listStringToString(strings: List<String>): String {
            val membersType = Types.newParameterizedType(List::class.java, String::class.java)
            val membersAdapter = moshi.adapter<List<String>>(membersType)
            return membersAdapter.toJson(strings)
        }
    }
}