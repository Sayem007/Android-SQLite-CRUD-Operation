package com.sayem.geeknot.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCourseTeachers extends AppCompatActivity {

    private Button btnStore;
    private EditText etcourse, etphone;

    private DatabaseHelperTeacher databaseHelperTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_teachers);

        databaseHelperTeacher = new DatabaseHelperTeacher(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        final EditText etname = (EditText) findViewById(R.id.et_name);
        etcourse = (EditText) findViewById(R.id.et_course);
        final EditText etemail = (EditText) findViewById(R.id.et_email);
        etphone = (EditText) findViewById(R.id.et_phone);



        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                if (TextUtils.isEmpty(name)){
                    etname.setError("Enter Name");
                    etname.requestFocus();
                    return;
                }

                databaseHelperTeacher.addTeachersDetail(
                        etname.getText().toString(),
                        etcourse.getText().toString(),
                        etemail.getText().toString(),
                        etphone.getText().toString());

                etcourse.setText("");
                etphone.setText("");

                Toast.makeText(AddCourseTeachers.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddCourseTeachers.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}