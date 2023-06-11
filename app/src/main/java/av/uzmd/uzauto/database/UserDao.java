package av.uzmd.uzauto.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<UserModel> getAll();

    @Query("SELECT * FROM user WHERE userId IN (:userIds)")
    List<UserModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :first AND " + "name LIKE :last LIMIT 1")
    UserModel findByName(String first, String last);

    @Query("SELECT * FROM user WHERE userId LIKE :id")
    UserModel findByID(int id);

    @Insert
    void insertAll(UserModel... users);

    @Delete
    void delete(UserModel user);

    @Query("DELETE FROM user WHERE userId = :id")
    void deleteById(int id);

    @Query("UPDATE user SET name = :newName  WHERE userId =:id")
    void update(String newName, int id);

}