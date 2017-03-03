package ca.antany.simpleflashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddButton(View view){
        Intent in = new Intent(this,QuestionActivity.class);
        getApplicationContext().startActivity(in);
    }

    public void onClickStartButton(View view){

    }
}
