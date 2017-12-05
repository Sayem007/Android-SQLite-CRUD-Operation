## Android-SQLite-CRUD-Operation
A sample of well known Open Source Database- 'SQLite' based CRUD(Create, Read, Update, Delete) operation.

<br>

## Preview

![pr4](https://user-images.githubusercontent.com/29102285/33633505-4db65886-da3b-11e7-8f8f-5dc7ea54ea95.gif)

<br>

## Installation & Usage

* **Library**

Update build.gradle(Module: app) file with

    compile 'com.android.support:design:25.3.1'


* **Database Creation:**

    ```java
      
      public static String DATABASE_NAME = "teachers_data";
      private static final int DATABASE_VERSION = 1;
      private static final String TABLE_USER = "teachers";
      private static final String KEY_ID = "id";
      private static final String KEY_FIRSTNAME = "name";
      private static final String KEY_COURSE = "course";
      private static final String KEY_EMAIL = "email";
      private static final String KEY_PHONE = "phone";
      
    ```

**Table Creation:**

   ```java
        private static final String CREATE_TABLE_TEACHERS = "CREATE TABLE "
              + TABLE_USER + "(" + KEY_ID
              + " INTEGER PRIMARY KEY AUTOINCREMENT," +
              KEY_FIRSTNAME + " TEXT NOT NULL, "+
              KEY_COURSE + " TEXT NOT NULL, "+
              KEY_EMAIL + " TEXT NOT NULL, "+
              KEY_PHONE + " VARCHAR " +
              "); ";

      public DatabaseHelperTeacher(Context context) {
          super(context, DATABASE_NAME, null, DATABASE_VERSION);

          Log.d("table", CREATE_TABLE_TEACHERS);
      }

      @Override
      public void onCreate(SQLiteDatabase db) {
          db.execSQL(CREATE_TABLE_TEACHERS);
      }

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
          onCreate(db);
      }
   ```

**Creating method for adding data:**
    
        public long addTeachersDetail(String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        // Creating content values
        
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        values.put(KEY_COURSE, course);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE, phone);
        
        //insert row in table
        
        long insert = db.insert(TABLE_USER, null, values);

        return insert;
        }
        

**Adding data into Arraylist:**
   
          public ArrayList<TeachersModel> getAllTeachers() {
          ArrayList<TeachersModel> teachersModelArrayList = new ArrayList<TeachersModel>();

          String selectQuery = "SELECT  * FROM " + TABLE_USER;
          SQLiteDatabase db = this.getReadableDatabase();
          Cursor c = db.rawQuery(selectQuery, null);

          // looping through all rows and adding to list

          if (c.moveToFirst()) {
              do {
                  TeachersModel teachersModel = new TeachersModel();
                  teachersModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                  teachersModel.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));
                  teachersModel.setCourse(c.getString(c.getColumnIndex(KEY_COURSE)));
                  teachersModel.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                  teachersModel.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));

                  // adding to list

                  teachersModelArrayList.add(teachersModel);
              } while (c.moveToNext());
          }
          return teachersModelArrayList;
          }
          
**Creating method for updating value**

      public int updateTeachers(int id, String name, String course, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        values.put(KEY_COURSE, course);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PHONE, phone);
        // update row in table base on students.is value
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

**Creating method for deleting value**

    public void deleteUSer(int id) {

        // delete row in table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    
<br>
    
## License
Licenced under [APACHE](http://www.apache.org/licenses/LICENSE-2.0).
