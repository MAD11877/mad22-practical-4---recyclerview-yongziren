package sg.edu.np.mad.madpractical;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    public static User user;
    ArrayList<User> data;
    Context c;
    public MessageAdapter(ArrayList<User> data, Context c) {
        this.data = data;
        this.c = c;
    }
    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.users, null, false);
        return new MessageViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        User content = data.get(position);
        user = content;
        holder.nme.setText(content.Name);
        holder.desc.setText(content.Description);
        String lastnum = content.Name;
        if (lastnum.endsWith("7")) {
            holder.img2.setVisibility(View.VISIBLE);
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nme = holder.itemView.findViewById(R.id.name);
                TextView desc = holder.itemView.findViewById(R.id.description);
                AlertDialog.Builder alert = new AlertDialog.Builder(c);
                alert.setTitle("Profile");
                alert.setMessage(nme.getText());
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent list_to_main = new Intent(c, MainActivity.class);
                        list_to_main.putExtra("RandomNum",content.Name);
                        list_to_main.putExtra("RandomDesc",content.Description);
                        list_to_main.putExtra("currentUsers", (Parcelable) user);
                        list_to_main.putExtra("position",data.indexOf(content));
                        c.startActivity(list_to_main);
                    }
                });
                alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
