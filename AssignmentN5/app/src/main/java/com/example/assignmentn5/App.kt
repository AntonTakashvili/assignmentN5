package com.example.assignmentn5
import android.app.Application
import androidx.room.Room

class App : Application() {
    lateinit var db: DataBase
    companion object{
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        db = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            "User"
        ).allowMainThreadQueries().build()
    }

}