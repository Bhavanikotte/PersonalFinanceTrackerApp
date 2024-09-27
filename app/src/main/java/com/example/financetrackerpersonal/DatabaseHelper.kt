package com.example.financetrackerpersonal

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserDB.db"
        private const val TABLE_INCOME = "income"
        private const val TABLE_EXPENSES = "expenses"
        private const val TABLE_USERS = "users"
        private const val TABLE_BALANCES = "balances"

        private const val COLUMN_ID = "id"
        private const val COLUMN_FIRST_SOURCE = "first_source"
        private const val COLUMN_SECOND_SOURCE = "second_source"
        private const val COLUMN_THIRD_SOURCE = "third_source"
        private const val COLUMN_TOTAL_SALARY = "total_salary"
        private const val COLUMN_FOOD = "food"
        private const val COLUMN_CLOTHING = "clothing"
        private const val COLUMN_ACADEMY = "academy"
        private const val COLUMN_HOSPITAL = "hospital"
        private const val COLUMN_GROCERIES = "groceries"
        private const val COLUMN_TOTAL_EXPENDITURE = "total_expenditure"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_INSTITUTION = "institution"
        private const val COLUMN_DAILY_EXPENDITURE = "daily_expenditure"
        private const val COLUMN_MONTHLY_EXPENDITURE = "monthly_expenditure"
        private const val COLUMN_ANNUAL_EXPENDITURE = "annual_expenditure"
        private const val PREF_KEY_LOGGED_IN = "is_logged_in"
        private const val TABLE_NAME = "expenses"
        private const val COLUMN_CATEGORY = "category"
        private const val COLUMN_AMOUNT = "amount"
        private const val COLUMN_BUDGET = "budget"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createIncomeTableQuery = ("CREATE TABLE $TABLE_INCOME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_FIRST_SOURCE REAL, $COLUMN_SECOND_SOURCE REAL, $COLUMN_THIRD_SOURCE REAL, $COLUMN_TOTAL_SALARY REAL)")
        db?.execSQL(createIncomeTableQuery)

        val createExpensesTableQuery = ("CREATE TABLE $TABLE_EXPENSES ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_FOOD REAL, $COLUMN_CLOTHING REAL, $COLUMN_ACADEMY REAL, $COLUMN_HOSPITAL REAL, "
                + "$COLUMN_GROCERIES REAL, $COLUMN_TOTAL_EXPENDITURE REAL)")
        db?.execSQL(createExpensesTableQuery)

        val createUsersTableQuery = ("CREATE TABLE $TABLE_USERS ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_EMAIL TEXT, $COLUMN_PASSWORD TEXT, $COLUMN_INSTITUTION TEXT)")
        db?.execSQL(createUsersTableQuery)

        val createBalancesTableQuery = ("CREATE TABLE $TABLE_BALANCES ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_DAILY_EXPENDITURE REAL, $COLUMN_MONTHLY_EXPENDITURE REAL, $COLUMN_ANNUAL_EXPENDITURE REAL)")
        db?.execSQL(createBalancesTableQuery)

        val createTable = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_CATEGORY + " TEXT PRIMARY KEY,"
                + COLUMN_AMOUNT + " REAL,"
                + COLUMN_BUDGET + " REAL" + ")")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_INCOME")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_EXPENSES")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_BALANCES")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


//    fun isUserValid(email: String, password: String): Boolean {
//        val db = this.readableDatabase
//        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
//        val cursor = db.rawQuery(query, arrayOf(email, password))
//        val isValid = cursor.count > 0
//
//        cursor.close()
//        db.close()
//
//        return isValid
//    }

//    fun addUser(email: String, password: String) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_EMAIL, email)
//        values.put(COLUMN_PASSWORD, password)
//        db.insert(TABLE_USERS, null, values)
//        db.close()
//    }
//
//    fun isUserValid(email: String, password: String): Boolean {
//        val db = this.readableDatabase
//        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
//        val cursor = db.rawQuery(query, arrayOf(email, password))
//        val isValid = cursor.count > 0
//        cursor.close()
//        db.close()
//        return isValid
//    }
//

//    fun addUser(email: String, password: String, institution: String) {
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(COLUMN_EMAIL, email)
//        values.put(COLUMN_PASSWORD, password)
//        values.put(COLUMN_INSTITUTION, institution)
//        db.insert(TABLE_USERS, null, values)
//        db.close()
//    }
//
//    fun checkUser(email: String, password: String): Boolean {
//        val db = this.readableDatabase
//        val cursor: Cursor = db.query(
//            TABLE_USERS,
//            arrayOf(COLUMN_ID),
//            "$COLUMN_EMAIL=? AND $COLUMN_PASSWORD=?",
//            arrayOf(email, password),
//            null, null, null, null
//        )
//        val cursorCount = cursor.count
//        cursor.close()
//        db.close()
//        return cursorCount > 0
//    }

