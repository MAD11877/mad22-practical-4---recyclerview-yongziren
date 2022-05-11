package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Btn = findViewById(R.id.FOLLOW);

        Intent fromList = getIntent();
        String profilename = fromList.getStringExtra("RandomNum");
        String descriptions = fromList.getStringExtra("RandomDesc");
        User user = fromList.getParcelableExtra("currentUsers");
        if (user.Followed == true) {
            Btn.setText("UNFOLLOW");
        }
        else {
            Btn.setText("FOLLOW");
        }
        TextView textView = findViewById(R.id.HelloWorld);
        TextView descTest = findViewById(R.id.TestText);
        descTest.setText(descriptions);
        textView.setText(profilename);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user.Followed) {
                    Btn.setText("UNFOLLOW");
                    user.Followed = true;
                    Toast.makeText(MainActivity.this,"Followed",Toast.LENGTH_SHORT ).show();
                }
                else{
                    Btn.setText("FOLLOW");
                    user.Followed = false;
                    Toast.makeText(MainActivity.this,"Unfollowed",Toast.LENGTH_SHORT ).show();
                }
            }
        });

        Button msg = findViewById(R.id.MESSAGE);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_to_messagegroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(main_to_messagegroup);
            }
        });
    }
}