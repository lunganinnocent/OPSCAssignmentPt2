import android.content.ContentValues
import android.content.Context;
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQLiteHelper (context:Context? ) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    var context: Context? = null


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, NUMBER TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists $TABLE_NAME")
    }

    fun insertData(name: String?, number: String? ){

        val db = writableDatabase
        val ContentValues = ContentValues()
        ContentValues.put(FullName, name )
        ContentValues.put(Password, number)
        ContentValues.put(ConfirmPassword, number)
        db.insert(TABLE_NAME, null, ContentValues)



    }

    companion object{

        private const val DATABASE_NAME = "BudgetDatabase"
        private const val TABLE_NAME = "Registration"
        private const val ID = "ID"
        private const val FullName ="Name"
        private const val Password = "Number"
        private const val ConfirmPassword = "Number"
    }



}