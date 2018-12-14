package db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.createTable

class TMDatabaseOpenHelper (context:Context):ManagedSQLiteOpenHelper(context,"tmdb.db",null,1)
{
    companion object {
        val tableName = "tm"
        private  var instance :TMDatabaseOpenHelper? = null;

        fun getInstance(context: Context):TMDatabaseOpenHelper{
            return instance ?: TMDatabaseOpenHelper(context.applicationContext)!!
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.run { createTable(tableName,ifNotExists = true,
            columns = *arrayOf( "date" to TEXT, "tension" to TEXT, "comment" to TEXT))
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }


}