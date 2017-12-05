package com.sayem.geeknot.sqlitecrud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyTeachersActivity extends AppCompatActivity {

    private TeachersModel teachersModel;
    private EditText etname, etcourse, etemail, etphone;
    private Button btnupdate, btndelete;
    private DatabaseHelperTeacher databaseHelperTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_teachers);

        Intent intent = getIntent();
        teachersModel = (TeachersModel) intent.getSerializableExtra("teachers");

        databaseHelperTeacher = new DatabaseHelperTeacher(this);

        etname = (EditText) findViewById(R.id.etname);
        etcourse = (EditText) findViewById(R.id.etcourse);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etname.setText(teachersModel.getName());
        etcourse.setText(teachersModel.getCourse());
        etemail.setText(teachersModel.getEmail());
        etphone.setText(teachersModel.getPhone());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperTeacher.updateTeachers(teachersModel.getId(),etname.getText().toString(),etcourse.getText().toString(),etemail.getText().toString(), etphone.getText().toString());
                Toast.makeText(ModifyTeachersActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyTeachersActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperTeacher.deleteUSer(teachersModel.getId());
                Toast.makeText(ModifyTeachersActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyTeachersActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}
