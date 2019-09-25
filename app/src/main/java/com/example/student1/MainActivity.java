package com.example.student1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_reception;
    private  TextView tv_classManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        initView();
    }

    private void initView() {

        tv_reception =findViewById( R.id.reception );
        tv_classManger = findViewById( R.id.stu_lesson );
        tv_classManger.setOnClickListener( this );


        Intent intent  = getIntent();
        String aa= intent.getStringExtra( "id" );

        tv_reception.setText("欢迎"+ aa +"来到学生空间");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.stu_lesson:

                Intent intent = new Intent( MainActivity.this, ListFragment.class );
                startActivity( intent );

                break;

        }

    }
}
