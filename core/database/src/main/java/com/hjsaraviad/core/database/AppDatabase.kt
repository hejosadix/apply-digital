package com.hjsaraviad.core.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hjsaraviad.core.database.comment.CommentDao
import com.hjsaraviad.core.database.comment.CommentEntity
import com.hjsaraviad.core.database.utils.TypeConverter

@Database(
    entities = [CommentEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [TypeConverter::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}