//    fun addUser(email: String, password: String,insti:String): Long {
//        val db = this.writableDatabase
//        val contentValues = ContentValues().apply {
//            put(COLUMN_EMAIL, email)
//            put(COLUMN_PASSWORD, password)
//            put(COLUMN_INSTITUTION, insti)
//        }
//        return db.insert(TABLE_USERS, null, contentValues)
//    }
//
//    // Check user credentials
//    fun checkUser(emailOrName: String, password: String): Boolean {
//        val db = this.readableDatabase
//        val cursor = db.rawQuery(
//            "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?",
//            arrayOf(emailOrName, password)
//        )
//        val count = cursor.count
//        cursor.close()
//        return count > 0
//    }

    fun addUser(email: String, password: String, insti: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_PASSWORD, password)
        values.put(COLUMN_INSTITUTION, insti)

        val result = db.insert(TABLE_USERS, null, values)
        db.close()
        return result != -1L
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))

        val isValid = cursor.count > 0
        cursor.close()
        db.close()
        return isValid
    }




    fun addIncome(firstSource: Double, secondSource: Double, thirdSource: Double, totalSalary: Double): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FIRST_SOURCE, firstSource)
            put(COLUMN_SECOND_SOURCE, secondSource)
            put(COLUMN_THIRD_SOURCE, thirdSource)
            put(COLUMN_TOTAL_SALARY, totalSalary)
        }
        val success = db.insert(TABLE_INCOME, null, values) != -1L
        db.close()
        return success
    }

    fun addExpenditure(food: Double, clothing: Double, academy: Double, hospital: Double, groceries: Double, totalExpenditure: Double): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FOOD, food)
            put(COLUMN_CLOTHING, clothing)
            put(COLUMN_ACADEMY, academy)
            put(COLUMN_HOSPITAL, hospital)
            put(COLUMN_GROCERIES, groceries)
            put(COLUMN_TOTAL_EXPENDITURE, totalExpenditure)
        }
        val success = db.insert(TABLE_EXPENSES, null, values) != -1L
        db.close()
        return success
    }

    fun getTotalIncome(): Double {
        var totalSalary = 0.0
        val db = this.readableDatabase
        val query = "SELECT SUM($COLUMN_TOTAL_SALARY) FROM $TABLE_INCOME"
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            totalSalary = cursor.getDouble(0)
        }
        cursor.close()
        db.close()
        return totalSalary
    }

    fun getTotalExpenditure(): Double {
        var totalExpenditure = 0.0
        val db = this.readableDatabase
        val query = "SELECT SUM($COLUMN_TOTAL_EXPENDITURE) FROM $TABLE_EXPENSES"
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            totalExpenditure = cursor.getDouble(0)
        }
        cursor.close()
        db.close()
        return totalExpenditure
    }


    fun addDailyExpenditure(dailyExpenditure: Double): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_DAILY_EXPENDITURE, dailyExpenditure)
        }
        val success = db.insert(TABLE_BALANCES, null, values) != -1L
        db.close()
        return success
    }

    fun addMonthlyExpenditure(monthlyExpenditure: Double): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_MONTHLY_EXPENDITURE, monthlyExpenditure)
        }
        val success = db.insert(TABLE_BALANCES, null, values) != -1L
        db.close()
        return success
    }

    fun addAnnualExpenditure(annualExpenditure: Double): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_ANNUAL_EXPENDITURE, annualExpenditure)
        }
        val success = db.insert(TABLE_BALANCES, null, values) != -1L
        db.close()
        return success
    }

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        sharedPreferences.edit().putBoolean(PREF_KEY_LOGGED_IN, isLoggedIn).apply()
    }

    fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(PREF_KEY_LOGGED_IN, false)
    }

    fun getDailyExpenditures(): List<Double> {
        val dailyExpenditures = mutableListOf<Double>()
        val db = this.readableDatabase
        val query = "SELECT $COLUMN_DAILY_EXPENDITURE FROM $TABLE_BALANCES ORDER BY $COLUMN_ID DESC"
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                dailyExpenditures.add(cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_DAILY_EXPENDITURE)))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return dailyExpenditures
    }

    fun getExpense(category: String): Pair<Double, Double> {
        val db = this.readableDatabase
        var currentExpense = 0.0
        var totalBudget = 0.0

        val query = "SELECT $COLUMN_AMOUNT, $COLUMN_BUDGET FROM $TABLE_NAME WHERE $COLUMN_CATEGORY = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(category))

        if (cursor.moveToFirst()) {
            val amountIndex = cursor.getColumnIndex(COLUMN_AMOUNT)
            val budgetIndex = cursor.getColumnIndex(COLUMN_BUDGET)

            if (amountIndex != -1 && budgetIndex != -1) {
                currentExpense = cursor.getDouble(amountIndex)
                totalBudget = cursor.getDouble(budgetIndex)
            }
        }

        cursor.close()
        db.close()

        return Pair(currentExpense, totalBudget)
    }

}