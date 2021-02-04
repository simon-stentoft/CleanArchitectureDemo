package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanarchitecturedemo.R;

import model.Model;

public class AndroidView extends AppCompatActivity {
EditText editText;
TextView outputView;
Button enterButton;

private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText)findViewById(R.id.editText);
        editText.setText(model.getData()); //Anvender nu model for at få data

        outputView = (TextView)findViewById(R.id.outputView);
        outputView.setText(model.getData()); //Anvender nu model for at få data

        enterButton = (Button)findViewById(R.id.enterButton);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String string = editText.getText().toString();
            outputView.setText(string);
            }
        });

    }
}