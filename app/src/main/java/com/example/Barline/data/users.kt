package com.example.Barline.data

import androidx.room3.ColumnInfo
import androidx.room3.Dao
import androidx.room3.Database
import androidx.room3.Delete
import androidx.room3.Entity
import androidx.room3.Insert
import androidx.room3.PrimaryKey
import androidx.room3.Query
import androidx.room3.RoomDatabase


@Database(entities = [Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

@Entity
data class Users(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "username") val firstName: String,
    @ColumnInfo(name = "password") val lastName: String
)

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<Users>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<Users>

    /* @Query(
        """
        SELECT * FROM user
        WHERE username LIKE :first AND last_name LIKE :last LIMIT 1
        """
    ) */

    suspend fun findByName(first: String, last: String): Users

    @Insert
    suspend fun insertAll(vararg users: Users)

    @Delete
    suspend fun delete(user: Users)
}

