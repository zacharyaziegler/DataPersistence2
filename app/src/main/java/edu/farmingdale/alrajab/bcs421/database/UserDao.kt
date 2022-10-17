package edu.farmingdale.alrajab.bcs421.database

import androidx.room.*
import androidx.room.OnConflictStrategy.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Insert(onConflict = REPLACE)
    fun addUser(user: User): Long

    @Delete
    fun delete(user: User)
}