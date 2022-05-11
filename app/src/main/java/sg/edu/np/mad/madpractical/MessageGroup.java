package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
        Button grp1 = findViewById(R.id.group1btn);
        Button grp2 = findViewById(R.id.group2btn);

        grp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView grp1txt = findViewById(R.id.group1);
                ImageView imageView = findViewById(R.id.bigandroidlogo);
                imageView.setVisibility(View.INVISIBLE);
                grp1txt.setText("Group 1");
            }
        });
        grp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = findViewById(R.id.bigandroidlogo);
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }
}