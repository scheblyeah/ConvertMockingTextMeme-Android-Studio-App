package de.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        message = convertToMemeFormat(message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // + to do button zum kopieren
    private String convertToMemeFormat(String string){
        char[] charArray = string.toCharArray();
        char[] result = new char[charArray.length];

        boolean lowerCase = true;
        for(int i = 0; i < charArray.length; i++){
            if(i != 0) {
                if (charArray[i - 1] == ' ') {
                    lowerCase = true;
                }
            }
            if(lowerCase){
                result[i] = Character.toLowerCase(charArray[i]);
                lowerCase = false;
            }
            else{
                result[i] = Character.toUpperCase(charArray[i]);
                lowerCase = true;
            }
        }
        String resultString = new String(result);
        return resultString;
    }
}