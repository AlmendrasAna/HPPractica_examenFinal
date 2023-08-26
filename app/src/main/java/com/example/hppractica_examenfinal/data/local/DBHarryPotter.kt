package com.example.hppractica_examenfinal.data.local
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[CharacterEntity::class], version =1)
abstract class DBHarryPotter  : RoomDatabase(){

    abstract fun getDaoHP(): DaoHP

    companion object {
        @Volatile
        private var INSTANCE: DBHarryPotter? = null

        fun getDatabase(context: Context):DBHarryPotter {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBHarryPotter::class.java,
                    "Phone_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}

