package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Observable;
import java.util.Observer;
import android.view.View;
import android.os.Bundle;

import com.example.cleanarchitecturedemo.R;

public class AndroidView extends AppCompatActivity {
EditText editText;
TextView outputView;


private LowerCasePresenter lowerCaseViewModel = new LowerCasePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        observeModel();

        outputView = (TextView)findViewById(R.id.outputView);
        outputView.setText(lowerCaseViewModel.getPresentableData());

        EditText inputText = (EditText) findViewById(R.id.inputText);
        inputText.setText(lowerCaseViewModel.getPresentableData());

      /*  enterButton = (Button)findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String string = editText.getText().toString();
            }
        });*/

    }
    private void observeModel() {
        lowerCaseViewModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof LowerCasePresenter) {
                    String data = ((LowerCasePresenter) o).getPresentableData();
                    TextView outputView = (TextView) findViewById(R.id.outputView);
                    outputView.setText(data);
                }
            }
        });
    }

    public void enterInput(View view) {
        EditText inputText = (EditText) findViewById(R.id.inputText);
        String input = inputText.getText().toString();
        lowerCaseViewModel.setData(input);
    }
}