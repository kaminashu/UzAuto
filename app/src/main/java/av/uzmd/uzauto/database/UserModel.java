package av.uzmd.uzauto.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo
    public String name;
    public  String guruh;

}
