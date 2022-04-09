package com.example.assignmentn5

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM USER")
    fun getAll():List<User>
    @Query("SELECT AVG(runDistance) FROM USER")
    fun avgOfRunDis():Double
    @Query("SELECT SUM(runDistance) FROM USER")
    fun sumOfRunDis():Double
    @Query("SELECT SUM(runDistance) FROM USER")
    fun totalOfRunDis():Double
    @Query("SELECT AVG(swimDistance) FROM USER")
    fun avgOfSwimDis():Double
    @Query("SELECT AVG(calories) FROM USER")
    fun avgOfcals():Double
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
    @Delete
    fun del(user: User)
    @Query("DELETE FROM USER")
    fun delAll()
}